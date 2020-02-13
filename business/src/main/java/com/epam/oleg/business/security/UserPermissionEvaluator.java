package com.epam.oleg.business.security;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.repository.OfferRepository;
import com.epam.oleg.business.repository.ProductRepository;
import com.epam.oleg.business.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

import static com.epam.oleg.business.common.EntityTypes.*;

@Component
@AllArgsConstructor
public class UserPermissionEvaluator implements PermissionEvaluator {

    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if (targetType.equals(PRODUCT)) {
            Optional<Product> product = productRepository.findById(targetId.toString());
            if (product.isPresent()) {
                return product.get().getProductOwner().getEmail().equals(authentication.getName());
            }
        }
        if (targetType.equals(OFFER)) {
            Optional<Offer> offer = offerRepository.findById(targetId.toString());
            if (offer.isPresent()) {
                return offer.get().getOfferOwner().getEmail().equals(authentication.getName());
            }
        }
        if (targetType.equals(USER)) {
            Optional<User> user = userRepository.findById(targetId.toString());
            if (user.isPresent()) {
                return user.get().getEmail().equals(authentication.getName());
            }
        }
        return false;
    }
}
