package week07;

import java.util.List;
import java.util.Scanner;

/**
 * 미니 은행 시스템 진입점.
 *
 * 구조는 Week 6 AtmMain과 거의 같습니다.
 *   - while(true) + printMenu + sc.next() + try-catch(NumberFormatException)
 *   - 각 메뉴는 별도 handleXxx 메서드로 분리
 *
 * 다른 점:
 *   - Account 직접 호출이 아니라 Bank를 통해서 (계좌번호로 먼저 검색)
 *   - 거의 모든 핸들러가 "계좌번호 입력 → findByNumber → null 체크 → 동작" 흐름
 *
 * 학습 포인트:
 *  - null 체크 패턴 — findByNumber()의 결과가 null일 수 있다
 *  - 이중 검증의 frontend 측 — handler에서 음수 거부, Account에서도 거부
 *  - 한 화면 안에서 여러 입력을 받는 흐름 (송금: 출발/도착/금액)
 */
public class BankMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            printMenu();
            String input = sc.next();

            try {
                switch (Integer.parseInt(input)) {
                    case 1 -> handleOpen(sc, bank);
                    case 2 -> handleDeposit(sc, bank);
                    case 3 -> handleWithdraw(sc, bank);
                    case 4 -> handleTransfer(sc, bank);
                    case 5 -> handleInquiry(sc, bank);
                    case 6 -> handleList(bank);
                    case 0 -> {
                        System.out.println("은행 시스템을 종료합니다.");
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
        System.out.println("===== 미니 은행 =====");
        System.out.println("1. 계좌 개설");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 송금");
        System.out.println("5. 잔액 / 거래 내역 조회");
        System.out.println("6. 전체 계좌 목록");
        System.out.println("0. 종료");
        System.out.print("입력: ");
    }

    /**
     * 1. 계좌 개설.
     *
     * 동작:
     *   1) "예금주 이름: " 입력 (sc.next())
     *   2) bank.openAccount(name) 호출
     *   3) "1번 계좌 개설 완료. (예금주: 김지훈, 잔액: 0원)" 출력
     *
     * TODO 1)
     *   힌트:
     *     System.out.print("예금주 이름: ");
     *     String name = sc.next();
     *     Account account = bank.openAccount(name);
     *     System.out.println(account.getAccountNumber() + "번 계좌 개설 완료. "
     *         + "(예금주: " + account.getOwnerName() + ", 잔액: " + account.getBalance() + "원)");
     */
    private static void handleOpen(Scanner sc, Bank bank) {
        // TODO 1)
    }

    /**
     * 2. 입금.
     *
     * 동작:
     *   1) "계좌번호: " 입력 → parseInt
     *   2) bank.findByNumber()로 계좌 찾기
     *   3) null이면 "계좌번호 X번을 찾을 수 없습니다." 출력 후 return
     *   4) "입금할 금액: " 입력 → parseInt
     *   5) 음수면 거부 메시지 + return
     *   6) account.deposit() 호출 → 결과에 따라 메시지
     *
     * TODO 2)
     *   주의: parseInt 두 번 → try-catch 한 블록으로 통째로 묶기 (Week 6 패턴)
     *
     *   골격:
     *     try {
     *         System.out.print("계좌번호: ");
     *         int number = Integer.parseInt(sc.next());
     *         Account account = bank.findByNumber(number);
     *         if (account == null) {
     *             System.out.println("계좌번호 " + number + "번을 찾을 수 없습니다.");
     *             return;
     *         }
     *         System.out.print("입금할 금액: ");
     *         int amount = Integer.parseInt(sc.next());
     *         if (amount < 0) {
     *             System.out.println("음수를 입금할 수 없습니다.");
     *             return;
     *         }
     *         account.deposit(amount);
     *         System.out.println(number + "번 계좌에 " + amount
     *             + "원 입금 완료. 현재 잔액: " + account.getBalance() + "원");
     *     } catch (NumberFormatException e) {
     *         System.out.println("숫자만 입력하세요.");
     *     }
     */
    private static void handleDeposit(Scanner sc, Bank bank) {
        // TODO 2)
    }

    /**
     * 3. 출금.
     * handleDeposit과 거의 같은 패턴. account.withdraw()의 boolean 결과로 분기.
     *
     * 메시지:
     *   성공 → "X번 계좌에서 Y원 출금 완료. 현재 잔액: Z원"
     *   실패(잔액 부족) → "잔액 부족. 현재 잔액: Z원"
     *
     * TODO 3)
     */
    private static void handleWithdraw(Scanner sc, Bank bank) {
        // TODO 3)
    }

    /**
     * 4. 송금.
     *
     * 동작:
     *   1) "출발 계좌번호: " 입력
     *   2) "도착 계좌번호: " 입력
     *   3) "송금할 금액: " 입력
     *   4) 음수 거부 (frontend 검증)
     *   5) bank.transfer() 호출 → boolean 결과에 따라 메시지
     *
     * TODO 4)
     *   힌트: transfer가 false를 반환하는 원인이 여러 가지(계좌 없음/잔액 부족/같은 계좌/음수)이지만,
     *         지금 단계에서는 일단 "송금 실패." 한 줄로 통일해도 OK.
     *         (도전: 원인별 다른 메시지를 주려면 Bank.transfer가 enum이나 예외를 반환해야 함)
     *
     *   성공 메시지: "송금 완료. 1번 → 2번, 3000원"
     */
    private static void handleTransfer(Scanner sc, Bank bank) {
        // TODO 4)
    }

    /**
     * 5. 잔액 / 거래 내역 조회.
     *
     * 동작:
     *   1) 계좌번호 입력
     *   2) findByNumber → null이면 안내 후 return
     *   3) account.toString()으로 헤더 출력
     *   4) "===== 거래 내역 =====" 출력
     *   5) account.getHistory()를 for-each로 한 줄씩 출력
     *
     * TODO 5)
     *   주의: 내역이 비어있으면 "(거래 내역 없음)" 한 줄 출력하는 게 사용자에게 친절.
     */
    private static void handleInquiry(Scanner sc, Bank bank) {
        // TODO 5)
    }

    /**
     * 6. 전체 계좌 목록.
     *
     * 동작:
     *   - bank.findAll()로 받은 리스트를 한 줄씩 출력
     *   - 비어있으면 "개설된 계좌가 없습니다." 출력
     *
     * TODO 6)
     *   힌트:
     *     List<Account> list = bank.findAll();
     *     if (list.isEmpty()) { ... return; }
     *     for (Account a : list) System.out.println(a);
     */
    private static void handleList(Bank bank) {
        // TODO 6)
    }

    // ──────────────────────────────────────────────
    //  도전 과제 (모두 선택)
    // ──────────────────────────────────────────────
    // A. 계좌 삭제 (메뉴 7번)
    //    - 잔액이 0원인 계좌만 삭제 허용
    //    - Bank.closeAccount(int number) 메서드 추가
    //    - List.remove() 활용
    //
    // B. 송금 자동 롤백
    //    - 현재 구조에선 transfer 중간에 실패할 일이 없지만,
    //      "만약 deposit이 던지는 예외가 추가된다면?"을 가정하고 보상 트랜잭션 구현
    //    - try { withdraw; deposit; } catch { withdraw 한 만큼 다시 입금 }
    //
    // C. 이름으로 계좌 검색 (동명이인 가능)
    //    - Bank.findByName(String name)이 List<Account> 반환
    //    - 메뉴 추가
    //
    // D. 거래 내역에 시각 포함
    //    - history.add() 시 LocalDateTime.now() + 금액 함께 저장
    //    - 예: "2026-05-20 14:30  +10000"
    //
    // E. 송금 수수료 1% 차감
    //    - from에서는 amount + 수수료, to에는 amount만 입금
    //    - 정수 산술 주의: amount * 1 / 100 등
}
