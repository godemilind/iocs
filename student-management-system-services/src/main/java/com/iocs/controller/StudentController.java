package com.iocs.controller;

import com.iocs.bo.Student;
import com.iocs.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    private boolean sedan = false;

    @GetMapping
    public ResponseEntity<List<Student>> getAllEmployees() {
        List<Student> list = studentService.findAllStudents();
        //List<Student> list = studentService.findAllByEmailDesc();
        logger.info("Get Employees");

        return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
    }

//    @GetMapping("/{pageNo}/{pageSize}/{sortBy}")
//    public ResponseEntity<List<Student>> getAllEmployeesByPage(@PathVariable int pageNo, @PathVariable int pageSize, @PathVariable String sortBy) {
//        String[] sortByArray = sortBy.split(",");
//        List<Student> list = studentService.findAllEmployeesByPage(pageNo,pageSize,sortByArray);
//        logger.info("Get Employees by page");
//        return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
//            throws RecordNotFoundException {
//        Employee entity = studentService.getEmployeeById(id);
//        logger.info("Get Employees by id");
//        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
//    }
//
////    public ResponseEntity<List<Employee>> findAllEmployeesByFilter(){
////
////    }
//
//    @PostMapping
//    public ResponseEntity<Employee> createOrUpdateEmployee(@Valid @RequestBody Employee employee, HttpSession session)
//            throws RecordNotFoundException {
//        String str = (String)session.getAttribute("TEST");
//        if(str == null || str.isEmpty()){
//            session.setAttribute("TEST","TEST");
//        }
//        logger.info("Create/ Update employee");
//
//        this.populateEmployee(employee);
//        Employee updated = studentService.createOrUpdateEmployee(employee);
//        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    public Employee populateEmployee(Employee employee){
//        // code to add address
//        Address address = new Address();
//        address.setCity("Mumbai");
//        address.setLine1("Line 1");
//        address.setLine2("Line 2");
//        Set<Address> addresses = new HashSet<>();
//        addresses.add(address);
//        employee.setAddresses(addresses);
//        // code to add address end
//
//        if(this.sedan) {
//            employee.setCar(new Sedan("Baleno","Alpha"));
//            this.sedan=false;
//        }else{
//            employee.setCar(new Hatchback("Honda City","SX"));
//            this.sedan=true;
//        }
//
//        Department department = new Department();
//        department.setEmployee(new HashSet(Arrays.asList(employee)));
//        department.setName("Java");
//        employee.setDepartment(new HashSet(Arrays.asList(department)));
//
//        return employee;
//    }
//
////    @PutMapping
////    public ResponseEntity<Employee> createOrUpdateEmployee(@Valid @RequestBody Employee employee)
////            throws RecordNotFoundException {
////        Employee updated = studentService.createOrUpdateEmployee(employee);
////        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
////    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
//            throws RecordNotFoundException {
//        logger.info("delete employee");
//        studentService.deleteEmployeeById(id);
//        return HttpStatus.OK;
//    }
}
