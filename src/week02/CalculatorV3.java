package week02;

import java.util.Scanner;

import static week02.CalculatorV2.add;
import static week02.CalculatorV2.subtract;
import static week02.CalculatorV2.multiply;
import static week02.CalculatorV2.divide;

public class CalculatorV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String op;
        do {
            System.out.print("첫 번째 숫자: ");
            double a = sc.nextDouble();
            System.out.print("두 번째 숫자: ");
            double b = sc.nextDouble();
            sc.nextLine();
            System.out.print("연산자 (+, -, *, /, q로 종료): ");
            op = sc.nextLine();

            if (op.equals("q")){
                System.out.println("종료합니다.");
                break;
            }
            switch (op) {
                case "+" -> System.out.println("결과: " + add(a, b));
                case "-" -> System.out.println("결과: " + subtract(a, b));
                case "*" -> System.out.println("결과: " + multiply(a, b));
                case "/" -> {
                    if (b == 0) {
                        System.out.println("에러: 0으로 나눌수없습니다.");
                    } else {
                        System.out.println("결과: " + divide(a, b));
                    }
                }
                default -> System.out.println("올바른 연산자를 입력하세요.");
            }
            System.out.println("────────────");
        } while (true);
        sc.close();
    }
}
