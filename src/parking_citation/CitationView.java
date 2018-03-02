package parking_citation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Alexis Arriola
 * Extends the BorderPane class to be used as the main view of the citation system.
 */
public class CitationView extends BorderPane
{  
    //the different gui components
    private GridPane ticketForm = new GridPane();  //center - citation form
    private VBox buttonBox = new VBox();           //left - Vertical box that is going to hold buttons
    private HBox viewBtnBox = new HBox();
    private VBox feedbackBox = new VBox();
    
    
    //ticket form area variables
    private VBox ticketFormBox = new VBox();
    //labels
    private Label currentLbl = new Label("Current Citation");
    private Label titleLbl = new Label("Citation Form");
    private Label licenseLbl = new Label("License Number");
    private Label stateLbl = new Label("State");
    private Label permitLbl = new Label("Permit Number");
    private Label vehicleLbl = new Label("Vehicle");
    private Label colorLbl = new Label("Color");
    private Label dateLbl = new Label("Date");
    private Label locationLbl = new Label("Location");
    private Label timeLbl = new Label("Time");
    private Label issuedLbl = new Label("Issued By");
    private Label reasonLbl = new Label("Reason");
    //textfields
    private TextField licenseTF = new TextField();
    private TextField stateTF = new TextField();
    private TextField permitTF = new TextField();
    private TextField vehicleTF = new TextField();
    private TextField colorTF = new TextField();
    private TextField dateTF = new TextField();
    private TextField locationTF = new TextField();
    private TextField timeTF = new TextField();
    private TextField issuedTF = new TextField();
    private TextField reasonTF = new TextField();
    //textArea
    private TextArea  currentText = new TextArea();
    //buttons
    private Button leftBtn = new Button("<<");
    private Button rightBtn = new Button(">>");
    
    //payment area variables
    private String paymentInfo;
    private Label paymentLbl = new Label("Payment Information");
    private TextArea paymentText = new TextArea();
    int height,width;
    
    //button area variables
    private Button addBtn = new Button("Add Citation");
    private Button printBtn = new Button("Print Citation");
    private Button payBtn = new Button("Paid/Unpaid");
    private Button exitBtn = new Button("Exit System");
    
    //feedback area variables
    private TextArea feedbackText = new TextArea();
    private Label feedbackLbl = new Label("Feedback");
    
    public CitationView() 
    {
        //set padding for the BP
        this.setPadding(new Insets(10, 250, 10, 250));
        
        //setup ticket form area
        currentLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
        titleLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
        height = 370;
        width = 250;
        currentText.setMaxSize(width, height);
        currentText.setEditable(false);
        ticketForm.setHgap(10);
        ticketFormBox.getChildren().addAll(licenseLbl, licenseTF, stateLbl, stateTF,
                                           permitLbl, permitTF, vehicleLbl, vehicleTF,
                                           colorLbl, colorTF,  reasonLbl, reasonTF, dateLbl, dateTF, locationLbl,
                                           locationTF, timeLbl, timeTF, issuedLbl, issuedTF);
        viewBtnBox.getChildren().addAll(leftBtn,rightBtn);
        viewBtnBox.setSpacing(183);
        ticketForm.add(titleLbl, 0, 0);
        ticketForm.add(ticketFormBox, 0, 1);
        ticketForm.add(currentLbl, 1,0);
        ticketForm.add(currentText, 1,1);
        ticketForm.add(viewBtnBox, 1, 2);
        ticketForm.setAlignment(Pos.CENTER);
        
        //setup paymentInfo text area
        paymentLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
        paymentInfo = "PAYMENTS \n\n" + "Payments can be made at the following office: \n"
                    + "Business Office, Tandy 107 \n" + "Monday thru Friday: 8:00 am-5:00 pm\n"
                    + "$25 per citation, other fees may apply\n" + "$100 for boot removal\n\n"
                    + "Payment can be mailed to the following address:\n" + "TSC\n" + "C/O Finance Dept\n"
                    + "ATTN: Parking Enforcement\n" + "80 Fort Brown\n" + "80 Fort Brown\n"
                    + "Brownsville, TX 78520\n\n" + "DO NOT MAIL IN CASH! \n\n"
                    + "For more information on parking citations please visit:\n" + "www.tsc.edu/parking\n";
        height = 370;
        width = 305;
        paymentText.setMaxSize(width, height);
        paymentText.appendText(paymentInfo);
        paymentText.setEditable(false);
        ticketForm.add(paymentLbl, 2, 0);
        ticketForm.add(paymentText, 2, 1);
        
        //buttonbox
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(3);
        printBtn.setPrefWidth(100);
        addBtn.setPrefWidth(100);
        payBtn.setPrefWidth(100);
        exitBtn.setPrefWidth(100);
        buttonBox.getChildren().addAll(addBtn, printBtn, payBtn, exitBtn);
        
        //feedback
        feedbackLbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
        feedbackBox.getChildren().addAll(feedbackLbl, feedbackText);
                
        //set nodes in their respected areas
        this.setCenter(ticketForm);
        this.setLeft(buttonBox);
        this.setBottom(feedbackBox);
        
    }
    
