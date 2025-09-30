package model;
import java.util.*;
public class Employee {
    private final String name; private final String dept;
    private final List<String> bookingIds = new ArrayList<>();
    public Employee(String name, String dept){ this.name = name; this.dept = dept; }
    public String getName(){ return name; }
    public void addBooking(String id){ bookingIds.add(id); }
    public java.util.List<String> getBookings(){ return List.copyOf(bookingIds); }
}
