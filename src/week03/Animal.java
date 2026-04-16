package week03;

public class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println(name + ": ...");
    }

    void introduce() {
        System.out.println(name + " (" + age + "살) - " +
                getClass().getSimpleName());
        // getClass().getSimpleName() → 실제 클래스 이름 ("Dog", "Cat"등)
    }
}