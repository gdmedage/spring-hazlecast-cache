package com.org.cache.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.cache.api.model.ticket.Ticket;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
