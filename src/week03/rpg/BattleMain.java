package week03.rpg;

public class BattleMain {
    public static void main(String[] args){
        Character warrior = new Warrior("전사");
        Character mage = new Mage("법사");
        Character archer = new Archer("궁수");
        Character healer = new Healer("힐러");

        System.out.println("=== 캐릭터 상태 ===");
        warrior.showStatus();
        mage.showStatus();
        archer.showStatus();
        healer.showStatus();

        System.out.println("\n=== 전투시작 ===");
        warrior.attack(mage);
        mage.attack(warrior);
        archer.attack(warrior);
        healer.attack(warrior);
        healer.attack(warrior);
        healer.attack(warrior);

        System.out.println("\n=== 전투 후 상태 ===");
        warrior.showStatus();
        mage.showStatus();
        archer.showStatus();
        healer.showStatus();
    }
}
