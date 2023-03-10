package co.com.ias.apirestcleanarchitecture.domain.usecase.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectUseCase {

    private final ISubjectRepository iSubjectRepository;

    public SubjectUseCase(ISubjectRepository iSubjectRepository) {
        this.iSubjectRepository = iSubjectRepository;
    }

    public SubjectDTO saveSubject(SubjectDTO subjectDTO){
        //Convertir a Subject
        Subject subject = subjectDTO.toDomain(subjectDTO);

        //Convertir a SubjectDTO
        return SubjectDTO.fromDomain(this.iSubjectRepository.saveSubject(subject));
    }

    public ArrayList<SubjectDTO> getSubjects(){
        List<Subject> subjects = this.iSubjectRepository.getSubjects();
        return (ArrayList<SubjectDTO>) subjects.stream().map(SubjectDTO::fromDomain).collect(Collectors.toList());
    }

    public SubjectDTO findSubjectbById(Long id){
        Subject subject = this.iSubjectRepository.findSubjectById(id);
        return SubjectDTO.fromDomain(subject);
    }
}
