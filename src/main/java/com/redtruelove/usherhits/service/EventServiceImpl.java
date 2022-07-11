package com.redtruelove.usherhits.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.redtruelove.usherhits.entity.Event;
import com.redtruelove.usherhits.repository.EventRepository;
import com.redtruelove.usherhits.exceptions.UsherEventNotFoundException;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public Page<Event> getAllEvents(Pageable page) {
		return eventRepo.findAll(page);
	}

	@Override
	public Event getEventById(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		if (event.isPresent()) {
			return event.get();
		}
		throw new UsherEventNotFoundException("Event is not found" +id);
	}

	@Override
	public void deleteEventById(Long id) {
		eventRepo.deleteById(id);
	}

	@Override
	public Event saveEventDetails(Event event) {
		return eventRepo.save(event);
	}

	@Override
	public Event updateEventDetails(Long id, Event event) {
		Event existingEvent = getEventById(id);
		existingEvent.setName(event.getName() != null ? event.getName() : existingEvent.getName());
		existingEvent.setDescription(event.getDescription() != null ? event.getDescription() : existingEvent.getDescription());
		existingEvent.setCategory(event.getCategory() != null ? event.getCategory() : existingEvent.getCategory());
		existingEvent.setFee(event.getFee() != null ? event.getFee() : existingEvent.getFee());
		existingEvent.setDate(event.getDate() != null ? event.getDate() : existingEvent.getDate());
		return eventRepo.save(existingEvent);
	}

}
