package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public String show() {
        String returnString = "";
        returnString += "\tID:" + id +"\n";
        returnString += "\tPrice:" + price +"\n";
        returnString += "\tQuantity:" + quantity +"\n";
        returnString += "\tValue:" + value +"\n";
        returnString += "\tInvoice ID:" + invoice.getId() +"\n";
        returnString += "\t\tItem:" + item +"\n";
        return returnString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceLine that = (InvoiceLine) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getItem(), that.getItem()) &&
                getPrice().compareTo(that.getPrice()) == 0 &&
                //Objects.equals(getValue(), that.getValue()) &&
                Objects.equals(getInvoice().getId(), that.getInvoice().getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getItem(), getPrice(), getQuantity(), getValue(), getInvoice());
    }
}
