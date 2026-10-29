package Practical_11.Practical_11B;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TransactionLog {

    public static void append(Path file,
                              String line) {

        try {

            Files.write(
                    file,
                    (line + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        }
        catch (Exception e) {

            System.out.println(
                    "Log Error: " + e.getMessage());
        }
    }
}