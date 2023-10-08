package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Guest guest;
    private List<Guest> otherGuest = new ArrayList<>();
    private Room room;
    private LocalDate dateFrom, dateTo;
    private boolean isHoliday;

    //region Konstruktory
    public Booking(Guest guest, Room room, LocalDate dateFrom, LocalDate dateTo,
                   boolean isHoliday){
        this.guest = guest;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isHoliday = isHoliday;
    }
    public Booking(Guest guest, List<Guest> otherGuest, Room room, LocalDate dateFrom, LocalDate dateTo, boolean isHoliday) {
        this(guest, room, dateFrom, dateTo, isHoliday);
        this.otherGuest = otherGuest;
    }

    public Booking(Guest guest, Room room){
        this(guest, room, LocalDate.now(), LocalDate.now().plusDays(6), true);
    }

    //endregion

    //region Přístupové metody
    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDateFrom() {
        return dateFrom.format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)).toString();
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo.format(DateTimeFormatter.ofLocalizedDate
                (FormatStyle.MEDIUM)).toString();
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }
    public int getNumberOfBuests(){
        int number = 1;
        for (Guest guest : otherGuest){
            number += otherGuest.size();
        }
        return number;
    }
    public long getBookingLength(){
        long daysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo);
        return daysBetween;
    }
    public long getPrice(){
        long sum;
        sum = getRoom().getPricePerNight()*getBookingLength();
        return sum;
    }
//endregion
}
