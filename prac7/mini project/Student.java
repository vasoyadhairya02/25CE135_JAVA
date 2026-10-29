package Practical_7;

public class Student {

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_city")
    private String city;

    @Column(name = "student_age")
    private String age;

    @Override
    public String toString() {

        return "Name: " + name +
                ", City: " + city +
                ", Age: " + age;
    }
}