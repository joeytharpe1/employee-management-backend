package employee.manage.employee.service;

import employee.manage.employee.entity.Employee;
import employee.manage.employee.error.EmployeeNotFoundException;
import employee.manage.employee.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findOneEmployee(long id) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(!employeeOptional.isPresent())
            throw new EmployeeNotFoundException("Employee not found");
        return employeeOptional.get();
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(!employeeOptional.isPresent())
            throw new EmployeeNotFoundException("employee not found");

        Employee toUpdateEmployee = employeeOptional.get();

        if(employee.getFirstName() != null)
            toUpdateEmployee.setFirstName(employee.getFirstName());

        if(employee.getLastName() != null)
            toUpdateEmployee.setLastName(employee.getLastName());

        if(employee.getEmail() != null)
            toUpdateEmployee.setEmail(employee.getEmail());

        return employeeRepository.save(toUpdateEmployee);
    }

    @Override
    public void deleteEmployee(long id) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(!employeeOptional.isPresent())
            throw new EmployeeNotFoundException("employee not found");
        employeeRepository.deleteById(id);
    }


}