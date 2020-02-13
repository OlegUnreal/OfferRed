package com.epam.oleg.web.validation.user;

import com.epam.oleg.business.repository.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmail.UniqueNameConstraint.class)
public @interface UniqueEmail {
    String message() default "User with same Email already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @AllArgsConstructor
    class UniqueNameConstraint implements ConstraintValidator<UniqueEmail, String> {
        final UserRepository userRepository;

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return !userRepository.findByEmail(s).isPresent();
        }
    }
}
