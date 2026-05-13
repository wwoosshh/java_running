package week06;

import java.util.Scanner;

/**
 * ATM 메인 프로그램.
 *
 * 동작:
 *  - 메뉴를 보여주고 → 번호 입력 → 해당 기능 실행 → 다시 메뉴
 *  - 사용자가 0을 누르면 종료
 *
 * 학습 포인트:
 *  - while + switch 메뉴 구조 (콘솔 프로그램의 가장 흔한 뼈대)
 *  - Scanner.nextInt() 로 정수 입력 받기
 *  - 메서드 분리: 메뉴 출력 / 입금 처리 / 출금 처리 / 잔액 조회를 각각 별도 메서드로
 *  - 클래스(Account)에게 일을 시키고 결과만 받기 — main은 "지휘자" 역할
 *
 * 실행 예시:
 *   ===== ATM =====
 *   1. 입금
 *   2. 출금
 *   3. 잔액 조회
 *   0. 종료
 *   입력: 1
 *   입금할 금액: 10000
 *   10000원 입금 완료. 현재 잔액: 10000원
 *   --------------
 *   ===== ATM =====
 *   ...
 *   입력: 2
 *   출금할 금액: 30000
 *   잔액 부족. 현재 잔액: 10000원
 *   --------------
 *   입력: 0
 *   ATM을 종료합니다.
 */
public class AtmMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();

        while (true) {
            printMenu();
            int input = sc.nextInt();

            // ────────────────────────────────────────────
            // TODO 1) switch (input) 으로 분기하세요.
            //   case 1 → handleDeposit(sc, account);
            //   case 2 → handleWithdraw(sc, account);
            //   case 3 → handleBalance(account);
            //   case 0 → "ATM을 종료합니다." 출력 + sc.close() + return;
            //   default → "올바른 메뉴 번호를 입력하세요." 출력
            //
            //   힌트:
            //     switch (input) {
            //         case 1 -> handleDeposit(sc, account);
            //         case 2 -> ...
            //         ...
            //         default -> System.out.println("올바른 메뉴 번호를 입력하세요.");
            //     }
            //
            //   주의: case 0에서는 sc.close() 와 return; 을 빼먹지 마세요.
            //          (sc.close() 없이 return 하면 Scanner 자원이 정리되지 않습니다.)
            // ────────────────────────────────────────────


            System.out.println("--------------");
        }
    }

    /**
     * 메뉴 화면을 출력합니다.
     *
     * TODO 2) 아래 5줄을 그대로 출력하세요.
     *   ===== ATM =====
     *   1. 입금
     *   2. 출금
     *   3. 잔액 조회
     *   0. 종료
     *   입력: (← 줄바꿈 없이 print)
     *
     *   힌트:
     *     System.out.println("===== ATM =====");
     *     System.out.println("1. 입금");
     *     ...
     *     System.out.print("입력: ");     // 마지막 줄만 print (줄바꿈 X)
     */
    private static void printMenu() {
        // TODO 2)
    }

    /**
     * 입금 처리.
     *  1) "입금할 금액: " 출력 (print, 줄바꿈 없음)
     *  2) Scanner로 금액(int) 입력 받기
     *  3) account.deposit(amount) 호출
     *  4) "X원 입금 완료. 현재 잔액: Y원" 출력
     *
     * TODO 3)
     *   힌트:
     *     System.out.print("입금할 금액: ");
     *     int amount = sc.nextInt();
     *     account.deposit(amount);
     *     System.out.println(amount + "원 입금 완료. 현재 잔액: " + account.getBalance() + "원");
     */
    private static void handleDeposit(Scanner sc, Account account) {
        // TODO 3)
    }

    /**
     * 출금 처리.
     *  1) "출금할 금액: " 출력 후 금액 입력
     *  2) account.withdraw(amount) 호출 → boolean 결과 받기
     *  3) 결과에 따라 분기:
     *      성공(true)  → "X원 출금 완료. 현재 잔액: Y원"
     *      실패(false) → "잔액 부족. 현재 잔액: Y원"
     *
     * TODO 4)
     *   힌트:
     *     boolean success = account.withdraw(amount);
     *     if (success) { ... } else { ... }
     */
    private static void handleWithdraw(Scanner sc, Account account) {
        // TODO 4)
    }

    /**
     * 잔액 조회.
     *  "현재 잔액: X원" 한 줄 출력.
     *
     * TODO 5)
     *   힌트:
     *     System.out.println("현재 잔액: " + account.getBalance() + "원");
     */
    private static void handleBalance(Account account) {
        // TODO 5)
    }

    // ──────────────────────────────────────────────
    //  도전 과제 (모두 선택, 막히면 패스해도 OK)
    // ──────────────────────────────────────────────
    // A. 음수 금액 거부
    //    - Account.deposit / withdraw 안에서 amount <= 0 이면 동작 X
    //    - withdraw는 false 반환, deposit은 어떻게 알릴지 직접 결정 (return 값을 boolean으로?)
    //
    // B. 잘못된 입력 방어
    //    - 사용자가 "abc"를 입력하면 sc.nextInt()에서 프로그램이 죽습니다 (InputMismatchException)
    //    - sc.next() 로 문자열을 받고 Integer.parseInt() + try-catch 로 감싸 보세요
    //
    // C. 거래 내역
    //    - 입출금할 때마다 "+10000", "-5000" 같은 문자열을 Account 안에 모아두기
    //    - 메뉴 "4. 거래 내역" 추가해서 출력
    //    - 자료구조: 배열(고정 크기) 또는 java.util.ArrayList<String> (둘 다 OK)
}