    //properties
    //button properties
    public Button getAddBtn() {
        return addBtn;
    }
    public void setAddBtn(Button addBtn) {
        this.addBtn = addBtn;
    }
    public Button getPrintBtn() {
        return printBtn;
    }
    public void setPrintBtn(Button printBtn) {
        this.printBtn = printBtn;
    }
    public Button getPayBtn() {
        return payBtn;
    }
    public void setPayBtn(Button payBtn) {
        this.payBtn = payBtn;
    }
    public Button getExitBtn() {
        return exitBtn;
    }
    public void setExitBtn(Button exitBtn) {
        this.exitBtn = exitBtn;
    }
    public Button getLeftBtn() {
        return leftBtn;
    }
    public void setLeftBtn(Button leftBtn) {
        this.leftBtn = leftBtn;
    }
    public Button getRightBtn() {
        return rightBtn;
    }
    public void setRightBtn(Button rightBtn) {
        this.rightBtn = rightBtn;
    }
    //label properties
    public Label getCurrentLbl() {
        return currentLbl;
    }
    public void setCurrentLbl(Label currentLbl) {
        this.currentLbl = currentLbl;
    }
    public Label getTitleLbl() {
        return titleLbl;
    }
    public void setTitleLbl(Label titleLbl) {
        this.titleLbl = titleLbl;
    }
    public Label getLicenseLbl() {
        return licenseLbl;
    }
    public void setLicenseLbl(Label licenseLbl) {
        this.licenseLbl = licenseLbl;
    }
    public Label getStateLbl() {
        return stateLbl;
    }
    public void setStateLbl(Label stateLbl) {
        this.stateLbl = stateLbl;
    }
    public Label getPermitLbl() {
        return permitLbl;
    }
    public void setPermitLbl(Label permitLbl) {
        this.permitLbl = permitLbl;
    }
    public Label getVehicleLbl() {
        return vehicleLbl;
    }
    public void setVehicleLbl(Label vehicleLbl) {
        this.vehicleLbl = vehicleLbl;
    }
    public Label getColorLbl() {
        return colorLbl;
    }
    public void setColorLbl(Label colorLbl) {
        this.colorLbl = colorLbl;
    }
    public Label getDateLbl() {
        return dateLbl;
    }
    public void setDateLbl(Label dateLbl) {
        this.dateLbl = dateLbl;
    }
    public Label getLocationLbl() {
        return locationLbl;
    }
    public void setLocationLbl(Label locationLbl) {
        this.locationLbl = locationLbl;
    }
    public Label getTimeLbl() {
        return timeLbl;
    }
    public void setTimeLbl(Label timeLbl) {
        this.timeLbl = timeLbl;
    }
    public Label getIssuedLbl() {
        return issuedLbl;
    }
    public void setIssuedLbl(Label issuedLbl) {
        this.issuedLbl = issuedLbl;
    }
    public Label getReasonLbl() {
        return reasonLbl;
    }
    public void setReasonLbl(Label reasonLbl) {
        this.reasonLbl = reasonLbl;
    }
    public Label getPaymentLbl() {
        return paymentLbl;
    }
    public void setPaymentLbl(Label paymentLbl) {
        this.paymentLbl = paymentLbl;
    }
    public Label getFeedbackLbl() {
        return feedbackLbl;
    }
    public void setFeedbackLbl(Label feedbackLbl) {
        this.feedbackLbl = feedbackLbl;
    }
    //textfield properties
    public TextField getLicenseTF() {
        return licenseTF;
    }
    public void setLicenseTF(TextField licenseTF) {
        this.licenseTF = licenseTF;
    }
    public TextField getStateTF() {
        return stateTF;
    }
    public void setStateTF(TextField stateTF) {
        this.stateTF = stateTF;
    }
    public TextField getPermitTF() {
        return permitTF;
    }
    public void setPermitTF(TextField permitTF) {
        this.permitTF = permitTF;
    }
    public TextField getVehicleTF() {
        return vehicleTF;
    }
    public void setVehicleTF(TextField vehicleTF) {
        this.vehicleTF = vehicleTF;
    }
    public TextField getColorTF() {
        return colorTF;
    }
    public void setColorTF(TextField colorTF) {
        this.colorTF = colorTF;
    }
    public TextField getDateTF() {
        return dateTF;
    }
    public void setDateTF(TextField dateTF) {
        this.dateTF = dateTF;
    }
    public TextField getLocationTF() {
        return locationTF;
    }
    public void setLocationTF(TextField locationTF) {
        this.locationTF = locationTF;
    }
    public TextField getTimeTF() {
        return timeTF;
    }
    public void setTimeTF(TextField timeTF) {
        this.timeTF = timeTF;
    }
    public TextField getIssuedTF() {
        return issuedTF;
    }
    public void setIssuedTF(TextField issuedTF) {
        this.issuedTF = issuedTF;
    }
    public TextField getReasonTF() {
        return reasonTF;
    }
    public void setReasonTF(TextField reasonTF) {
        this.reasonTF = reasonTF;
    }
    public TextArea getFeedbackText() {
        return feedbackText;
    }
    public void setFeedbackText(TextArea feedbackText) {
        this.feedbackText = feedbackText;
    }
    
