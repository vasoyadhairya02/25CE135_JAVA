package Practical_11.Practical_11B;

import java.io.BufferedReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    public static void generate(Path logsFolder,
                                Path reportFile) {

        long totalDeposits = 0;
        long totalWithdrawals = 0;

        List<String> report =
                new ArrayList<>();

        report.add("----- END OF DAY REPORT -----");

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(logsFolder)) {

            for (Path file : stream) {

                if (!Files.isRegularFile(file)) {
                    continue;
                }

                BasicFileAttributes attrs =
                        Files.readAttributes(
                                file,
                                BasicFileAttributes.class);

                report.add(
                        "File: " + file.getFileName());

                report.add(
                        "Size: " + attrs.size()
                        + " bytes");

                report.add(
                        "Last Modified: "
                        + attrs.lastModifiedTime());

                try (BufferedReader reader =
                             Files.newBufferedReader(file)) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        String[] parts =
                                line.trim().split("\\s+");

                        if (parts.length != 2) {
                            continue;
                        }

                        String type =
                                parts[0].toUpperCase();

                        long amount;

                        try {
                            amount =
                                    Long.parseLong(parts[1]);
                        }
                        catch (NumberFormatException e) {
                            continue;
                        }

                        if (type.equals("DEPOSIT")) {

                            totalDeposits += amount;

                        }
                        else if (type.equals("WITHDRAW")) {

                            totalWithdrawals += amount;
                        }
                    }
                }

                report.add("----------------------");
            }

            report.add(
                    "Total Deposits: "
                    + totalDeposits);

            report.add(
                    "Total Withdrawals: "
                    + totalWithdrawals);

            Files.write(
                    reportFile,
                    report);

            System.out.println(
                    "Report generated successfully");

        }
        catch (Exception e) {

            System.out.println(
                    "Report Error: "
                    + e.getMessage());
        }
    }
}