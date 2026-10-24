package com.jpa_api.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_api.test.entity.Students;
import com.jpa_api.test.repository.StudentRepository;
import com.jpa_api.test.services.StudentService;

@RestController 
@RequestMapping("/student")
public class StudentEntryController implements StudentService{

    @Autowired 
    private StudentRepository studentRepository;

    @GetMapping 
    @Override 
    public List<Students> getAll(){
        // return new ArrayList<>(studentService.findAll());
        return studentRepository.findAll();
    }

    @PostMapping
    @Override
    public boolean addStudent(@RequestBody Students std) {

        boolean status=false;
        try {
            studentRepository.save(std);
            status=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @GetMapping("/id/{id}")
    @Override 
    public Optional<Students> getById(@PathVariable Long id){
        Optional<Students> std=studentRepository.findById(id);
        return std;
    }

    @PutMapping("/id/{id}")
    @Override 
    public boolean updateStudent(@PathVariable Long id, @RequestBody Students std){
        try {
            std.setId(id);
            studentRepository.save(std);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @DeleteMapping("/id/{id}")
    @Override 
    public boolean deleteStudent(@PathVariable Long id){
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    

}
