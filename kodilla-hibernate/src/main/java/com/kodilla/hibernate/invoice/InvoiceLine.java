package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "invoice_lines")
public class InvoiceLine {
    private int id;
    private Item item;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;

    public InvoiceLine() {
    }

    public InvoiceLine(Item item, BigDecimal price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(new BigDecimal(quantity));
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="item_id" )
    public Item getItem() {
        return item;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Transient
    public BigDecimal getValue() {
        return this.value;
    }
    public void setValue() {
        this.value = this.price.multiply(new BigDecimal(this.quantity));
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }



    public void setItem(Item item) {
        this.item = item;
    }








}
