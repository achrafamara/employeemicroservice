package ma.gestion.employemicroservice.service;

import ma.gestion.employemicroservice.modele.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    void createEmployee(Employee employee);
    void updateEmployee(Long id,Employee employee);
    void deleteEmployee(Long id);
}
