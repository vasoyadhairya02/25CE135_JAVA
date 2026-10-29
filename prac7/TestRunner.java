import java.lang.reflect.Method;

public class TestRunner {

    public static void runTests(Class<?> testClass) {

        int count = 0;

        try {
            Object obj = testClass.getDeclaredConstructor().newInstance();

            Method[] methods = testClass.getDeclaredMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(Run.class)
                        && method.getParameterCount() == 0) {

                    method.invoke(obj);
                    count++;
                }
            }

            System.out.println("Total tests ran: " + count);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}