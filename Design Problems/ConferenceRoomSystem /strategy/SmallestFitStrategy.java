package strategy;
import model.*;


//Strategy: choose the smallest room that can fit a given number of attendees for given duration
public class SmallestFitStrategy implements AllocationStrategy {
    @Override
    public Candidate select(Iterable<Room> rooms, int attendees, int duration){
        Room best=null; int bestStart=-1; int bestCap=Integer.MAX_VALUE;
        //
        for (Room r: rooms) {
            if (r.getCapacity() < attendees) continue; //room capacity smaller than number of attendees
            for (int s=1; s<=10-duration+1; s++){ //loops through possible start times s.
            //if total time slots are 10, and duration is 3 then last possible start is slot 8 (8,9,10).
                if (!r.isSlotOpen(s)) continue; //if starting slot s is unavailable, skip it
                if (!r.isAvailableRange(s,duration)) continue; //if whole duration  is unavailable, skip it
                if (r.getCapacity() < bestCap || (r.getCapacity()==bestCap && s<bestStart)){
                    //prefer smaller capacity rooms
                    //or, if bestCap has same capacity as current room, pick one with earlier start time
                    best=r; bestStart=s; bestCap=r.getCapacity();
                }
            }
        }
        //SMALL - 10, LARGE - 20
        return best==null?null:new Candidate(best,bestStart);
    }
}

/*
Explanation for strategy: 
Suppose we have 4 rooms available and attendes = 10,duration =2
Room A: capacity = 20, startSlot = 5
Room B: capacity = 20, startSlot = 3
Room C: capacity = 15, startSlot = 7
Room D: capacity = 15, startSlot = 2

First we pick Room A (20,5) because it's the first valid one.
Then we see Room B: same capacity (20) but earlier slot (3 < 5), pick Room B.
Then Room C: smaller capacity (15 < 20), pick Room C.
Finally Room D: same capacity (15) but earlier slot (2 < 7), pick Room D.
*/