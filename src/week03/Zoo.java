package week03;

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("바둑이", 3),
                new Cat("나비", 2),
                new Bird("짹이", 1),
                new Dog("초코", 5),
                new Cat("루나", 4)
        };

        System.out.println("=== 동물원 소개 ===");
        for (Animal a : animals) {
            a.introduce();
        }

        System.out.println("\n=== 모두 소리 내기 ===");
        for (Animal a : animals) {
            a.makeSound();      // ← 다형성! 같은 코드, 다른 동작
        }
    }
}