package com.bicycles.bicycles.employee;

import com.bicycles.bicycles.bicycle.Bicycle;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}