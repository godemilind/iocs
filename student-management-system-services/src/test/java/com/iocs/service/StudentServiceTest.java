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
        student.setFirstName("Shyamal");
        student.setLastName("Gode");
        student.setAddress("B-34/B-wing/103, Gokuldham, Goregaon East");
        student.setAge(33);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        student.setBirthDate(formatter.parse("18-01-1987"));
        student.setCity("Mumbai");
        student.setState("Maharashtra");
        student.setEmail("milind.gode@gmail.com");
        student.setGrade("A");
        student.setGuardianName("Milind Gode");
        student.setPhoneNumber(9820212086l);
        student.setPincode(400063l);
        student.setSchoolName("Yashodham High School");
        student.setActivities("Dancing");
        studentService.saveStudent(student);
        List<Student> students = studentService.findAllStudents();
        System.out.println(students);
    }
}
