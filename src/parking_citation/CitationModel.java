package parking_citation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * @author Alexis Arriola
 * Serves as the database for the ticket system.
 */
public class CitationModel 
{
    //data
    private ArrayList <ParkingCitation> tickets = new ArrayList<>();
    File file = new File("tickets.dat");
    
    
    public CitationModel()
    {
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Exception creating file: " + e);
        }
        
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
     * Adds a ticket to the ticket database.
     * @param tick 
     */
    public void addTicket(ParkingCitation tick)
    {
        getTickets().add(tick);
    }
    /**
     * Stores a ticket to the ticket file.
     * @param tick
     */
    public void storeTickets()
    {
        try(OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file)))
        {
            for (ParkingCitation tick : tickets)
            {
                out.flush();
                out.append("ticketNo\n");
                out.append(Integer.toString(tick.getTicketNo()) + "\n");
                out.append("licenseNo\n");
                out.append(tick.getLicenseNo() + "\n");
                out.append("state\n");
                out.append(tick.getState() + "\n");
                out.append("permit\n");
                out.append(tick.getPermitNo() + "\n");
                out.append("vehicle\n");
                out.append(tick.getVehicle() + "\n");
                out.append("color\n");
                out.append(tick.getColor() + "\n");
                out.append("reason\n");
                out.append(tick.getReason() + "\n");
                out.append("date\n");
                out.append(tick.getDate() + "\n");
                out.append("location\n");
                out.append(tick.getLocation() + "\n");
                out.append("time\n");
                out.append(tick.getTime() + "\n");
                out.append("issuer\n");
                out.append(tick.getIssuedBy() + "\n");
                out.append("status\n");
                out.append(tick.getStatus() + "\n");
                out.append("feedback\n");
                out.append(tick.getFeedback() + "\n");
            }
            out.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception storing ticket: " + e);
        }
    }
    
    public void readTickets()
    {
        //open the file
        try (BufferedReader in = new BufferedReader(new FileReader(file)))
        {
            String line;
            boolean stats;
            while ((line = in.readLine()) != null)
            {
                int ticketCount = Integer.parseInt(in.readLine());
                line = in.readLine();
                String license = in.readLine();
                line = in.readLine();
                String state = in.readLine();
                line = in.readLine();
                String permit = in.readLine();
                line = in.readLine();
                String vehicle = in.readLine();
                line = in.readLine();
                String color = in.readLine();
                line = in.readLine();
                String reason = in.readLine();
                line = in.readLine();
                String date = in.readLine();
                line = in.readLine();
                String location = in.readLine();
                line = in.readLine();
                String time = in.readLine();
                line = in.readLine();
                String issued = in.readLine();
                line = in.readLine();
                String status = in.readLine();
                line = in.readLine();
                String feedback = in.readLine();
                if(status.equals("Unpaid"))
                    stats = false;
                else
                    stats = true;
                    
                ParkingCitation currentCitation = new ParkingCitation(ticketCount, stats, license, state,
                                                           permit, vehicle, color,
                                                           date, location, time,
                                                           issued, reason, feedback);
                addTicket(currentCitation);
            }
            in.close();
        }
        catch (Exception e)
        {
            System.out.println("Exception opening file to read: " + e);
        }
    }
}
