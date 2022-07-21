package errors.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        //arrays
        throw new ArrayIndexOutOfBoundsException();
    }
}
