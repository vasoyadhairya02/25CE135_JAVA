package Practical_14.Practical_14B;

import java.io.BufferedReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class ReportGenerator {

    public static void generate(Path logsFolder,
                                Path reportFile) {

        long totalDeposits = 0;
        long totalWithdrawals = 0;

        ArrayList<String> report =
                new ArrayList<>();

        report.add(
                "----- MINIBANK REPORT -----");

        try {

            Files.createDirectories(logsFolder);

            try (DirectoryStream<Path> stream =
                         Files.newDirectoryStream(logsFolder)) {

                for (Path file : stream) {

                    if (!Files.isRegularFile(file)) {
                        continue;
                    }

                    BasicFileAttributes attr =
                            Files.readAttributes(
                                    file,
                                    BasicFileAttributes.class);

                    report.add(
                            "File: "
                            + file.getFileName());

                    report.add(
                            "Size: "
                            + attr.size()
                            + " bytes");

                    report.add(
                            "Modified: "
                            + attr.lastModifiedTime());

                    try (BufferedReader reader =
                                 Files.newBufferedReader(file)) {

                        String line;

                        while ((line = reader.readLine())
                                != null) {

                            String[] parts =
                                    line.split("\\s+");

                            if (parts.length < 2) {
                                continue;
                            }

                            try {

                                long amount =
                                        Long.parseLong(
                                                parts[1]);

                                if (parts[0]
                                        .equalsIgnoreCase(
                                                "DEPOSIT")) {

                                    totalDeposits += amount;
                                }

                                else if (parts[0]
                                        .equalsIgnoreCase(
                                                "WITHDRAW")) {

                                    totalWithdrawals += amount;
                                }

                            }
                            catch (NumberFormatException e) {
                                // skip bad log line
                            }
                        }
                    }
                }
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

        }
        catch (Exception e) {

            System.out.println(
                    "Report Error: "
                    + e.getMessage());
        }
    }
}