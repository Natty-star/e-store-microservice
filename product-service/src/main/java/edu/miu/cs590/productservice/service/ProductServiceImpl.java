package edu.miu.cs590.productservice.service;

import edu.miu.cs590.productservice.domain.Product;
import edu.miu.cs590.productservice.productRepo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getId(Long id) {
        return productRepo.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product edit(Product product) {
        return productRepo.save(product);
    }


}
