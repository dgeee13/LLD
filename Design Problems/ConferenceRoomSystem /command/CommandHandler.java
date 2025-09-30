package command;

import service.BookingSystem;
import service.RoomService;
import service.EmployeeService;
import service.BookingService;
import strategy.SmallestFitStrategy;
import factory.BookingServiceFactory;
import exception.AppException;

import model.RoomType;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CommandHandler {
    private final BookingSystem system = BookingSystem.getInstance();
    private final RoomService roomService = system.getRoomService();
    private final EmployeeService empService = system.getEmployeeService();
    private final BookingService bookingService = BookingServiceFactory.create(new SmallestFitStrategy());

    private final Map<String, Pattern> patterns = Map.of(
        "registerRoom", Pattern.compile("^registerRoom\\('\\s*(.*?)\\s*',\\s*'\\s*(Small|Large)\\s*',\\s*\\[(.*?)\\]\\)\\s*$", Pattern.CASE_INSENSITIVE),
        "registerEmployee", Pattern.compile("^registerEmployee\\('\\s*(.*?)\\s*',\\s*'\\s*(.*?)\\s*'\\)\\s*$", Pattern.CASE_INSENSITIVE),
        "bookRoom", Pattern.compile("^bookRoom\\('\\s*(.*?)\\s*',\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\)\\s*$", Pattern.CASE_INSENSITIVE),
        "viewSchedule", Pattern.compile("^viewSchedule\\('\\s*(.*?)\\s*'\\)\\s*$", Pattern.CASE_INSENSITIVE),
        "help", Pattern.compile("^help$", Pattern.CASE_INSENSITIVE)
    );

    public void handle(String line) {
        if (patterns.get("help").matcher(line).matches()) { printHelp(); return; }

        Matcher m;
        if (line.trim().startsWith("#")) {
            return;
        }
        if ((m = patterns.get("registerRoom").matcher(line)).matches()) {
            String name = m.group(1);
            String type = m.group(2);
            String slotsRaw = m.group(3);
            List<Integer> slots = Arrays.stream(slotsRaw.split(","))
                    .map(String::trim).filter(s->!s.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
            roomService.registerRoom(name, RoomType.valueOf(type.toUpperCase()),  // capacity chosen by type sizes
                    type.equalsIgnoreCase("Small") ? 10 : 30);
            slots.forEach(s->roomService.openSlot(name, s));
            System.out.println("Room '" + name + "' registered with slots " + slots);
            return;
        }

        if ((m = patterns.get("registerEmployee").matcher(line)).matches()) {
            String name = m.group(1), dept = m.group(2);
            empService.registerEmployee(name, dept);
            System.out.println("Employee '" + name + "' registered.");
            return;
        }

        if ((m = patterns.get("bookRoom").matcher(line)).matches()) {
            String employee = m.group(1);
            int attendees = Integer.parseInt(m.group(2));
            int duration = Integer.parseInt(m.group(3));
            try {
                var booking = bookingService.book(employee, attendees, duration);
                System.out.println("Booking successful: " + booking);
            } catch (AppException be) {
                System.out.println("Booking failed: " + be.getMessage());
            }
            return;
        }

        if ((m = patterns.get("viewSchedule").matcher(line)).matches()) {
            String who = m.group(1);
            // if it's a room
            var maybeRoom = roomService.findByName(who);
            if (maybeRoom.isPresent()) {
                System.out.println("Schedule for room '" + who + "':");
                System.out.println(maybeRoom.get().scheduleString());
                return;
            }
            // else treat as employee
            var emp = empService.getOptional(who);
            if (emp.isPresent()) {
                var bookings = bookingService.bookingsForEmployee(who);
                if (bookings.isEmpty()) System.out.println("No bookings for " + who);
                else bookings.forEach(b -> System.out.println(b));
                return;
            }
            System.out.println("No such room or employee: " + who);
            return;
        }

        System.out.println("Unknown command. Type 'help' for syntax.");
    }

    private void printHelp() {
        System.out.println("Supported commands:");
        System.out.println(" registerRoom('Room A', 'Small', [1,2,3,...])");
        System.out.println(" registerEmployee('Alice','Marketing')");
        System.out.println(" bookRoom('Alice', 7, 2)   -- employee, attendees, duration");
        System.out.println(" viewSchedule('Room A') or viewSchedule('Alice')");
        System.out.println(" help | exit");
    }
}
