package support.controller;

import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import support.exception.UnknownProductException;
import support.model.Ticket;
import support.model.TicketCreationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import support.model.TicketUpdateRequest;
import support.service.TicketService;
import support.service.UpdateTicketService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final UpdateTicketService updateTicketService;

    @PostMapping("/ticket")
    public Ticket createTicket(@RequestBody TicketCreationRequest ticketCreationRequest){
        return this.ticketService.createTicket(ticketCreationRequest);
    }

    @PostMapping("/ticket/update")
    public Ticket createTicket(@RequestBody TicketUpdateRequest ticketCreationRequest){
        return this.updateTicketService.updateTicketInfo(ticketCreationRequest);
    }

    @GetMapping("/ticket")
    public List<Ticket> getTicketsSummary(){
        return this.ticketService.findAllTickets();
    }

    @GetMapping("/ticket/product/{productId}")
    public List<Ticket> getTicketsByProductId(@PathVariable long productId){
        List<Ticket> tickets = this.ticketService.findByProductId(productId);
        if(tickets.isEmpty()){
            throw new UnknownProductException();
        }
        return tickets;
    }

    @GetMapping("/ticket/{ticketId}")
    public Ticket getTicketInfo(@PathVariable long ticketId){
        return this.ticketService.findTicketInfo(ticketId);
    }

    @DeleteMapping("/ticket/{ticketId}")
    public void deleteTicket(@PathVariable long ticketId){
        this.ticketService.deleteTicket(ticketId);
    }


}
