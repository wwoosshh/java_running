package week02;

import java.util.Scanner;

public class CalculatorV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자: ");
        double a = sc.nextDouble();
        System.out.print("두 번째 숫자: ");
        double b = sc.nextDouble();
        sc.nextLine();
        System.out.print("연산자 (+,-,*,/): ");
        String op = sc.nextLine();

        switch (op) {
            case "+" -> System.out.println("결과: " + add(a, b));
            case "-" -> System.out.println("결과: " + subtract(a, b));
            case "*" -> System.out.println("결과: " + multiply(a, b));
            case "/" -> {
                if (b == 0) {
                    System.out.println("에러: 0으로 나눌 수 없습니다.");
                } else {
                    System.out.println("결과: " + divide(a, b));
                }
            }
            default -> System.out.println("알 수 없는 연산자입니다.");
        }

        sc.close();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}