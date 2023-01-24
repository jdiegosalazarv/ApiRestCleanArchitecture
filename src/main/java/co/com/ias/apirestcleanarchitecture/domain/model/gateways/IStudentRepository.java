package co.com.ias.apirestcleanarchitecture.domain.model.gateways;

import co.com.ias.apirestcleanarchitecture.domain.model.student.Student;

import java.util.List;

public interface IStudentRepository {

    Student saveStudent(Student student);

    List<Student> getStudents();


}
