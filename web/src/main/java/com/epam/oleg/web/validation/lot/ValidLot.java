package com.epam.oleg.web.validation.lot;

import com.epam.oleg.web.rest.dto.LotDTO;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidLot.ValidLotConstraint.class)
public @interface ValidLot {

    class ValidLotConstraint implements ConstraintValidator<ValidLot, LotDTO> {

        @Override
        public boolean isValid(LotDTO value, ConstraintValidatorContext context) {
            if (value.getCurrentPrice() < value.getStartedPrice()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Current price cannot be less than started");
                return false;
            }

            return true;
        }
    }
}
