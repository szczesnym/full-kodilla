package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private ProductService productService;
    private List<Item> items = new ArrayList<>();
    private Long orderId, userId;
    private boolean isPaid, isVeryfied, isSubmited;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isVeryfied() {
        return isVeryfied;
    }

    public void setVeryfied(boolean veryfied) {
        isVeryfied = veryfied;
    }

    public boolean isSubmited() {
        return isSubmited;
    }

    public void setSubmited(boolean submited) {
        isSubmited = submited;
    }

    public Order(Long orderId, Long userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

    public boolean removeItem(Long itemId) {
         List<Item> itemsToRevome = items.stream()
                 .filter(item -> item.getProductId().equals(itemId))
                 .collect(Collectors.toList());
         if(!itemsToRevome.isEmpty()) {
             itemsToRevome.stream().
                     forEach(item -> items.remove(item));
             return true;
         } else {
             return false;
         }
    }

    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(productService.getPrice(item.getProductId())).multiply(new BigDecimal(item.getQty()));
        }
        return sum;
    }

    public void addItem(Long orderId, Long productId, double qty ) {

    }
}
