package com.app.toyshop.service;

import java.util.List;

import com.app.toyshop.entity.Toy;
import com.app.toyshop.exceptions.ToyException;

public interface ToyService {

    Long createToy(Toy toy);

    void updatePrice(Long toyId, Double price) throws ToyException;

    void deleteToy(Long toyId) throws ToyException;

    Toy getToy(Long toyId) throws ToyException;

    List<Toy> getAllToys();

}
