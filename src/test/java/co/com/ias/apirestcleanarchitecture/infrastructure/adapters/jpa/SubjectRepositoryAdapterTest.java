package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.Subject;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.SubjectId;
import co.com.ias.apirestcleanarchitecture.domain.model.subject.SubjectName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SubjectRepositoryAdapterTest {

    @InjectMocks
    SubjectRepositoryAdapter subjectRepositoryAdapter;
    @Autowired
    ISubjectRepositoryAdapter iSubjectAdapterRepository;

    @BeforeAll
    void init(){
        subjectRepositoryAdapter = new SubjectRepositoryAdapter(iSubjectAdapterRepository);
    }

    @Test
    void saveSubject() {
        Subject subject = new Subject(new SubjectId(1l), new SubjectName("ingles"));

        Subject answer = this.subjectRepositoryAdapter.saveSubject(subject);

        assertEquals("ingles", answer.getName().getValue());
    }

    @Test
    void getSubjects() {
        List<Subject> subjects = new ArrayList<>();

        List<Subject> answer = this.subjectRepositoryAdapter.getSubjects();

        assertEquals(subjects.size(), answer.size());
    }

    @Test
    void findSubjectById() {
    }
}