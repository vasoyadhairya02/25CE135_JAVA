
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) {
        String[] fileNames = {"log1.txt", "log2.txt", "log3.txt"};
        String keyword = "ERROR";

        int totalLines = 0;
        int matchingLines = 0;

        for (String fileName : fileNames) {
            Path path = Paths.get(fileName);

            try {
                BasicFileAttributes attributes =
                    Files.readAttributes(path, BasicFileAttributes.class);

                System.out.println("\nFile: " + fileName);
                System.out.println("Size: " + attributes.size() + " bytes");

                List<String> lines = Files.readAllLines(path);

                for (String line : lines) {
                    totalLines++;

                    if (line.contains(keyword)) {
                        matchingLines++;
                        System.out.println("Match: " + line);
                    }
                }

            } catch (IOException e) {
                System.out.println("Error reading " + fileName + ": "
                                   + e.getMessage());
            }
        }

        System.out.println("\nTotal lines: " + totalLines);
        System.out.println("Lines containing \"" + keyword + "\": "
                           + matchingLines);
    }
}
