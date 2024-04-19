package ru.itis.semestrovka.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.util.ReflectionUtils;
import ru.itis.semestrovka.validation.constraints.PasswordsMatch;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SameValuesValidator implements ConstraintValidator<PasswordsMatch,Object> {

    private String[] fieldsNames;

    @Override
    public void initialize(PasswordsMatch passwordsMatch) {
        this.fieldsNames = passwordsMatch.fields();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        List<String> fieldsValues = new ArrayList<>();

        for (String fieldName: fieldsNames) {
            Field field = ReflectionUtils.findRequiredField(o.getClass(),fieldName);
            field.setAccessible(true);
            try {
                fieldsValues.add((String)field.get(o));
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return 1 == fieldsValues.stream().distinct().count();
    }
}
