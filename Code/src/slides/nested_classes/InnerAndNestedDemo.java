package slides.nested_classes;

public class InnerAndNestedDemo {
    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();
        System.out.println("From demo: " + innerObject.innerField);
        System.out.println("From demo: " + OuterClass.InnerClass.staticInnerField);

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);
        System.out.println("From demo: " + staticNestedObject.nestedField);
        System.out.println("From demo: " + OuterClass.StaticNestedClass.staticNestedField);

        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        TopLevelClass topLevelObject = new TopLevelClass();
        topLevelObject.accessMembers(outerObject);
    }
}
