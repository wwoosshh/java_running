package week03;

public class Student {
    String name;
    int age;
    String major;
    double gpa;

    String getGrade() {
        if (gpa >= 4) return "A";
        if (gpa >= 3) return "B";
        if (gpa >= 2) return "C";
        return "F";

    }

    void introduce() {
        System.out.println("이름: " + name + ", 전공: " + major + ", 나이: " + age + ", 학점: " + getGrade());
    }

    void haveBirthday() {
        age++;
        System.out.println(name + "이/가 생일을 맞아 " + age + "살이 됨!");
    }

    boolean isAdult() {
        return age >= 19;
    }
}
