package model;
import java.util.*;

public class Room {
    private final String name;
    private final RoomType type;
    private final int capacity;
    private final Map<Integer, String> slots = new TreeMap<>(); // slot -> bookingId or null

    public Room(String name, RoomType type, int capacity) {
        this.name = name; this.type = type; this.capacity = capacity;
    }
    public String getName(){ return name; }
    public RoomType getType(){ return type; }
    public int getCapacity(){ return capacity; }
    public void openSlot(int s){ slots.putIfAbsent(s, null); }
    public boolean isSlotOpen(int s){ return slots.containsKey(s); }
    public boolean isAvailableRange(int start, int duration){
        for (int i = start; i < start + duration; i++) {
            if (!slots.containsKey(i) || slots.get(i) != null) return false;
        } return true;
    }
    public void occupyRange(int start, int duration, String bookingId){
        for (int i = start; i < start + duration; i++) slots.put(i, bookingId);
    }
    public void freeRange(int start, int duration){ for (int i=start;i<start+duration;i++) if (slots.containsKey(i)) slots.put(i, null); }
    public String scheduleString(){
        StringBuilder sb = new StringBuilder();
        for (var e: slots.entrySet()) sb.append("Slot ").append(e.getKey()).append(": ").append(e.getValue()==null?"Available":("Booked("+e.getValue()+")")).append("\n");
        return sb.toString();
    }
}
