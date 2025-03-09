public class MyCalculator implements XCalculator , YCalculator{

    @Override
    public double add2Number(double a, double b) {
        //double r = a+b;
        return a+b;
    }

    @Override
    public double sub2Number(double a, double b) {
        return a-b;
    }

    @Override
    public double multiply2Number(double a, double b) {
        return a*b;
    }

    @Override
    public double divide2Number(double a, double b) {
        return a/b;
    }
}
