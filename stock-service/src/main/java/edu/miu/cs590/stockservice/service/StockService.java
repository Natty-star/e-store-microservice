package edu.miu.cs590.stockservice.service;

import edu.miu.cs590.stockservice.domain.Product;

import java.util.List;

public interface StockService {

    List<Product> getAll();

}
