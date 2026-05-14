package week06;

import java.util.List;
import java.util.Scanner;

public class AtmMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        while (true) {
            printMenu();
            String input = sc.next();

            try {
                switch (Integer.parseInt(input)) {
                    case 1 -> handleDeposit(sc, account);
                    case 2 -> handleWithdraw(sc, account);
                    case 3 -> handleBalance(account);
                    case 4 -> handleHistory(account);
                    case 0 -> {
                        System.out.println("ATM을 종료합니다.");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("올바른 메뉴 번호를 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
            System.out.println("--------------");
        }
    }

    private static void printMenu() {
        System.out.println("===== ATM =====");
        System.out.println("1. 입금");
        System.out.println("2. 출금");
        System.out.println("3. 잔액 조회");
        System.out.println("4. 거래 내역");
        System.out.println("0. 종료");
        System.out.print("입력: ");
    }

    private static void handleDeposit(Scanner sc, Account account) {
        System.out.print("입금할 금액: ");
        String input = sc.next();
        try {
            int amount = Integer.parseInt(input);

            // 1차 방어선 (UX) — 사용자에게 구체적 메시지
            if (amount < 0) {
                System.out.println("음수를 입금할 수 없습니다.");
                return;
            }

            // 2차 방어선 (데이터) — Account 내부 검증도 통과해야 진짜 입금됨
            if (!account.deposit(amount)) {
                System.out.println("입금 실패 (예상치 못한 오류).");
                return;
            }

            System.out.println(amount + "원 입금 완료. 현재 잔액: " +
                    account.getBalance() + "원");

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }

    private static void handleWithdraw(Scanner sc, Account account) {
        System.out.print("출금할 금액: ");
        String input = sc.next();
        try {
            int amount = Integer.parseInt(input);

            if (amount < 0) {
                System.out.println("음수를 출금할 수 없습니다.");
                return;
            }

            if (account.withdraw(amount)) {
                System.out.println(amount + "원 출금 완료. 현재 잔액: " +
                        account.getBalance() + "원");
            } else {
                System.out.println("잔액 부족. 현재 잔액: " +
                        account.getBalance() + "원");
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }

    private static void handleBalance(Account account) {
        System.out.println("현재 잔액: " + account.getBalance() + "원");
    }

    private static void handleHistory(Account account) {
        List<String> history = account.getHistory();
        if (history.isEmpty()) {
            System.out.println("거래 내역이 없습니다.");
            return;
        }
        System.out.println("===== 거래 내역 =====");
        for (String log : history) {
            System.out.println(log);
        }
    }
}
