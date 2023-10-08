package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();
    Booking booking;

    //region Konstruktory

    public BookingManager(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    //endregion

    //region Metody
    public void addBooking(Booking newBooking){
        bookingList.add(newBooking);
    }
    public Booking getBooking(int index){
        return bookingList.get(index);
    }
    public List<Booking> getBookings(){
        return new ArrayList<Booking>(bookingList);
    }
    public void clearBookings(){
        bookingList.clear();
    }
    public int getNumberOfWorkingBookings(){
        int numOfWorkingBookings = 0;
        if (!booking.isHoliday()){
            numOfWorkingBookings += 1;
        }
        return numOfWorkingBookings;
    }
    public double getAverageGuests(){
        int numOfGuests = 0;
        for (Booking booking : bookingList){
            numOfGuests += booking.getNumberOfBuests();
        }
        return (double) numOfGuests/bookingList.size();
    }
    //endregion
}
