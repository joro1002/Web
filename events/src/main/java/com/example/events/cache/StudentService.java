package com.example.events.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Cacheable(cacheNames = "students")
    public List<Student> getAllStudents(){
        System.out.println("I am doing heavy and complicated work to generate students....");

        return generateStudents();
    }

    @CachePut("students")
    public List<Student> updateAllStudents(){
        System.out.println("I am updating all the students");

        return getAllStudents();
    }

    private List<Student> generateStudents(){
        Random ageGen = new Random();

        Student pesho = new Student();
        pesho.setAge(20 + ageGen.nextInt(10));
        pesho.setName("Pesho");

        Student anna = new Student();
        anna.setAge(20 + ageGen.nextInt(10));
        anna.setName("Anna");

        return List.of(pesho, anna);
    }
}
