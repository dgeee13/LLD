package factory;
import service.*;
import strategy.AllocationStrategy;

public class BookingServiceFactory {
    public static service.BookingService create(AllocationStrategy strat){
        RoomService rs = BookingSystem.getInstance().getRoomService();
        EmployeeService es = BookingSystem.getInstance().getEmployeeService();
        return new BookingService(rs, es, strat);
    }
}
