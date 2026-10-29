package Practical_7;

public class Driver3 {

    public static void main(String[] args) {

        String[] headers = {
                "student_name",
                "student_city",
                "student_age"
        };

        String[] data = {
                "Riya",
                "Ahmedabad",
                "20"
        };

        Student student =
                new Student();

        ColumnMapper.populate(
                student,
                headers,
                data);

        System.out.println(student);
    }
}
