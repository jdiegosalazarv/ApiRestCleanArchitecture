package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.IStudentRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.student.Student;
import co.com.ias.apirestcleanarchitecture.domain.model.student.dto.StudentDTO;
import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.StudentDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryAdapter implements IStudentRepository {

    private final IStudentAdapterRepository iStudentAdapterRepository;

    public StudentRepositoryAdapter(IStudentAdapterRepository iStudentAdapterRepository) {
        this.iStudentAdapterRepository = iStudentAdapterRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        //Convertir en DBO
        StudentDBO studentDBO = new StudentDBO().fromDomain(student);

        //Convertir en Student
        return studentDBO.toDomain(this.iStudentAdapterRepository.save(studentDBO));
    }

    @Override
    public List<Student> getStudents() {
        List<StudentDBO> studentDBOS = this.iStudentAdapterRepository.findAll();
        StudentDBO studentDBO = new StudentDBO();
        return studentDBOS.stream().map(est -> studentDBO.toDomain(est)).collect(Collectors.toList());
    }
}
