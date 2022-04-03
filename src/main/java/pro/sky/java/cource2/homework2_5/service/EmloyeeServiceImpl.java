package pro.sky.java.cource2.homework2_5.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.homework2_5.data.Employee;
import pro.sky.java.cource2.homework2_5.exceptions.BadRequest;
import pro.sky.java.cource2.homework2_5.exceptions.NotFound;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmloyeeServiceImpl implements EmployeeService {
    private List<Employee> staffOfEmployee = new ArrayList<>();
    private int sizeOfStaff;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (staffOfEmployee.contains(newEmployee)) {
            throw new BadRequest();
        } else {
            staffOfEmployee.add(newEmployee);
            sizeOfStaff++;
            return newEmployee;
        }
    }

    @Override
    public Employee dismissEmployee(String firstName, String lastName) {
        Employee dismissedEmployee = new Employee(firstName, lastName);
        if (staffOfEmployee.contains(dismissedEmployee)) {
            staffOfEmployee.remove(dismissedEmployee);
            sizeOfStaff--;
            return dismissedEmployee;
        } else {
            throw new NotFound();
        }
    }

    @Override
    public Employee findEmloyee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (staffOfEmployee.contains(employee)) {
            return employee;
        } else {
            throw new BadRequest();
        }
    }

    @Override
    public String getAllStaff() {
        if (staffOfEmployee.size() == 0) {
            throw new NotFound();
        }
        Employee employee = staffOfEmployee.get(0);
        String allStaff = employee.getLastName() + " " + employee.getFirstName() + ";" + '\n';
        for (int i = 1; i < staffOfEmployee.size(); i++) {
            employee = staffOfEmployee.get(i);
            allStaff = allStaff + employee.getLastName() + " " + employee.getFirstName() + ";" + '\n';
        }
        return allStaff;
    }
}
