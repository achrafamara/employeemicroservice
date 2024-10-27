package ma.gestion.employemicroservice.controller;

import ma.gestion.employemicroservice.modele.Employee;
import ma.gestion.employemicroservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
         return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("employee with id: "+employee.getId() +" was created successfully",HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("employee with id " + id + " was deleted successfully.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("employee not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>("employee with ID " + id + " was updated successfully.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("employee not found.", HttpStatus.NOT_FOUND);
        }
    }
}
