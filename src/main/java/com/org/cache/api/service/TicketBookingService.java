package com.org.cache.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.cache.api.dao.TicketBookingDao;
import com.org.cache.api.model.ticket.Ticket;


@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	@Cacheable(value="userCache",key="#ticketId",unless="#result==null")
	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId).orElse(null);
	}
	
	@CacheEvict(value="userCache",key="#ticketId")
	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}
	
	@CachePut(value="ticketsCache",key="#ticketId")
	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket upadedTicket = null;
		Ticket ticketFromDb = ticketBookingDao.findById(ticketId).orElse(null);
		if(ticketFromDb != null){
			ticketFromDb.setEmail(newEmail);
			upadedTicket = ticketBookingDao.save(ticketFromDb);	
		}
		return upadedTicket;
	}
}
