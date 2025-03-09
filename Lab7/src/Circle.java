public class Circle implements Shape{
    private  double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
  //  public Circle(String r) {

   // }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("Circle (radius: " + radius + "), area: " + getArea());
    }

    // public void displayInfo(String info) {

    //}
    //public static void main(String[] args) {
      // Circle c1 = new Circle(6.0);
      //c1.displayInfo();
    //}
}
