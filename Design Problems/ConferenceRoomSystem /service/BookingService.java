package service;
import model.*;
import strategy.*;
import exception.BookingException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {
    private final RoomService rooms; private final EmployeeService employees; private final AllocationStrategy strat;
    private final Map<String, Booking> bookings = new HashMap<>();
    private final AtomicInteger idGen = new AtomicInteger(1000);

    public BookingService(RoomService r, EmployeeService e, AllocationStrategy s){
        this.rooms = r; this.employees = e; this.strat = s;
    }

    public Booking book(String employeeName, int attendees, int duration) {
        if (duration <= 0 || duration > 10) throw new BookingException("Invalid duration");
        var emp = employees.get(employeeName);
        AllocationStrategy.Candidate c = strat.select(rooms.allRooms(), attendees, duration);
        //
        if (c == null) throw new BookingException("No suitable room available for given criteria");
        String id = "B" + idGen.getAndIncrement();
        Booking b = new Booking(id, c.room.getName(), employeeName, c.start, duration, attendees);
        bookings.put(id, b);
        c.room.occupyRange(c.start, duration, id);
        emp.addBooking(id);
        return b;
        //
    }

    public List<Booking> bookingsForEmployee(String empName){
        List<Booking> out = new ArrayList<>();
        for (Booking b : bookings.values()) if (b.getEmployee().equals(empName)) out.add(b);
        return out;
    }
}
