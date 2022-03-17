package com.studentsapi.controller;

import com.studentsapi.persitence.dto.StudentGetDto;
import com.studentsapi.persitence.dto.StudentSaveDto;
import com.studentsapi.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    final private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentGetDto>> getAll() {
        return new ResponseEntity<>(service.finAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentGetDto> getStudentById(@PathVariable("id") Long id) {
        return service.findById(id)
                .map(StudentGetDto -> new ResponseEntity<>(StudentGetDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<StudentGetDto> save(@RequestBody StudentSaveDto saveDto) {
        return new ResponseEntity<>(service.save(saveDto), HttpStatus.CREATED);
    }

}
