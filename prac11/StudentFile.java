
import java.io.*;

public class StudentFile {
    public static void saveStudents(Student[] students) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("students.dat")
        );

        out.writeObject(students);
        out.close();

        System.out.println("Students saved successfully.");
    }

    public static Student[] loadStudents()
            throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("students.dat")
        );

        Student[] students = (Student[]) in.readObject();
        in.close();

        return students;
    }
}
