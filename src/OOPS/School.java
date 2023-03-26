package OOPS;

public class School {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "Rahul";

        Student s2 = new Student();
        s2.age = 11;
        s2.name = "Ram";

        s1.print();
        s2.print();
    }
}
