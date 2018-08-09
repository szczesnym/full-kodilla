package com.kodilla.patterns2.facade;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private ProductService productService;

    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long) orders.stream()
                    .mapToInt(order -> order.getOrderId().intValue())
                    .max()
                    .orElse(0);
            orders.add(new Order(maxOrder++, userId));
            return maxOrder;
        } else {
            return -1L;
        }
    }

    public Iterator<Order> ordersFromListOfId(Long orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
    }


    public void addItem(Long orderId, Long productId, double qty) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(o -> o.getItems().add(new Item(productId, qty)));
    }

    public void removeItem(Long orderId, Long productId) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach((order -> order.removeItem(productId)));
    }

    public BigDecimal calculateValue(Long orderId) {
        BigDecimal orderValue = BigDecimal.ZERO;
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> orderValue.add(order.calculateValue()));
        return orderValue;
    }

    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = ordersFromListOfId(orderId);
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isPaid()) {
                return true;
            } else {
                Random generator = new Random();
                theOrder.setPaid(generator.nextBoolean());
            }
        }
        return false;
    }

    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = ordersFromListOfId(orderId);
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            Random generator = new Random();
            if (!theOrder.isVeryfied()) {
                theOrder.setVeryfied(theOrder.isPaid() && generator.nextBoolean());
            }
            return theOrder.isVeryfied();
        }
        return false;
    }

    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = ordersFromListOfId(orderId);
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isVeryfied()) {
                theOrder.setSubmited(true);
            }
            return theOrder.isSubmited();
        }
        return false;
    }

    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = ordersFromListOfId(orderId);
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }
}
