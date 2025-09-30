package service;
import model.*;
import exception.AppException;
import java.util.*;

public class EmployeeService {
    private final Map<String, Employee> emps = new HashMap<>();
    public void registerEmployee(String name, String dept){
        if (emps.containsKey(name)) throw new AppException("Employee exists: " + name);
        emps.put(name, new Employee(name, dept));
    }
    public Employee get(String name){ Employee e = emps.get(name); if (e==null) throw new AppException("No employee: " + name); return e; }
    public Optional<Employee> getOptional(String name){ return Optional.ofNullable(emps.get(name)); }
}
