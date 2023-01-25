package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.subject.SubjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectEntryPoint {

    private final SubjectUseCase subjectUseCase;

    @PostMapping
    public ResponseEntity<?> saveSubject(@RequestBody SubjectDTO subjectDTO){
        return ResponseEntity.status(201).body(this.subjectUseCase.saveSubject(subjectDTO));
    }

    @GetMapping
    public ResponseEntity<?> getSubjects(){
        List<SubjectDTO> subjects = this.subjectUseCase.getSubjects();
        if(subjects.isEmpty()){
            return ResponseEntity.status(200).body("Aún no se han creado materias");
        }
        return ResponseEntity.status(200).body(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSubjectById(@PathVariable Long id){
        SubjectDTO subjectDTO =this.subjectUseCase.findSubjectbById(id);
        if (subjectDTO != null){
            return ResponseEntity.status(200).body(this.subjectUseCase.findSubjectbById(id));
        }
        return ResponseEntity.status(406).body("No existe materia con ese Id");
    }
}
