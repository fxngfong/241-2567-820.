package it.store.utils.receipt;

public class TestReceipt {
    public static void main(String[] args) {
        // ทดสอบใบเสร็จแบบง่าย
        Receipt simpleReceipt = new SimpleReceipt("สมหวัง ใจดี", 1500.00);
        simpleReceipt.printReceipt();

        // ทดสอบใบเสร็จแบบละเอียด
        String[] items = {"WiFi-IP Camera", "Power Bank 6000 mAh", "Panasonic Battery AAA", "Adapter DC 12V"};
        double[] prices = {1200.00, 550.00, 65.00, 120.00};
        Receipt detailReceipt = new DetailReceipt("สมหวัง ใจดี", items, prices);
        detailReceipt.printReceipt();
    }
}