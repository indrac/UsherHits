package com.redtruelove.usherhits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redtruelove.usherhits.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
