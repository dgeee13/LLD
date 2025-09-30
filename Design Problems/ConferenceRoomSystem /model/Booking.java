package model;
public class Booking {
    private final String id;
    private final String room;
    private final String employee;
    private final int start;
    private final int duration;
    private final int attendees;
    public Booking(String id, String room, String employee, int start, int duration, int attendees){
        this.id=id; this.room=room; this.employee=employee; this.start=start; this.duration=duration; this.attendees=attendees;
    }
    public String getId(){ return id; }
    public String getEmployee(){ return employee; }
    public String toString(){ return id + " ["+room+"] slots " + start + "-" + (start+duration-1) + " (" + attendees + " attendees) by " + employee; }
}
