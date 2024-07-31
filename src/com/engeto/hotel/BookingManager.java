package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

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
        int result = 0;
        for (Booking booking : bookingList){
            if (!booking.isHoliday()){
                result++;
            }
        }
        return result;
    }
    public double getAverageGuests(){
        int numOfGuests = 0;
        double result;
        for (Booking booking : bookingList){
            numOfGuests += booking.getNumberOfBuests();
        }
        if(numOfGuests > 0){
            result = (double) numOfGuests/bookingList.size();
        } else {
            result = 0;
        }
        return result;
    }
    //endregion
}
