package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoices")
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
            fetch = FetchType.LAZY
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
}
