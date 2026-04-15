package week03;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "김철수";
        s1.age = 18;
        s1.major = "컴퓨터공학";
        s1.gpa = 4;

        Student s2 = new Student();
        s2.name = "이영희";
        s2.age = 22;
        s2.major = "경영학";
        s2.gpa = 1.5;

        Student weird = new Student();
        weird.name = null;
        weird.age = -100;
        weird.major = "";
        weird.gpa = 999;
        weird.introduce();
        System.out.println(weird.getGrade());

        s1.introduce();
        s2.introduce();

        System.out.println(s1.name + " 성인? " + s1.isAdult());
        System.out.println(s2.name + " 성인? " + s2.isAdult());

        s1.haveBirthday();   // s1만 생일
        s1.introduce();      // 19살
        s2.introduce();      // 여전히 22살 (독립 확인)
    }
}