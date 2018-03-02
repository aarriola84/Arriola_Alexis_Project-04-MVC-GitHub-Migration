package parking_citation;

import java.util.ArrayList;

/**
 * @author Alexis Arriola
 * Serves as the database for the ticket system.
 */
public class CitationModel 
{
    //data
    private ArrayList <ParkingCitation> tickets = new ArrayList<>();
    
    //properties
    public ArrayList <ParkingCitation> getTickets() {
        return tickets;
    }
    public void setTickets(ArrayList <ParkingCitation> tickets) {
        this.tickets = tickets;
    }
    
    //functions
    /**
     * Adds a ticket to the ticket database.
     * @param tick 
     */
    public void addTicket(ParkingCitation tick)
    {
        getTickets().add(tick);
    }
}
