package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.entities.UserRole;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserCriteria {
    private final EntityManager entityManager;

    public List<User> findAll(String email, String name, UserRole userRole, Gender gender, String city, Integer age) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        if (StringUtils.isNotEmpty(email)) {
            Predicate emailPredicate = cb.equal(user.get("email"), email);
            cq.where(emailPredicate);
        }
        if (StringUtils.isNotEmpty(name)) {
            Predicate namePredicate = cb.equal(user.get("name"), name);
            cq.where(namePredicate);
        }
        if (userRole != null) {
            Predicate userRolePredicate = cb.equal(user.get("userRole"), userRole);
            cq.where(userRolePredicate);
        }
        if (gender != null) {
            Predicate genderPredicate = cb.equal(user.get("gender"), gender);
            cq.where(genderPredicate);
        }
        if (StringUtils.isNotEmpty(city)) {
            Predicate cityPredicate = cb.equal(user.get("city"), city);
            cq.where(cityPredicate);
        }
        if (age != null) {
            Predicate agePredicate = cb.equal(user.get("age"), age);
            cq.where(agePredicate);
        }
         TypedQuery<User> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
