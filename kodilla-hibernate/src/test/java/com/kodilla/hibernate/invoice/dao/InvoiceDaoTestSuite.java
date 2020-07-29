package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        List<Item> items = new ArrayList<>();
        Invoice invoice = new Invoice("458", items);

        Product carrot = new Product("Carrot");
        Product window = new Product("Window");
        Product chair = new Product("Chair");
        Product table = new Product("Table");

        productDao.save(carrot);
        productDao.save(window);
        productDao.save(chair);
        productDao.save(table);

        Item item1 = new Item(carrot, new BigDecimal("1.39"), 2, new BigDecimal("3.38"));
        Item item2 = new Item(window, new BigDecimal("199.39"), 7, new BigDecimal("1395.73"));
        Item item3 = new Item(chair, new BigDecimal("59.65"), 6, new BigDecimal("357.9"));
        Item item4 = new Item(table, new BigDecimal("121.78"), 1, new BigDecimal("121.78"));

        carrot.getItems().add(item1);
        window.getItems().add(item2);
        chair.getItems().add(item3);
        table.getItems().add(item4);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);

        int item1Id = item1.getId();
        int item2Id = item2.getId();
        int item3Id = item3.getId();
        int item4Id = item4.getId();
        int item1Quantity = item1.getQuantity();
        int item2Quantity = item2.getQuantity();
        int item3Quantity = item3.getQuantity();
        int item4Quantity = item4.getQuantity();

        //Then
        Assert.assertNotEquals(0, item1Id);
        Assert.assertNotEquals(0, item2Id);
        Assert.assertNotEquals(0, item3Id);
        Assert.assertNotEquals(0, item4Id);
        Assert.assertEquals(2, item1Quantity);
        Assert.assertEquals(7, item2Quantity);
        Assert.assertEquals(6, item3Quantity);
        Assert.assertEquals(1, item4Quantity);

        //CleanUp
        itemDao.deleteAll();
        productDao.deleteAll();
        invoiceDao.deleteAll();


    }
}
