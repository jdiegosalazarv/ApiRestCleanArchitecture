package co.com.ias.apirestcleanarchitecture.application.configuration;

import co.com.ias.apirestcleanarchitecture.domain.model.gateways.IStudentRepository;
import co.com.ias.apirestcleanarchitecture.domain.usecase.student.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {
    @Bean
    public StudentUseCase studentUseCase(IStudentRepository iStudentRepository){
        return new StudentUseCase(iStudentRepository);
    }
}
