package tn.noureddine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.noureddine.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
