package parking_citation;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 * @author Alexis Arriola
 * Serves as the database for the ticket system.
 */
public class CitationModel 
{
    //data
    private ArrayList <ParkingCitation> tickets = new ArrayList<>();
    Database db = Database.getSingletonOfdatabase();
    
    public CitationModel()
    {
    } 
    
    //properties
    public ArrayList <ParkingCitation> getTickets() {
        return tickets;
    }
    public void setTickets(ArrayList <ParkingCitation> tickets) {
        this.tickets = tickets;
    }
    
    //functions
    /**
     * Adds a ticket to the citation database.
     * @param tick 
     */
    public void addTicket(ParkingCitation tick)
    {
        try
        {
            Connection conn = db.getConn();
            Statement stmt = db.getStmnt();
            ResultSet rs = db.getResul();
        
            rs = stmt.executeQuery("select * from citation where id = " + tick.getTicketNo());
            if (!rs.next())
            {
                PreparedStatement prepStmnt = conn.prepareStatement("INSERT into citation VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                prepStmnt.setInt(1, tick.getTicketNo());
                prepStmnt.setInt(2, 0);
                prepStmnt.setString(3, tick.getLicenseNo());
                prepStmnt.setString(4, tick.getState());
                prepStmnt.setString(5, tick.getPermitNo());
                prepStmnt.setString(6, tick.getVehicle());
                prepStmnt.setString(7, tick.getColor());
                prepStmnt.setString(8, tick.getDate());
                prepStmnt.setString(9, tick.getLocation());
                prepStmnt.setString(10, tick.getTime());
                prepStmnt.setString(11, tick.getIssuedBy());
                prepStmnt.setString(12, tick.getReason());
                prepStmnt.setString(13, tick.getStatus());
                prepStmnt.setString(14, tick.getFeedback());
                prepStmnt.executeUpdate();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Duplicate Ticket Number");
                alert.setContentText("Cannot add a ticket with the same ticket no.");
                alert.showAndWait();
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error adding citation to db: " + e);
        }
    }
    
    /***
     * Reads the tickets from the database schema and returns the total ticket count.
     * @return 
     */
    public int readTickets()
    {
        boolean paid = false;
        int tickCnt = 0;
        tickets.clear();
        try
        {
            //get the statement from db
            Statement stmt = db.getStmnt();
            ResultSet rs = db.getResul();
        
            rs = stmt.executeQuery("select * from citation");
            while (rs.next())
            {
                if(rs.getInt("paid") > 0)
                    paid = true;
                else
                    paid = false;
                ParkingCitation currTick = new ParkingCitation(
                rs.getInt("id"),
                paid,
                rs.getString("licenseNo"),
                rs.getString("state"),
                rs.getString("permitNo"),
                rs.getString("vehicle"),
                rs.getString("color"),
                rs.getString("date"),
                rs.getString("location"),
                rs.getString("time"),
                rs.getString("issuer"),
                rs.getString("reason"),
                rs.getString("feedback"),
                rs.getString("status"));
                
                tickCnt++;
                tickets.add(currTick);
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error retrieving from db: " + e);
        }
        
        return tickCnt;
    }
}
