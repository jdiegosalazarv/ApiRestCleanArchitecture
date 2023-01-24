package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.student;

import co.com.ias.apirestcleanarchitecture.domain.model.student.dto.StudentDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

    private final StudentUseCase studentUseCase;

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return this.studentUseCase.saveStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> getStudents(){
        return this.studentUseCase.getStudents();
    }
}
