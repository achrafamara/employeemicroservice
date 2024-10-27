package ma.gestion.employemicroservice.repository;

import ma.gestion.employemicroservice.modele.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
