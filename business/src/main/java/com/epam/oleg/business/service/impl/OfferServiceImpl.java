package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.OfferCriteria;
import com.epam.oleg.business.repository.OfferRepository;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.business.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;
    private final OfferCriteria offerCriteria;

    @Override
    public List<Offer> findAll(OfferStatus offerStatus, String offerOwner, String productId) {
        return offerCriteria.findAll(offerStatus, offerOwner, productId);
    }

    @Override
    public Offer getById(String id) {
        return offerRepository.findById(id).orElseThrow((() -> new NotFoundException("Offer with id " + id
                + " not found")));
    }

    @Override
    public Offer save(Offer offer) {
        List<Product> products = offer.getProducts();
        if (CollectionUtils.isNotEmpty(products)) {
            int price = 0;
            for (Product p : products) {
                price += p.getPrice();
            }
            offer.setPrice(price);
        }
        return offerRepository.save(offer);
    }

    @Override
    public Offer update(Offer offer) {
        if (offerRepository.existsById(offer.getId())) {
            return offerRepository.save(offer);
        }
        throw new NotFoundException("Can't update offer with id " + offer.getId() + ". Offer not found");
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void buyOffer(String id, User user) {
        Offer offer = getById(id);
        if (offer.getOfferOwner().getId().equals(user.getId())) {
            throw new UnsupportedOperationException("Cannot buy your own offer");
        }
        if (offer.getPrice() > user.getBalance()) {
            throw new UnsupportedOperationException("Not enough money on the balance");
        }
        user.setBalance(user.getBalance() - offer.getPrice());
        offer.setOfferStatus(OfferStatus.COMPLETED);
        userService.update(user);
        update(offer);
    }

    @Override
    public void delete(String id) {
        offerRepository.deleteById(id);
    }
}
