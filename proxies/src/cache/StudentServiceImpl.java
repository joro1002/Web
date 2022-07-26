package cache;

import java.util.List;

public class StudentServiceImpl implements StudentServiceIfc{

    @Cacheable("students")
    @Override
    public List<Student> getAllStudents() {
        System.out.println("Doing some hard work to calculate the students");
        Student student = new Student();
        student.setName("Pesho");
        student.setAge(23);

        Student student1 = new Student();
        student1.setName("Anna");
        student1.setAge(27);

        return List.of(student, student1);
    }
}
