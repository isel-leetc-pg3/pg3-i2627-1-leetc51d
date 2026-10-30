package slides.nested_classes;

public class AnonymousClassDemo {

    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello() {

        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        frenchGreeting.greetSomeone("Fred");
    }

    public static void main(String... args) {
        AnonymousClassDemo myApp = new AnonymousClassDemo();
        myApp.sayHello();
    }
}
