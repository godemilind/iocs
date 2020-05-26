package com.iocs.service;

import com.iocs.bo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testSaveStudent() throws ParseException {
        Student student = new Student();
        student.setFirstName("Milind");
        student.setLastName("Gode");
        student.setAddress("B-34/B-wing/103, Gokuldham, Goregaon East");
        student.setAge(38);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        student.setBirthDate(formatter.parse("01-FEB-1982"));
        student.setCity("Mumbai");
        student.setState("Maharashtra");
        student.setEmail("milind.gode@gmail.com");
        student.setGrade("A");
        student.setGuardianName("Subhash Gode");
        student.setPhoneNumber(9967656311l);
        student.setPincode(400063l);
        student.setSchoolName("Yashodham High School");
        student.setActivities("Swimming");
        studentService.saveStudent(student);
        List<Student> students = studentService.findAllStudents();
        System.out.println(students);
    }
}
