package employee.manage.employee.service;


import employee.manage.employee.entity.Employee;
import employee.manage.employee.error.EmployeeNotFoundException;


public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Iterable<Employee> getAllEmployees();

    Employee findOneEmployee(long id) throws EmployeeNotFoundException;

    Employee updateEmployee(long id, Employee employee) throws EmployeeNotFoundException;

    void deleteEmployee(long id) throws EmployeeNotFoundException;
}

