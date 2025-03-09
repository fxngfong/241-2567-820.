public class DetailReceipt implements interface Receipt{
    public void printReceipt() {
        System.out.println("===== ใบเสร็จรับเงิน (แบบละเอียด) =====");
        System.out.println("ลูกค้า: "+ customerName);
        System.out.println("รายการสินค้า: ");
        double total = 0;
        for (int i = 0; i < item.length; i++) {
            System.out.println(" " + (i+1) + ")\t" + items[i] + ": " + prices[i] + " บาท");
            total += prices[i];
        }
        System.out.println("รวมทั้งหมด: " + total + " บาท");
        System.out.println("==================================");
    }
}