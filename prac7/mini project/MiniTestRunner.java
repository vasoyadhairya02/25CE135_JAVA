package Practical_7;

import java.lang.reflect.Method;

public class MiniTestRunner {

    public static int runTests(Object obj) {

        int count = 0;

        Method[] methods =
                obj.getClass().getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)) {

                try {

                    method.invoke(obj);

                    count++;

                }
                catch (Exception e) {

                    System.out.println(
                            "Error running: " +
                            method.getName());
                }
            }
        }

        return count;
    }
}