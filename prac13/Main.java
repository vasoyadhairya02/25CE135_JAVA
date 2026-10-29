public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer Box: " + intBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Java");
        System.out.println("String Box: " + stringBox.get());

        Pair<String, Integer> pair =
            new Pair<>("Yash", 20);

        System.out.println("Pair First: " + pair.getFirst());
        System.out.println("Pair Second: " + pair.getSecond());

        String[] names = {"Amit", "Neha", "Rahul"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("First Name: " +
            GenericUtils.firstElement(names));

        System.out.println("First Number: " +
            GenericUtils.firstElement(numbers));
    }
}