package week03;

public class Student {
    private String name;
    private int age;
    private String major;
    private double gpa;

    String getGrade() {
        if (gpa >= 4) return "A";
        if (gpa >= 3) return "B";
        if (gpa >= 2) return "C";
        return "F";

    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("잘못된 나이: " + age);
            return;    // 무시
        }
        this.age = age;
    }
    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.5) {
            System.out.println("잘못된 GPA: " + gpa);
            return;
        }
        this.gpa = gpa;
    }
    public Student(String name, int age, String major, double gpa){
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
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
