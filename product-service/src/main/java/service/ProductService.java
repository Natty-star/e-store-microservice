package service;

import domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAll();

    Product getId(Long id);

    Product save(Product product);

    Product edit(Product product);




}
