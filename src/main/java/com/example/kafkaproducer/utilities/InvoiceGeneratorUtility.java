package com.example.kafkaproducer.utilities;

import com.example.kafkaproducer.collaborators.models.Invoice;

import java.util.Random;

public class InvoiceGeneratorUtility {
    public static Invoice getNextInvoice(long id) {
        Random random = new Random();

        double net = random.nextDouble();
        double tax = net * .10;
        double total = net + tax;

        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setNetAmount(net);
        invoice.setTaxAmount(tax);
        invoice.setTotalAmount(total);

        return invoice;
    }
}
