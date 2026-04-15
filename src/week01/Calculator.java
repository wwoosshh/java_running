package week01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자: ");
        double a = sc.nextDouble();

        System.out.print("두 번째 숫자: ");
        double b = sc.nextDouble();

        sc.nextLine();
        System.out.print("연산자 (+,-,*,/): ");
        String op = sc.nextLine();

        if (op.equals("+")) {
            System.out.println("결과: " + (a + b));
        } else if (op.equals("-")) {
            System.out.println("결과: " + (a - b));
        } else if (op.equals("*")) {
            System.out.println("결과: " + (a * b));
        } else if (op.equals("/")) {
            if (b == 0) {
                System.out.println("에러: 0으로 나눌 수 없습니다.");
            } else {
                System.out.println("결과: " + (a / b));
            }
        } else {
            System.out.println("알 수 없는 연산자");
        }
    }
}
