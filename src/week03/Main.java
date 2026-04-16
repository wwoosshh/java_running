package week03;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("김철수", 20, "컴공", 4.0);
        Student s2 = new Student("김영희", 17,"방송", 2.5);
        Student weird = new Student(null, -100, null, 999);

        weird.introduce();
        System.out.println(weird.getGrade());

        s1.introduce();
        s2.introduce();

        System.out.println(s1.getName() + " 성인? " + s1.isAdult());
        System.out.println(s2.getName() + " 성인? " + s2.isAdult());

        s1.haveBirthday();   // s1만 생일
        s1.introduce();      // 19살
        s2.introduce();      // 여전히 22살 (독립 확인)
    }
}