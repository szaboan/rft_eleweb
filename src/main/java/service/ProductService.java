package service;

import java.util.List;
import java.util.Optional;

import repository.ProductRepository;
import model.entity.Product;

/**
 * Szolgáltatás a termékek kezelésére.
 */
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Létrehozza a {@code ProductService} példányt a megadott {@code ProductRepository} használatával.
     * 
     * @param productRepository a termékekhez tartozó adattár, amely a termékek adatainak lekérdezését és kezelését biztosítja
     * @throws NullPointerException ha a {@code productRepository} null értéket kap
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Lekéri az összes terméket.
     *
     * @return a termékek listája
     */
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    
    /**
     * Lekéri egy adott termék részletes adatait.
     *
     * @param productId a termék azonosítója
     * @return a termék adatai
     * @throws Exception ha a termék nem található
     */
    public Product getProductDetails(int productId) throws Exception {
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new Exception("Termék nem található!");
        }
        return product;
    }
    
}

