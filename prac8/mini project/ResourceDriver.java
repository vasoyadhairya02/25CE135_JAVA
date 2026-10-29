package Practical_8;

public class ResourceDriver {

    public static void main(String[] args) {

        try (DemoResource resource =
                     new DemoResource()) {

            resource.useResource();

            throw new RuntimeException(
                    "Original error inside try block");
        }

        catch (Exception e) {

            System.out.println(
                    "Caught error: "
                    + e.getMessage());
        }
    }
}