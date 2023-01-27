package co.com.ias.apirestcleanarchitecture.domain.model.student;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

public class StudentPhone {

    private final String value;

    public StudentPhone(String value) {
        notNull(value, "El campo teléfono es requerido");
        isTrue(Pattern.matches("^[0-9]+$", value), "El campo teléfono solo acepta números");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
