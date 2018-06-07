package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    private int id;
    private String number;
    List<InvoiceLine> lines= new ArrayList<>();

    public Invoice() {
    }

    public Invoice(String number) {
        this.number = number;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "invoice_number")
    public String getNumber() {
        return number;
    }

    @OneToMany( targetEntity = InvoiceLine.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public void show() {
        System.out.format("Invoice ID:%d\n", id);
        System.out.format("Invoice NUMBER:%s\n", number);
        lines.stream().forEach(line -> System.out.print(line.show()));

    }
}
