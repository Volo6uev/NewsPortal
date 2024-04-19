package ru.itis.semestrovka.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.itis.semestrovka.validation.validators.SameValuesValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameValuesValidator.class)
public @interface PasswordsMatch {
    String message() default "{passwordMatch}";
    String[] fields();
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
