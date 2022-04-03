package pro.sky.java.cource2.homework2_5.service;

import pro.sky.java.cource2.homework2_5.data.Employee;

public interface EmployeeService {
    public Employee addEmployee (String firstName, String lastName);
    public Employee dismissEmployee (String firstName, String lastName);
    public Employee findEmloyee (String firstName, String lastName);
    public String getAllStaff();
}
