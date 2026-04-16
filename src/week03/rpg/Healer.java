package week03.rpg;

public class Healer extends Character {
    Healer(String name) {
        super(name, 90, 50, 90);
    }

    @Override
    void attack(Character target) {
        System.out.println(name + "이/가 " + target.name + "을 회복");
        target.takeHeal(power);
    }
}
