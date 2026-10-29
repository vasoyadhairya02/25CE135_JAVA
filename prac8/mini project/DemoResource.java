package Practical_8;

public class DemoResource implements AutoCloseable {

    public DemoResource() {

        System.out.println("Resource opened");
    }

    public void useResource() {

        System.out.println("Resource is being used");
    }

    @Override
    public void close() {

        System.out.println("Resource closed");
    }
}