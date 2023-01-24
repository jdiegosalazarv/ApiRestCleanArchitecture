package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.SubjectDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SubjectRepositoryAdapter implements ISubjectRepository {

    private final ISubjectAdapterRepository iSubjectAdapterRepository;

    public SubjectRepositoryAdapter(ISubjectAdapterRepository iSubjectAdapterRepository) {
        this.iSubjectAdapterRepository = iSubjectAdapterRepository;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        //Convertir en DBO
        SubjectDBO subjectDBO = new SubjectDBO().fromDomain(subject);

        //convertir a Subject
        return subjectDBO.toDomain(this.iSubjectAdapterRepository.save(subjectDBO));
    }

    @Override
    public List<Subject> getSubjects() {
        List<SubjectDBO> subjects = this.iSubjectAdapterRepository.findAll();
        SubjectDBO subjectDBO = new SubjectDBO();

        return subjects.stream().map(sub -> subjectDBO.toDomain(sub)).collect(Collectors.toList());
    }
}
