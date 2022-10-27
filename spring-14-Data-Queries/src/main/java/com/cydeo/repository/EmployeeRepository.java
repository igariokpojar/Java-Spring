package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address

    List<Employee>findByEmail(String email);

    // display all employees with first name '" and last name "" and also show all employees with email address

    List<Employee>findByFirstNameAndLastNameOrEmail(String firstname,String lastname,String email);

    // display all employees that first name is not ...
    List<Employee>findByFirstNameIsNot(String firstname);

    // display aal employees where last name start with ''

    List<Employee>findByLastNameStartingWith(String pattern);

    // display all employees with salary higher then
    List<Employee>findBySalaryGreaterThan(Integer salary);

    // display all employees with salary less than

    List<Employee>findBySalaryLessThan(Integer salary);

    // display all employees that has been hired between '' and ''

    List<Employee>findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    // display all employees where sa;ry grater and Equal to and in order -salary

    List<Employee>findBySalaryGreaterThanEqualOOrderBySalary(Integer salary);

    // display top unique 3 employees is making less than

    List<Employee>findDistinctTop3BySalaryLessThan(Integer salary);

    // display all employees that do not have email address

    List<Employee>findByEmailIsNull(String email);
}
