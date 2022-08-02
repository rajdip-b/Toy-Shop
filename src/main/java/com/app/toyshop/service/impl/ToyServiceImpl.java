package com.app.toyshop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.toyshop.entity.Toy;
import com.app.toyshop.exceptions.ToyException;
import com.app.toyshop.repository.ToyRepository;
import com.app.toyshop.service.ToyService;

@Service
public class ToyServiceImpl implements ToyService {

    @Autowired
    private ToyRepository toyRepository;

    @Override
    public Long createToy(Toy toy) {
        return toyRepository.save(new Toy(null, toy.getName(), toy.getPrice())).getId();
    }

    @Override
    @Transactional
    public void updatePrice(Long toyId, Double price) throws ToyException {
        toyRepository.findById(toyId).orElseThrow(() -> new ToyException()).setPrice(price);
    }

    @Override
    public void deleteToy(Long toyId) throws ToyException {
        toyRepository.delete(toyRepository.findById(toyId).orElseThrow(() -> new ToyException()));
    }

    @Override
    public Toy getToy(Long toyId) throws ToyException {
        return toyRepository.findById(toyId).orElseThrow(() -> new ToyException());
    }

    @Override
    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

}
