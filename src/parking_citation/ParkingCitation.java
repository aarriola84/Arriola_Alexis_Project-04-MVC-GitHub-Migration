package parking_citation;

/**
 * @author Alexis Arriola
 * Represents a ticket in the citation system.
 */
public class ParkingCitation 
{
    //data
    private int    ticketNo;
    private boolean paid;
    private String licenseNo;
    private String state;
    private String permitNo;
    private String vehicle;
    private String color;
    private String date;
    private String location;
    private String time;
    private String issuedBy;
    private String reason;
    private String status;
    private String feedback;
    
    //constructor
    public ParkingCitation(int ticketNo, boolean paid, String licenseNo, String state, String permitNo, String vehicle, 
            String color, String date, String location, String time, String issuedBy, String reason, String feedback)
    {
        this.ticketNo = ticketNo;
        this.paid = paid;
        this.licenseNo = licenseNo;
        this.state = state;
        this.permitNo = permitNo;
        this.vehicle = vehicle;
        this.color = color;
        this.date = date;
        this.location = location;
        this.time = time;
        this.issuedBy = issuedBy;
        this.reason = reason;
        this.status = "Unpaid";
        this.feedback = feedback;
    }
    
    //properties
    public int getTicketNo() {
        return ticketNo;
    }
    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }
    public boolean getPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public String getLicenseNo() {
        return licenseNo;
    }
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPermitNo() {
        return permitNo;
    }
    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }
    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getIssuedBy() {
        return issuedBy;
    }
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStatus() {
        if (paid)
            status = "Paid";
        else
            status = "Unpaid";
        return status;
    }
    public void setStatus(String status) {
        this.reason = status;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
