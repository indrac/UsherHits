package com.redtruelove.usherhits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redtruelove.usherhits.entity.Event;
import com.redtruelove.usherhits.service.EventService;

@RestController
public class UsherEventsController {
	
	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public List<Event> getAllEvents(Pageable page) {
		return eventService.getAllEvents(page).toList();
	}
	
	@GetMapping("/events/{id}")
	public Event getEventById(@PathVariable("id") Long id) {
		return eventService.getEventById(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/events")
	public void deleteEventById(@RequestParam("id") Long id) {
		eventService.deleteEventById(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/events")
	public Event saveEventDetails(@RequestBody Event event) {
		return eventService.saveEventDetails(event);
	}
	
	@PutMapping("/events/{id}")
	public Event updateEventDetails(@RequestBody Event event, @PathVariable Long id) {
		return eventService.updateEventDetails(id, event);
	}
}


