package com.redtruelove.usherhits.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.redtruelove.usherhits.entity.Event;

public interface EventService {
	
	Page<Event> getAllEvents(Pageable page);
	
	Event getEventById(Long id);
	
	void deleteEventById(Long id);
	
	Event saveEventDetails(Event event);
	
	Event updateEventDetails(Long id, Event event);
}
