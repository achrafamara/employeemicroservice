package ma.gestion.employemicroservice.service;


import ma.gestion.employemicroservice.modele.Employee;
import ma.gestion.employemicroservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        for (Employee emp : employeeRepository.findAll()) {
            if (emp.getId().equals(id)) {
                employeeRepository.save(employee);
            }
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
