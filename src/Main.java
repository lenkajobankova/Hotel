import com.engeto.hotel.Booking;
import com.engeto.hotel.BookingManager;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        fillBookings reservations = getFillBookings();

        printBookings(reservations.bookingList());

        getFirstHolidayBookings(reservations.bookingList(),8);

        System.out.println(reservations.bookingManager().getBooking(0).getBookingLength());

        System.out.println(reservations.bookingManager().getBooking(0).getPrice());

        printGuestStatistics(reservations.bookingList());
    }

    private static fillBookings getFillBookings() {
        List<Booking> bookingList = new ArrayList<>();
        BookingManager bookingManager = new BookingManager(bookingList);

        Room room1 = new Room(1, 1,true,
                true,1000);
        Room room2 = new Room(2, 1,true,
                true,1000);
        Room room3 = new Room(3, 3,false,
                true,2400);

        Guest karel90 = new Guest("Karel Dvořák", LocalDate.of(1990,5,15));
        Guest karel79 = new Guest("Karel Dvořák", LocalDate.of(1979,1,3));
        Guest karolina = new Guest("Karolína Tmavá", LocalDate.of(1990,1,1));

        Booking reservation1 = new Booking(karel90, room3,
                LocalDate.of(2023,6,1),
                LocalDate.of(2023,6,7), false);
        Booking reservation2 = new Booking(karel79, room2,
                LocalDate.of(2023,8,18),
                LocalDate.of(2023,8,21),true);

        bookingManager.addBooking(reservation1);
        bookingManager.addBooking(reservation2);

        int numOfBookingsJune = 10;
        for (int i = 0; i < numOfBookingsJune; i++){
            Booking booking = new Booking(karolina, room2,
                    LocalDate.of(2023,8,1).plusDays(i+i),
                    LocalDate.of(2023,8,2).plusDays(i+i),
                    true);
            bookingManager.addBooking(booking);
        }

        Booking reservation3 = new Booking(karolina, room3,
                LocalDate.of(2023,8,1),
                LocalDate.of(2023,8,31),
                true);

        bookingManager.addBooking(reservation3);
        fillBookings reservations = new fillBookings(bookingList, bookingManager);
        return reservations;
    }

    private record fillBookings(List<Booking> bookingList, BookingManager bookingManager) {
    }

    private static void printGuestStatistics(List<Booking> bookingList) {
        int oneGuest = 0, twoGuests = 0, moreThanTwoGuests = 0;
        for (Booking booking : bookingList){
            int numberOfGuests = booking.getNumberOfBuests();

            if (numberOfGuests == 1){
                oneGuest++;
            }
            else if(numberOfGuests == 2){
                twoGuests++;
            }
            else{
                moreThanTwoGuests++;
            }
        }
        System.out.println("Počet rezervací s jedním hostem: "+oneGuest);
        System.out.println("Počet rezervací se dvěma hosty: "+twoGuests);
        System.out.println("Počet rezervací s více než dvěma hosty: "+moreThanTwoGuests);
    }


    private static void getFirstHolidayBookings(List<Booking> bookingList, int numOfHolidayBookings) {
        if (numOfHolidayBookings<=bookingList.size()){
            int index = 1;
            System.out.println("Výpis prvních "+numOfHolidayBookings+" rekreačních pobytů");
            for (int i = 0; i < numOfHolidayBookings; i++){
                if (bookingList.get(index).isHoliday()) {
                    System.out.println(index + ": " + bookingList.get(index).getDateFrom() + " až " + bookingList.get(index).getDateTo() + ": " +
                            bookingList.get(index).getGuest().getDescription() + "[" + bookingList.get(index).getNumberOfBuests() + ", " +
                            bookingList.get(index).getRoom().isSeaYN() + "] za " + bookingList.get(index).getRoom().getPricePerNight() + " Kč"
                    );
                    index++;
                }
            }
        }
        else System.out.println("Tolik rekreačních rezervací není zadáno!");
    }

    private static void printBookings(List<Booking> bookingList) {
        for (Booking booking : bookingList){
            System.out.println(
                    booking.getDateFrom()+" až "+booking.getDateTo()+": "+
                            booking.getGuest().getDescription()+"["+booking.getNumberOfBuests()+", "
                            +booking.getRoom().isSeaYN()+"] za "+booking.getRoom().getPricePerNight()+" Kč"
            );
        }
    }

}