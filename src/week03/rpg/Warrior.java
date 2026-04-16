package week03.rpg;

public class Warrior extends Character {
    Warrior(String name) {
        super(name, 150, 20, 150);
    }

    @Override
    void attack(Character target) {
        System.out.println(name + "이/가 칼로 " + target.name + "을/를 강하게 벤다");
        target.takeDamage(power);
    }
}
