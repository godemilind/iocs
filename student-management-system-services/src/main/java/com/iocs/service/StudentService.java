package com.iocs.service;

import com.iocs.bo.Student;
import com.iocs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@EnableTransactionManagement
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE,timeout = 1000,rollbackFor = Exception.class)
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsByPage(int pageNo, int pageSize, String... sortByAll){
        Sort sort = null;
        for (String sortBy : sortByAll) {
            if(sort == null)
                sort = Sort.by(Sort.Direction.ASC,sortBy);
            else sort.and(Sort.by(sortBy));
        }

        Pageable pageable = null;
        if(sort != null)
            pageable = PageRequest.of(pageNo,pageSize, sort);
        else{
            pageable = PageRequest.of(pageNo,pageSize);
        }
        Page<Student> page = studentRepository.findAll(pageable);
        return page.getContent();
    }

    public Optional<Student> findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
}
