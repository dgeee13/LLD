package service;
import model.*;
import exception.AppException;
import java.util.*;

public class RoomService {
    private final Map<String, Room> rooms = new HashMap<>();
    public void registerRoom(String name, RoomType type, int capacity){
        if (rooms.containsKey(name)) throw new AppException("Room already exists: " + name);
        rooms.put(name, new Room(name, type, capacity));
    }
    public void openSlot(String roomName, int slot){
        Room r = rooms.get(roomName); if (r==null) throw new AppException("No such room: " + roomName);
        if (slot < 1 || slot > 10) throw new AppException("Slot must be 1..10");
        r.openSlot(slot);
    }
    public Collection<Room> allRooms(){ return rooms.values(); }
    public Optional<Room> findByName(String name){ return Optional.ofNullable(rooms.get(name)); }
}
