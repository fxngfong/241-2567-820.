import java.awt.*;

public class TestShape {
    public static void main(String[] args) {
        //Polymorphism
        Shape myCircle = new Circle(5);
        myCircle.displayInfo();

        Shape myRectangle = new Rectangle(15, 2);
        myRectangle.displayInfo();
        System.out.println("Area of Rectangle" + myRectangle.getArea());
    }
}
