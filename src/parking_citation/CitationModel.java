package parking_citation;

import java.util.ArrayList;

/**
 * @author Alexis Arriola
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
    public void addTicket(ParkingCitation tick)
    {
        getTickets().add(tick);
    }
}
