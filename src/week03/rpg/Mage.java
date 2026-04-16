package week03.rpg;

public class Mage extends Character {
    Mage(String name) {
        super(name, 80, 35, 80);
    }

    @Override
    void attack(Character target) {
        System.out.println(name + "이/가 마법을 사용해 " + target.name + "을/를 명중");
        target.takeDamage(power);
    }

}
