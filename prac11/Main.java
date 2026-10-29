
public class Main {
    public static void main(String[] args) {
        try {
            Student[] students = {
                new Student(1, "Amit", "amit123"),
                new Student(2, "Neha", "neha456"),
                new Student(3, "Rahul", "rahul789")
            };

            StudentFile.saveStudents(students);

            Student[] loadedStudents = StudentFile.loadStudents();

            System.out.println("\nLoaded student details:");
            for (Student student : loadedStudents) {
                student.display();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
