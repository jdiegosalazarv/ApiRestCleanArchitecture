package co.com.ias.apirestcleanarchitecture.domain.usecase.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.ISubjectRepository;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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
        SubjectDTO subject1 = new SubjectDTO(1L, "ingles");
        SubjectDTO subject2 = new SubjectDTO(2L, "matematicas");
        SubjectDTO subject3 = new SubjectDTO(3L, "Sociales");
        List<SubjectDTO> list = Arrays.asList(subject1,subject2,subject3);


        List<Subject> subjects = Arrays.asList(subject1.toDomain(subject1), subject2.toDomain(subject2), subject3.toDomain(subject3));

        //Actions
        when(this.iSubjectRepository.getSubjects()).thenReturn(subjects);
        ArrayList<SubjectDTO> answer = this.subjectUseCase.getSubjects();

        //Asserts
        assertSame(list.size(), answer.size());
        assertNotNull(answer);
        assertSame(list.get(0).getName(), answer.get(0).getName());
    }

    @Test
    void findSubjectbById() {

    }
}