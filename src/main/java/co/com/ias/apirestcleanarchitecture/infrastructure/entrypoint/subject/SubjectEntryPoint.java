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
        try{
            return ResponseEntity.status(201).body(this.subjectUseCase.saveSubject(subjectDTO));
        }catch (IllegalArgumentException | NullPointerException e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

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
        try{
            SubjectDTO subjectDTO =this.subjectUseCase.findSubjectbById(id);
            return ResponseEntity.status(200).body(subjectDTO);
        }catch (NullPointerException e){
            return ResponseEntity.status(406).body(e.getMessage());
        }

    }
}
