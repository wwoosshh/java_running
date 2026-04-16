package week03.rpg;

public class Archer extends Character {
    Archer(String name) {
        super(name, 100, 15, 100);
    }

    @Override
    void attack(Character target) {
        System.out.println(name + "이/가 화살을 발사 하여" + target.name + "을 명중");
        target.takeDamage(power);
        target.takeDamage(power);
    }
}
