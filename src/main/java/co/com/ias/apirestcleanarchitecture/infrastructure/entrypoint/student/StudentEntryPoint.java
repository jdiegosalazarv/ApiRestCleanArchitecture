package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.student;

import co.com.ias.apirestcleanarchitecture.domain.model.student.dto.StudentDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

    private final StudentUseCase studentUseCase;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO){
        try{
            StudentDTO student = this.studentUseCase.saveStudent(studentDTO);
            return ResponseEntity.status(201).body(student);
        }catch (IllegalArgumentException | NullPointerException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        List<StudentDTO> studentDTOS = this.studentUseCase.getStudents();
        if(studentDTOS.isEmpty()){
            return ResponseEntity.status(404).body("No hay estudiantes en la BD");
        }
        return ResponseEntity.status(200).body(studentDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id){
        try{
            StudentDTO studentDTO = this.studentUseCase.findStudentById(id);
            return ResponseEntity.status(200).body(studentDTO);
        }catch (NullPointerException e){
            return ResponseEntity.status(412).body("No existe estudiante con ese Id");
        }
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<?> findStudentsBySubjectId(@PathVariable Long id){
        List<StudentDTO> students = this.studentUseCase.findStudentsBySubjectId(id);
        if(students.isEmpty()){
            return ResponseEntity.status(404).body("No hay estudiantes registrados en esa materia");
        }
        return ResponseEntity.status(200).body(students);
    }
}