    //functions
    /**
     * Prints current citation to the text area.
     * @param currentCitation 
     */
    public void printCurrentTicket(ParkingCitation currentCitation)
    {
        String info = 
                    "Ticket No: " + currentCitation.getTicketNo()
                    + "\nLicense No: " + currentCitation.getLicenseNo() 
                    + "\nState: " + currentCitation.getState() 
                    + "\nPermit No: " + currentCitation.getPermitNo() 
                    + "\nVehicle Make/Model: " + currentCitation.getVehicle() 
                    + "\nColor: " + currentCitation.getColor() 
                    + "\nReason: " + currentCitation.getReason() 
                    + "\nDate: " + currentCitation.getDate() 
                    + "\nLocation: " + currentCitation.getLocation() 
                    + "\nTime: " + currentCitation.getTime() 
                    + "\nIssued By: " + currentCitation.getIssuedBy()
                    + "\nTicket Status: " + currentCitation.getStatus()
                    + "\nFeedback: " + currentCitation.getFeedback();
        currentText.clear();
        currentText.appendText(info);
    }
    
    /**
     * Clears the GUI text fields.
     */
    public void clearFields()
    {
        getLicenseTF().clear();
        getStateTF().clear();
        getPermitTF().clear();
        getVehicleTF().clear();
        getColorTF().clear();
        getDateTF().clear();
        getLocationTF().clear();
        getTimeTF().clear();
        getIssuedTF().clear();
        getReasonTF().clear();
        getFeedbackText().clear();
    }
}
