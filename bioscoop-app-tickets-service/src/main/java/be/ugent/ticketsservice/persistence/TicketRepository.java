package be.ugent.ticketsservice.persistence;

import be.ugent.ticketsservice.domain.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {


        public List<Ticket> findByDateBookedAfter(LocalDate datum);
        public List<Ticket> findByDateBookedBefore(LocalDate datum);



}
