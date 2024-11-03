package service;

import model.entity.Cart;
import model.entity.Order;
import repository.CartRepository;
import repository.OrderRepository;

/**
 * Szolgáltatás a rendelések kezelésére.
 */
public class OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    public OrderService(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * Véglegesíti a rendelést a kosár tartalmából.
     *
     * @param userId a felhasználó azonosítója
     * @return a létrehozott rendelés
     */
    public Order finalizeOrder(int userId) {
        Cart cart = cartRepository.findByUserId(userId);
        Order order = createOrderFromCart(cart);
        cart.clear();
        return orderRepository.save(order);
    }

    // Példaként egy segédmetódus, amely a kosárból hoz létre rendelést
    private Order createOrderFromCart(Cart cart) {
        // Rendelés létrehozásának logikája
        return new Order();
    }
    
    /**
     * Lekéri a rendelés állapotát.
     *
     * @param orderId a rendelés azonosítója
     * @return a rendelés állapota
     * @throws Exception ha a rendelés nem található
     */
    public String getOrderStatus(int orderId) throws Exception {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new Exception("Rendelés nem található!");
        }
        return order.getStatus();
    }

}
