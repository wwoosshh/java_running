package week02;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dan;
        do {
            System.out.print("몇 단? ");
            dan = sc.nextInt();
            if (dan < 2 || dan > 9) {
                System.out.println("2~9 사이의 숫자를 입력해주세요.");
            }
        } while (dan < 2 || dan > 9);

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d x %d = %d%n", dan, i, dan * i);
        }
        sc.close();
    }
}
