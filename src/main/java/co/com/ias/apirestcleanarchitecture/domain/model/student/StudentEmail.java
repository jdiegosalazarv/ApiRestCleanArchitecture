package co.com.ias.apirestcleanarchitecture.domain.model.student;

import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StudentEmail {

    private final String value;

    public StudentEmail(String value) {
        Assert.isTrue(Pattern.matches("^([a-zA-Z0-9-.]+)@([a-zA-Z0-9-.]+).([a-zA-Z]{2,5})$", value),"Debes ingresar un email válido");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
