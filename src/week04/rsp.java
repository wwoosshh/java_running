package week04;
import java.util.Scanner;
import java.util.Random;

public class rsp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"가위", "바위", "보"};

        while (true) {
            System.out.print("가위,바위,보,종료 중에 입력: ");
            String userChoice = sc.next();

            if (userChoice.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            }

            if (!userChoice.equals("가위") &&
                    !userChoice.equals("바위") && !userChoice.equals("보")) {
                System.out.println("올바른 값을 입력하세요.");
                System.out.println("────────────");
                continue;
            }

            String comChoice =
                    choices[random.nextInt(choices.length)];
            System.out.println("컴퓨터결과: " + comChoice);
            System.out.println("결과: " + compute(userChoice,
                    comChoice));
            System.out.println("────────────");
        }
        sc.close();
    }

    public static String compute(String user, String com) {
        if (user.equals(com)) return "무승부";
        if ((user.equals("가위") && com.equals("보")) ||
                (user.equals("바위") && com.equals("가위")) ||
                (user.equals("보") && com.equals("바위"))) {
            return "승리";
        }
        return "패배";
    }
}