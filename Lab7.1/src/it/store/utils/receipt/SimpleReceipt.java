public class SimpleReceipt implements interface Receipt{

    @Override
    public void printReceipt() {
        System.out.println("===== ใบเสร็จรับเงิน (แบบง่าย) =====");
        System.out.println("ลูกค้า: "+ customerName);
        System.out.println("จำนวนเงิน: " + amount + " บาท");
        System.out.println("===================================");
    }
}
