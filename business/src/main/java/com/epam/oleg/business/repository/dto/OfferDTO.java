package com.epam.oleg.business.repository.dto;

import com.epam.oleg.business.entities.OfferStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offers")
@Data
public class OfferDTO {
    @Id
    private String id;
    private OfferStatus offerStatus;
    @ManyToOne
    @JoinColumn
    private UserDTO offerOwner;
    @OneToMany
    private List<ProductDTO> products;
}
