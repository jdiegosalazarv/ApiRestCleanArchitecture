package co.com.ias.apirestcleanarchitecture.infrastructure.entrypoint.subject;

import co.com.ias.apirestcleanarchitecture.domain.model.subject.dto.SubjectDTO;
import co.com.ias.apirestcleanarchitecture.domain.usecase.subject.SubjectUseCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubjectEntryPoint.class)
class SubjectEntryPointTest {

    @MockBean
    private SubjectUseCase subjectUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("save subject ok")
    void saveSubject() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO(1L,"Ingles");
        when(subjectUseCase.saveSubject(any(SubjectDTO.class))).thenReturn(subjectDTO);
        ObjectMapper mapper = new ObjectMapper();
        //Act && Assert
        mockMvc.perform(post("/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(subjectDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content()
                                .string(Matchers.containsString("Ingles")));
    }

    @Test
    @DisplayName("Get Subject list")
    void getSubjects() throws Exception {
        mockMvc.perform(get("/subject")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().
                        string(Matchers.
                                containsString("Aún no se han creado materias")));
    }

    @Test
    @DisplayName("Get Subject by id")
    void findSubjectById() throws Exception {
        mockMvc.perform(get("/subject/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().
                        string(Matchers.
                                containsString("No existe materia con el id: 1")));
    }
}