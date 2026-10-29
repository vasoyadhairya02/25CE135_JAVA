public class GenericUtils {
    public static <T> T firstElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        return array[0];
    }
}