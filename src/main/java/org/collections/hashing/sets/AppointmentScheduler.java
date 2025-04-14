package org.collections.hashing.sets;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.TreeSet;

public class AppointmentScheduler {
    //tree set to store appointments sorted by time
    private final NavigableSet<Appointment> appointments;

    public AppointmentScheduler() {
        this.appointments = new TreeSet<>((a1, a2) -> a1.time().compareTo(a2.time()));
    }
    //add a new appointment
    public boolean scheduleAppointment(String description, LocalDateTime time){
        return appointments.add(new Appointment(description, time));
    }

    //find the next available appointment after a given time
    public Appointment findTheNextAvailableAppointment(LocalDateTime after){
        return appointments.higher(new Appointment("", after));
    }
    //find appointments within a given time range
    public NavigableSet<Appointment> findAppointmentsInRange(LocalDateTime start, LocalDateTime end){
        return appointments.subSet(
                new Appointment("", start),
                true,
                new Appointment("", end),
                true
        );
    }

    //cancel the next upcoming appointment
    public Appointment  cancelNextAppointment(){
        return appointments.pollFirst();
    }
    //list all appointments in descending order
    public NavigableSet<Appointment> listAllAppointmentsInDescendingOrder(){
        return appointments.descendingSet();
    }
    record Appointment(String description, LocalDateTime time) {}
}
