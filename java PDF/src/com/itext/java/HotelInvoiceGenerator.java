package com.itext.java;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class HotelInvoiceGenerator {
    public static void main(String[] args) {
        try {
            // Invoice file path
            String invoicePath = "Hotel_Invoice.pdf";

            // Document setup
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(invoicePath));
            document.open();

            // Add title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
            Paragraph title = new Paragraph("Hotel Management System - Invoice", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("\n")); // Spacer

            // Guest information
            document.add(new Paragraph("Guest Name: John Doe"));
            document.add(new Paragraph("Contact: +1234567890"));
            document.add(new Paragraph("Check-in Date: 2024-12-01"));
            document.add(new Paragraph("Check-out Date: 2024-12-06"));
            document.add(new Paragraph("\n"));

            // Table for invoice details
            PdfPTable table = new PdfPTable(4); // 4 columns
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Add table headers
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            table.addCell(new PdfPCell(new Phrase("Description", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Unit Price", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Quantity", headerFont)));
            table.addCell(new PdfPCell(new Phrase("Total", headerFont)));

            // Add room charges
            table.addCell("Deluxe Room (5 nights)");
            table.addCell("$120.00");
            table.addCell("5");
            table.addCell("$600.00");

            // Add restaurant charges
            table.addCell("Room Service (3 orders)");
            table.addCell("$25.00");
            table.addCell("3");
            table.addCell("$75.00");

            // Add laundry charges
            table.addCell("Laundry Service");
            table.addCell("$10.00");
            table.addCell("2");
            table.addCell("$20.00");

            // Add additional rows as needed
            table.addCell("WiFi (5 days)");
            table.addCell("$5.00");
            table.addCell("5");
            table.addCell("$25.00");

            // Add table to the document
            document.add(table);

            // Add total amount
            document.add(new Paragraph("Subtotal: $720.00"));
            document.add(new Paragraph("Tax (10%): $72.00"));
            document.add(new Paragraph("Grand Total: $792.00", titleFont));
            document.add(new Paragraph("\n"));

            // Add footer
            Paragraph footer = new Paragraph("Thank you for staying with us!");
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            // Close document
            document.close();

            System.out.println("Invoice generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
