package parking_citation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * @author Alexis Arriola
 * Serves as the controller for the citation system.
 */
public class CitationController 
{
    CitationModel citationModel;
    CitationView citationView;
    int currentIndex;
    int ticketCount;
    
    public CitationController(CitationModel citationModel, CitationView citationView) 
    {
        //reference to the M and V
        this.citationModel = citationModel;
        this.citationView = citationView;
        this.currentIndex = 0;
        this.ticketCount = 0;
        
        attachHandlers();
    }
    
    /**
     * Attaches handlers to their respected buttons.
     */
    public void attachHandlers()
    {
        //button actions
        citationView.getAddBtn().setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                boolean blank = false;
                //get information from view
                String id = citationView.getIdTF().getText();
                if (id.equalsIgnoreCase(""))
                    blank = true;
                String license = citationView.getLicenseTF().getText();
                if (license.equalsIgnoreCase(""))
                    blank = true;
                String state = citationView.getStateTF().getText();
                if (state.equalsIgnoreCase(""))
                    blank = true;
                String permit = citationView.getPermitTF().getText();
                if (permit.equalsIgnoreCase(""))
                    blank = true;
                String vehicle = citationView.getVehicleTF().getText();
                if (vehicle.equalsIgnoreCase(""))
                    blank = true;
                String color = citationView.getColorTF().getText();
                if (color.equalsIgnoreCase(""))
                    blank = true;
                String date = citationView.getDateTF().getText();
                if (date.equalsIgnoreCase(""))
                    blank = true;
                String location = citationView.getLocationTF().getText();
                if (location.equalsIgnoreCase(""))
                    blank = true;
                String time = citationView.getTimeTF().getText();
                if (time.equalsIgnoreCase(""))
                    blank = true;
                String issued = citationView.getIssuedTF().getText();
                if (issued.equalsIgnoreCase(""))
                    blank = true;
                String reason = citationView.getReasonTF().getText();
                if (reason.equalsIgnoreCase(""))
                    blank = true;
                String feedback = citationView.getFeedbackText().getText();
                
                
                if (blank)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message");
                    alert.setHeaderText("Blank field");
                    alert.setContentText("Cannot have any blank fields!");
                    alert.showAndWait();
                }
                else
                {
                    ParkingCitation currentCitation = new ParkingCitation(Integer.parseInt(id), false, license, state,
                                                           permit, vehicle, color,
                                                           date, location, time,
                                                           issued, reason, feedback, "Unpaid");
                   citationModel.addTicket(currentCitation);
                   citationView.clearFields(); 
                }
                
            }
        });
        citationView.getPrintBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                if (!citationModel.getTickets().isEmpty())
                {
                    ParkingCitation currentCitation = citationModel.getTickets().get(currentIndex);
                    citationView.printCurrentTicket(currentCitation);
                }
            }
        });
        citationView.getLeftBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                if (currentIndex != 0)
                {
                    currentIndex--;
                    ParkingCitation currentCitation = citationModel.getTickets().get(currentIndex);
                    citationView.printCurrentTicket(currentCitation);
                }
            }
        });
        citationView.getRightBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                if (currentIndex < citationModel.getTickets().size()-1)
                {
                    currentIndex++;
                    ParkingCitation currentCitation = citationModel.getTickets().get(currentIndex);
                    citationView.printCurrentTicket(currentCitation);
                }
            }
        });
        citationView.getPayBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                if (ticketCount != 0)
                {
                    boolean pay = citationModel.getTickets().get(currentIndex).getPaid();
                    citationModel.getTickets().get(currentIndex).setPaid(!pay);
                    ParkingCitation currentCitation = citationModel.getTickets().get(currentIndex);
                    citationView.printCurrentTicket(currentCitation);
                }
            }
        });
        citationView.getReadBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                ticketCount = citationModel.readTickets();
            }
        });
        citationView.getViewBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                citationView.clearTA();
                for (ParkingCitation tick : citationModel.getTickets())
                {
                    citationView.printTicket(tick);
                }
            }
        });
        citationView.getExitBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }
}
