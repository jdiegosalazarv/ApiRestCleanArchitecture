package co.com.ias.apirestcleanarchitecture.domain.usecase.student;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.IStudentRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.student.Student;
import co.com.ias.apirestcleanarchitecture.domain.model.student.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

    private final IStudentRepository iStudentRepository;

    public StudentUseCase(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO){
        //Convertir a Student
        Student student = studentDTO.toDomain(studentDTO);
        Integer subjectId = studentDTO.getSubjectId();

        //Convertir a StudentDTO
        return studentDTO.fromDomain(this.iStudentRepository.saveStudent(student, subjectId));
    }

    public ArrayList<StudentDTO> getStudents(){
        List<Student> students = this.iStudentRepository.getStudents();
        StudentDTO studentDTO = new StudentDTO();
        return (ArrayList<StudentDTO>) students.stream().map(est -> studentDTO.fromDomain(est)).collect(Collectors.toList());
    }
}
