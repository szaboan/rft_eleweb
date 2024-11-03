package eleweb;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.entity.Cart;
import model.entity.Product;
import repository.CartRepository;
import repository.ProductRepository;
import service.CartService;

public class CartServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddToCart_ProductNotFound() {
        int userId = 1;
        int productId = 1;
        int quantity = 1;

        when(productRepository.findById(productId)).thenReturn(null);

        Exception exception = assertThrows(Exception.class, () -> {
            cartService.addToCart(userId, productId, quantity);
        });

        assertEquals("Termék nem található!", exception.getMessage());
    }

    @Test
    public void testAddToCart_Success() throws Exception {
        int userId = 1;
        int productId = 1;
        int quantity = 2;

        Product product = new Product(); // Itt példányosítsd a Product osztályt, és állítsd be a szükséges mezőket
        product.setId(productId);
        // További mezők beállítása a termékhez, ha szükséges

        Cart cart = new Cart(); // Hasonlóan, példányosítsd a Cart osztályt

        when(productRepository.findById(productId)).thenReturn(product);
        when(cartRepository.findByUserId(userId)).thenReturn(cart);
        when(cartRepository.save(cart)).thenReturn(cart);

        Cart updatedCart = cartService.addToCart(userId, productId, quantity);

        assertNotNull(updatedCart);
        assertEquals(cart, updatedCart);
        verify(cartRepository).save(cart);
    }
}
