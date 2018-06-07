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
        Item testItem1 = new Item("Item 1");
        Item testItem2 = new Item("Item 2");
        Item testItem3 = new Item("Item 3");
        Item testItem4 = new Item("Item 4");

        InvoiceLine testInvoiceLine1 = new InvoiceLine(testItem1,new BigDecimal(10.0), 7);
        InvoiceLine testInvoiceLine2= new InvoiceLine(testItem2,new BigDecimal(11.0), 8);
        InvoiceLine testInvoiceLine3 = new InvoiceLine(testItem3,new BigDecimal(12.0), 9);
        InvoiceLine testInvoiceLine4 = new InvoiceLine(testItem4,new BigDecimal(13.0), 10);

        Invoice testInvoice = new Invoice("INV0001");
        testInvoice.getLines().add(testInvoiceLine1);
        testInvoice.getLines().add(testInvoiceLine2);
        testInvoice.getLines().add(testInvoiceLine3);
        testInvoice.getLines().add(testInvoiceLine4);

        //When
        invoiceDao.save(testInvoice);
        int testInvoiceId = testInvoice.getId();
        Invoice sutInvoice = invoiceDao.findById(testInvoiceId).orElse(null);

        //Then
        /*Assert.assertEquals(4, sutInvoice.getLines().size());
        Assert.assertTrue(sutInvoice.getLines().contains(testInvoiceLine1));
        Assert.assertTrue(sutInvoice.getLines().contains(testInvoiceLine2));
        Assert.assertTrue(sutInvoice.getLines().contains(testInvoiceLine3));
        Assert.assertTrue(sutInvoice.getLines().contains(testInvoiceLine4));

        int testInvoiceLine1No = sutInvoice.getLines().indexOf(testInvoiceLine1);
        int testInvoiceLine2No = sutInvoice.getLines().indexOf(testInvoiceLine2);
        int testInvoiceLine3No = sutInvoice.getLines().indexOf(testInvoiceLine3);
        int testInvoiceLine4No = sutInvoice.getLines().indexOf(testInvoiceLine4);

        Assert.assertEquals(testItem1, sutInvoice.getLines().get(testInvoiceLine1No).getItem());
        Assert.assertEquals(testItem2, sutInvoice.getLines().get(testInvoiceLine2No).getItem());
        Assert.assertEquals(testItem3, sutInvoice.getLines().get(testInvoiceLine3No).getItem());
        Assert.assertEquals(testItem4, sutInvoice.getLines().get(testInvoiceLine4No).getItem());*/

        //Clean up
        invoiceDao.delete(sutInvoice);
    }

}
