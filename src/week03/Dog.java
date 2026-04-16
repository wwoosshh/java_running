package week03;

public class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);   // 부모 생성자 호출 (필수!)
    }

    @Override
    void makeSound() {
        System.out.println(name + ": 멍멍!");
    }

    void fetch() {
        System.out.println(name + "이/가 공을 가져온다!");
    }
}