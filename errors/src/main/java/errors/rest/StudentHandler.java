package errors.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<Student> handleHelloException(){
        Student student = new Student();
        student.setName("Default");
        student.setAge(34);
        return ResponseEntity.ok(student);
    }
}
