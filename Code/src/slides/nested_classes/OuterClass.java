package slides.nested_classes;

public class OuterClass {
    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        String innerField = "Inner field";
        static String staticInnerField = "Static inner field";
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
            System.out.println(innerField);
            System.out.println(staticInnerField);
        }
        static void myStaticMethod() {
            System.out.println("My static method");
        }
    }

    static class StaticNestedClass {
        String nestedField = "Nested field";
        static String staticNestedField = "Static nested field";
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
            System.out.println(nestedField);
            System.out.println(staticNestedField);
        }
    }
}
