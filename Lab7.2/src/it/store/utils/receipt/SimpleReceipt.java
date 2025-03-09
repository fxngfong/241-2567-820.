package it.store.utils.receipt;

public class SimpleReceipt implements Receipt {
    private String customerName;
    private double amount;


    public SimpleReceipt(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public void printReceipt() {
        System.out.println("===== ใบเสร็จรับเงิน (แบบง่าย) =====");
        System.out.println("ลูกค้า: " + customerName);
        System.out.println("จำนวนเงิน: " + amount + " บาท");
        System.out.println("=================================");
    }
}