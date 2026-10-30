package slides.nested_classes;

public class LocalClassDemo {
    static String regularExpression = "[^0-9]"; // Static field: any character except 0 to 9
    int intField = 10;

    public double m1(double d1, int i1) {
        final double factor1 = 0.3;
        double factor2 = 0.7;
        double res = 0;

        class LocalClass {
            private int localField;
            public LocalClass(int v) {
                localField = v;
            }
            public double process(int v) {
                return v + factor1 + d1 + factor2 + localField + intField + regularExpression.length();
            }
        }

        LocalClass local = new LocalClass(5);
        res = local.process(i1);
        return res + regularExpression.indexOf('^');

    }
    public static void main(String[] args) {
        LocalClassDemo demo = new LocalClassDemo();
        System.out.println("m1(3.5, 20) = " + demo.m1(3.5, 20));
    }

}
