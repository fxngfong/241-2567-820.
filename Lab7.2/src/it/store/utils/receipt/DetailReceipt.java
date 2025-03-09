package it.store.utils.receipt;

public class DetailReceipt implements Receipt {
    private String customerName;
    private String[] items;
    private double[] prices;

    public DetailReceipt(String customerName, String[] items, double[] prices) {
        this.customerName = customerName;
        this.items = items;
        this.prices = prices;
    }

    @Override
    public void printReceipt() {
        System.out.println("===== ใบเสร็จรับเงิน (แบบละเอียด) =====");
        System.out.println("ลูกค้า: " + customerName);
        System.out.println("รายการสินค้า:");
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ") " + items[i] + ": " + prices[i] + " บาท");
            total += prices[i];
        }
        System.out.println("รวมทั้งหมด: " + total + " บาท");
        System.out.println("=================================");
    }
}
