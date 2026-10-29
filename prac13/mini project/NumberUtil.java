package Practical_13.Practical_13B;

public class NumberUtil {

    public static <N extends Number>
    double average(N[] values) {

        if (values == null || values.length == 0) {
            return 0.0;
        }

        double total = 0;

        for (N value : values) {

            total += value.doubleValue();
        }

        return total / values.length;
    }
}