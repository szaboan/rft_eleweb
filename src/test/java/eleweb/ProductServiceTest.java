package eleweb;

import model.entity.Product;
import repository.ProductRepository;
import service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testGetProductDetails_ProductExists() throws Exception {
        // Given
        int productId = 1;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setName("Test Product");
        expectedProduct.setPrice(100.00);

        when(productRepository.findById(productId)).thenReturn(expectedProduct);

        // When
        Product actualProduct = productService.getProductDetails(productId);

        // Then
        assertEquals(expectedProduct, actualProduct);
        verify(productRepository).findById(productId); // Ellenőrizzük, hogy a metódus hívták
    }

    @Test
    public void testGetProductDetails_ProductNotFound() {
        // Given
        int productId = 2;

        when(productRepository.findById(productId)).thenReturn(null);

        // When & Then
        Exception exception = assertThrows(Exception.class, () -> {
            productService.getProductDetails(productId);
        });

        assertEquals("Termék nem található!", exception.getMessage());
        verify(productRepository).findById(productId); // Ellenőrizzük, hogy a metódus hívták
    }
}