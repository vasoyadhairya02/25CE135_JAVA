public class TemplateFiller {

    public static String findValue(String key,
                                   String[] names,
                                   String[] values) {

        for (int i = 0; i < names.length; i++) {

            if (names[i].equals(key)) {
                return values[i];
            }
        }

        return "[?]";
    }
}