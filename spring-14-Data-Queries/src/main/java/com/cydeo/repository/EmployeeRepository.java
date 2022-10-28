package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address ""
    List<Employee> findByEmail(String email);

    //Display all employees with firstname "" and last name "",
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname,String lastname,String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();


    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();


    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'") // e is employees Object from Employee class
    Integer retrieveEmployeeSalary();


    // not equal in query is <>
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee>retrieveEmployeeSalaryNotEqual(int salary);

    // like /contains /startWith /endWith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee>retrieveEmployeeFirstNameLike(String pattern);

    // less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee>retrieveEmployeeSalaryLessThen(int salary);

    // greater than
    @Query("select e.firstName from Employee e where e.salary > ?1")
    List<String>retrieveEmployeeSalaryGreaterThen(int salary);

    // between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee>retrieveEmployeeSalaryBetween(int salary1,int salary2);

    // before
    @Query("select e from Employee e where e.hireDate >?1 ")
    List<Employee>retrieveEmployeeHireDateBefore(LocalDate date);

    // null
    @Query("select e from Employee e where e.email is null ")
    List<Employee>retrieveEmployeeEmailIsNull();

    @Query("select e from Employee e where e.email is  not null ")
    List<Employee>retrieveEmployeeEmailIsNotNull();

    // sorting Asc order
    @Query("select e from Employee e order by e.salary")
    List<Employee>retrieveEmployeeOrderAsc();

    // sorting Desc order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee>retrieveEmployeeOrderDesc();

    // native query
    @Query(value = "select *from Employee where salary = ?1",nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);


    // name parameter
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee>retrieveEmployeeSalary(@Param("salary") int salary);



}
