package service;
/** singleton facade */
public class BookingSystem {
    private static final BookingSystem INST = new BookingSystem();
    private final RoomService roomService = new RoomService();
    private final EmployeeService employeeService = new EmployeeService();
    private BookingSystem() {}
    public static BookingSystem getInstance(){ return INST; }
    public RoomService getRoomService(){ return roomService; }
    public EmployeeService getEmployeeService(){ return employeeService; }
    public String healthCheck(){ return "OK"; }
}
