package parking_citation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
                //get information from view
                ticketCount++;
                String license = citationView.getLicenseTF().getText();
                String state = citationView.getStateTF().getText();
                String permit = citationView.getStateTF().getText();
                String vehicle = citationView.getVehicleTF().getText();
                String color = citationView.getColorTF().getText();
                String date = citationView.getDateTF().getText();
                String location = citationView.getLocationTF().getText();
                String time = citationView.getTimeTF().getText();
                String issued = citationView.getIssuedTF().getText();
                String reason = citationView.getReasonTF().getText();
                String feedback = citationView.getFeedbackText().getText();
                
                ParkingCitation currentCitation = new ParkingCitation(ticketCount, false, license, state,
                                                           permit, vehicle, color,
                                                           date, location, time,
                                                           issued, reason, feedback);
                citationModel.addTicket(currentCitation);
                citationView.clearFields();
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
        citationView.getExitBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }
}
