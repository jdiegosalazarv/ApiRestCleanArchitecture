package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.subject.SubjectUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(SubjectEntryPoint.class)
class SubjectEntryPointTest {

    @MockBean
    private SubjectUseCase subjectUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("save subject ok")
    void saveSubject() throws Exception {
        
    }

    @Test
    void getSubjects() {
    }

    @Test
    void findSubjectById() {
    }
}