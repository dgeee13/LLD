package strategy;
import model.Room;
public interface AllocationStrategy {
    Candidate select(Iterable<Room> rooms, int attendees, int duration);
    class Candidate { 
     public final Room room;
     public final int start; 
     public Candidate(Room r,int s){room=r;start=s;} }
}
