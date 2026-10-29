package Practical_7;

public class Driver2 {

    public static void main(String[] args) {

        SampleTests tests =
                new SampleTests();

        int count =
                MiniTestRunner.runTests(tests);

        System.out.println(
                "Total tests run: " + count);
    }
}
