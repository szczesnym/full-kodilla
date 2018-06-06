package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.InvoiceLine;
import com.kodilla.hibernate.invoice.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest

public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() throws Exception {
        //Given
        Item sutItem1 = new Item("Item 1");
        Item sutItem2 = new Item("Item 2");
        Item sutItem3 = new Item("Item 3");
        Item sutItem4 = new Item("Item 4");

        InvoiceLine sutInvoiceLine1 = new InvoiceLine(sutItem1,new BigDecimal(10.0), 7);
        InvoiceLine sutInvoiceLine2= new InvoiceLine(sutItem2,new BigDecimal(11.0), 8);
        InvoiceLine sutInvoiceLine3 = new InvoiceLine(sutItem3,new BigDecimal(12.0), 9);
        InvoiceLine sutInvoiceLine4 = new InvoiceLine(sutItem4,new BigDecimal(13.0), 10);

        Invoice sutInvoice = new Invoice("INV0001");
        sutInvoice.getLines().add(sutInvoiceLine1);
        sutInvoice.getLines().add(sutInvoiceLine2);
        sutInvoice.getLines().add(sutInvoiceLine3);
        sutInvoice.getLines().add(sutInvoiceLine4);
        //When
        invoiceDao.save(sutInvoice);
        //Then
        Assert.assertNotEquals(0, sutInvoiceLine1.getId());
        Assert.assertNotEquals(0, sutInvoiceLine2.getId());
        Assert.assertNotEquals(0, sutInvoiceLine3.getId());
        Assert.assertNotEquals(0, sutInvoiceLine4.getId());

        Assert.assertNotEquals(0, sutInvoice.getId());
        //Clean up
        //bez catch-try bo zadeklarowałem test jako throws
        //invoiceDao.delete(sutInvoice);
    }

}
