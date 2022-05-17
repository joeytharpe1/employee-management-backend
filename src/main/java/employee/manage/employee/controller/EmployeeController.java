package employee.manage.employee.controller;

import employee.manage.employee.entity.Employee;
import employee.manage.employee.error.EmployeeNotFoundException;
import employee.manage.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;
    public final Logger LOGGER = Logger.getLogger(String.valueOf(EmployeeController.class));

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add employee to localhost:8080/api/employee
    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("inside of addEmployee of EmployeeController");
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //find all employees at localhost:8080/api/employee
    @GetMapping()
    public ResponseEntity<Iterable<Employee>> getAllEmployees(){
        LOGGER.info("inside of getAllEmployees of EmployeeController");
        Iterable<Employee> allEmployees= employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    //find one employee at localhost:8080/api/employee/id
    @GetMapping("{id}")
    public ResponseEntity<Employee> findOneEmployee(@PathVariable("id") long id) throws EmployeeNotFoundException {
        LOGGER.info("inside of findOneEmployee of EmployeeController");
        Employee oneEmployee = employeeService.findOneEmployee(id);
        return new ResponseEntity<>(oneEmployee, HttpStatus.OK);
    }

    //update one employee by id at localhost:8080/api/employee/id
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("inside updateEmployee of EmployeeController");
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    //delete employee by id at localhost:8080/api/employee/id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) throws EmployeeNotFoundException {
        LOGGER.info("inside deleteEmployee of EmployeeController");
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}