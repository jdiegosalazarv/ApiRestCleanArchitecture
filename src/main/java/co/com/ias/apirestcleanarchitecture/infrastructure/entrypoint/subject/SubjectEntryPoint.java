package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.subject.SubjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectEntryPoint {

    private final SubjectUseCase subjectUseCase;

    @PostMapping
    public SubjectDTO saveSubject(@RequestBody SubjectDTO subjectDTO){
        return this.subjectUseCase.saveSubject(subjectDTO);
    }

    @GetMapping
    public List<SubjectDTO> getSubjects(){
        return this.subjectUseCase.getSubjects();
    }

    @GetMapping("/{id}")
    public SubjectDTO findSubjectById(@PathVariable Long id){
        SubjectDTO subjectDTO =this.subjectUseCase.findSubjectbById(id);
        if (subjectDTO != null){
            return this.subjectUseCase.findSubjectbById(id);
        }
        return null;
    }
}
