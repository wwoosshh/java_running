package week03.rpg;

public class Character {
    String name;
    int hp;
    int power;
    int fullhp;

    Character(String name, int hp, int power, int fullhp) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.fullhp = fullhp;
    }

    void attack(Character target) {
        System.out.println(name + "이/가 " + target.name + "을/를 공격(기본)");
        target.takeDamage(power);
    }

    void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(" ->" + name + "이/가 " + damage + "데미지! (남은 HP: " + hp + ")");
    }
    void takeHeal(int damage) {
        hp += damage;
        if (hp >= fullhp) hp = fullhp;
        System.out.println(" ->" + name + "이/가 " + damage + "회복! (남은 HP: " + hp + ")");
    }

    void showStatus() {
        System.out.println("[" + getClass().getSimpleName() + "]" + name + " - HP: " + hp + ", 공격력: " + power);
    }

    boolean isAlive() {
        return hp > 0;
    }
}
