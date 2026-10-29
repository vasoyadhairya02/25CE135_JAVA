package Practical_14.Practical_14B;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TransactionLog {

    public static void append(Path file,
                              String line) {

        try {

            if (file.getParent() != null) {

                Files.createDirectories(
                        file.getParent());
            }

            Files.writeString(
                    file,
                    line + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        }
        catch (Exception e) {

            System.out.println(
                    "Log Error: "
                    + e.getMessage());
        }
    }
}