package Practical_11.Practical_11B;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class StatePersister {

    public static void save(Account[] accounts,
                            Path file) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             Files.newOutputStream(file))) {

            out.writeObject(accounts);

            System.out.println(
                    "Accounts saved successfully");

        }
        catch (Exception e) {

            System.out.println(
                    "Save Error: " + e.getMessage());
        }
    }

    public static Account[] load(Path file) {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             Files.newInputStream(file))) {

            return (Account[]) in.readObject();

        }
        catch (Exception e) {

            System.out.println(
                    "Load Error: " + e.getMessage());

            return new Account[0];
        }
    }
}