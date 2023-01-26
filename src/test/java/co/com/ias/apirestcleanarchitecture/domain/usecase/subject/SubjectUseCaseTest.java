package co.com.ias.apirestcleanarchitecture.domain.usecase.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class SubjectUseCaseTest {
    @InjectMocks
    private SubjectUseCase subjectUseCase;
    @Mock
    private ISubjectRepository iSubjectRepository;

    @Test
    void saveSubject() {
        //Arrange
        SubjectDTO subjectDTO = new SubjectDTO(1L, "ingles");
        Subject subject = subjectDTO.toDomain(subjectDTO);

        //Actions
        when(this.iSubjectRepository.saveSubject(any(Subject.class))).thenReturn(subject);
        SubjectDTO answer = this.subjectUseCase.saveSubject(subjectDTO);

        //asserts
        assertNotNull(answer);
        assertSame("ingles", answer.getName());
    }

    @Test
    void getSubjects() {
        //Arrange
        List<SubjectDTO> list = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();

        //Actions
        when(this.iSubjectRepository.getSubjects()).thenReturn(subjects);
        ArrayList<SubjectDTO> answer = this.subjectUseCase.getSubjects();

        //Asserts
        assertSame(list.size(), answer.size());
    }

    @Test
    void findSubjectbById() {

    }
}