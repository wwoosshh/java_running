package week03;

public class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);   // 부모 생성자 호출 (필수!)
    }

    @Override
    void makeSound() {
        System.out.println(name + ": 짹짹");
    }

    void fetch() {
        System.out.println(name + "이/가 공을 가져온다!");
    }
}