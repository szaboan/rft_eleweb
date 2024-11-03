package service;

import model.entity.Cart;
import model.entity.Product;
import repository.CartRepository;
import repository.ProductRepository;

/**
 * Szolgáltatás a kosár kezelésére.
 */
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    
    /**
     * Szolgáltatás a kosár kezelésére. 
     * Ezzel a konstruktorral inicializálható a {@code CartService} osztály a kosár és termékek adattárainak használatával.
     *
     * @param cartRepository a felhasználók kosarainak adattára, amely a kosár adatok kezelését és mentését végzi
     * @param productRepository a termékek adattára, amely a termékek adatainak lekérdezését és kezelését biztosítja
     * @throws NullPointerException ha a {@code cartRepository} vagy a {@code productRepository} null értéket kap
     */
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    /**
     * Kosárhoz ad egy terméket.
     *
     * @param userId a felhasználó azonosítója
     * @param productId a termék azonosítója
     * @param quantity a mennyiség
     * @return a frissített kosár
     * @throws Exception ha a termék nem található
     */
    public Cart addToCart(int userId, int productId, int quantity) throws Exception {
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new Exception("Termék nem található!");
        }
        Cart cart = cartRepository.findByUserId(userId);
        cart.addProduct(product, quantity);
        return cartRepository.save(cart);
    }
}
