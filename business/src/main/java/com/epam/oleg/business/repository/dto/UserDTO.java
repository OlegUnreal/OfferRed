package com.epam.oleg.business.repository.dto;

import com.epam.oleg.business.entities.UserRole;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserDTO {
    @Id
    private String id;
    private String name;
    private UserRole userRole;
    @OneToMany(mappedBy = "productOwner")
    private List<ProductDTO> products;
    @OneToMany(mappedBy = "offerOwner")
    private List<OfferDTO> offers;
}
