package co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa;

import co.com.ias.apirestcleanarchitecture.infrastructure.adapters.jpa.entity.SubjectDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectAdapterRepository extends JpaRepository<SubjectDBO, Long> {
}
