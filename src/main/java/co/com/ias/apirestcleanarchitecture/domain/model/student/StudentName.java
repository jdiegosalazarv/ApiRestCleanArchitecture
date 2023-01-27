package co.com.ias.apirestcleanarchitecture.domain.model.student;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

public class StudentName {

    private final String value;

    public StudentName(String value) {
        notNull(value, "El campo nombre es requerido");
        isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value),"Solo se admiten letras, sin espacios al inicio y al final");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
