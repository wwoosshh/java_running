package week07;

import java.util.List;
import java.util.Scanner;

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
                    case 7 -> handleSearch(sc, bank);
                    case 8 -> handleDelete(sc, bank); //관리자 기능으로 일반 사용자에게는 비공개
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
        System.out.println("7. 예금주 명 검색");
        System.out.println("0. 종료");
        System.out.print("입력: ");
    }

    private static void handleOpen(Scanner sc, Bank bank) {
        System.out.println("===== 계좌 개설 =====");
        System.out.print("예금주 이름: ");
        String name = sc.next();
        Account account = bank.openAccount(name);
        System.out.println(account.getAccountNumber() + "번 계좌 개설 완료." + "(예금주: " + account.getOwnerName() + ", 잔액: " + account.getBalance() + "원)");
    }

    private static void handleDeposit(Scanner sc, Bank bank) {
        System.out.println("===== 입금 =====");
        try {
            System.out.print("계좌번호: ");
            int number = Integer.parseInt(sc.next());
            Account account = bank.findByNumber(number);
            if (account == null) {
                System.out.println("계좌번호 " + number + "번을 찾을 수 없습니다.");
                return;
            }
            System.out.print("입금할 금액: ");
            int amount = Integer.parseInt(sc.next());
            if (amount <= 0) {                                       // < 0 → <= 0
                System.out.println("0원 또는 음수를 입금할 수 없습니다.");
                return;
            }
            if (!account.deposit(amount)) {                          // 반환값받기
                System.out.println("입금 실패: 계좌 한도(" + 1_000_000_000 + "원)를 초과합니다.");
                return;
            }
            System.out.println(number + "번 계좌에 " + amount + "원 입금 완료. 현재 잔액: " + account.getBalance() + "원");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }

    private static void handleWithdraw(Scanner sc, Bank bank) {
        System.out.println("===== 출금 =====");
        try {
            System.out.print("계좌번호: ");
            int number = Integer.parseInt(sc.next());
            Account account = bank.findByNumber(number);
            if (account == null) {
                System.out.println("계좌번호 " + number + "번을 찾을 수 없습니다.");
                return;
            }
            System.out.print("출금할 금액: ");
            int amount = Integer.parseInt(sc.next());
            if (amount <= 0) {
                System.out.println("음수 또는 0원을 출금할 수 없습니다.");
                return;
            }
            int result = account.withdraw(amount);
            if (result == 2) {
                System.out.println("계좌 잔액이 부족합니다.");
                return;
            }
            if (result != 0) {
                System.out.println("출금 처리 중 오류가 발생했습니다.");
                return;
            }
            System.out.println(number + "번 계좌에 " + amount + "원 출금 완료. 현재 잔액: " + account.getBalance() + "원");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }

    private static void handleTransfer(Scanner sc, Bank bank) {
        System.out.println("===== 송금 =====");
        try {
            System.out.print("출금 할 계좌번호: ");
            int fromAccount = Integer.parseInt(sc.next());
            System.out.print("송금 할 계좌번호: ");
            int toAccount = Integer.parseInt(sc.next());
            System.out.print("송금 할 금액: ");
            int amount = Integer.parseInt(sc.next());
            if (amount <= 0) {
                System.out.println("음수 또는 0원을 출금할 수 없습니다.");
                return;
            }
            switch (bank.transfer(fromAccount, toAccount, amount)) {
                case 1 -> System.out.println("출금계좌와 입금계좌가 동일할 수 없습니다.");
                case 2 -> System.out.println("출금계좌가 존재하지 않습니다.");
                case 3 -> System.out.println("입금계좌가 존재하지 않습니다.");
                case 4 -> System.out.println("0원을 송금할 수 없습니다.");
                case 5 -> System.out.println("출금계좌의 잔액이 부족합니다.");
                case 6 -> System.out.println("송금 실패: 입금 계좌가 한도를 초과합니다. 출금액은 자동 복원되었습니다.");
                case 0 -> System.out.println("송금 완료 " + fromAccount + " -> " + toAccount + " | " + amount + "원");
                default -> System.out.println("알수없는 에러");

            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }

    private static void handleInquiry(Scanner sc, Bank bank) {
        System.out.println("===== 잔액 / 거래 내역 조회 =====");
        try {
            System.out.print("조회 할 계좌번호 입력: ");
            int number = Integer.parseInt(sc.next());
            Account account = bank.findByNumber(number);

            if (account == null) {
                System.out.println("존재하지 않는 계좌번호입니다.");
                return;
            }
            System.out.println(account.toString());

            List<String> history = account.getHistory();

            if (history.isEmpty()) {
                System.out.println("거래 내역이 없습니다.");
                return;
            }
            System.out.println("===== 거래 내역 =====");
            for (String log : history) {
                System.out.println(log);
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }

    private static void handleList(Bank bank) {
        System.out.println("===== 전체 계좌 목록 =====");
        List<Account> allAccounts = bank.findAll();
        if (allAccounts.isEmpty()) {
            System.out.println("개설된 계좌가 없습니다.");
            return;
        }
        for (Account log : allAccounts) {
            System.out.println(log);
        }
    }

    private static void handleSearch(Scanner sc, Bank bank) {
        System.out.println("===== 이름으로 계좌 검색 =====");
        System.out.print("검색할 이름(일부 가능): ");
        String name = sc.next();

        List<Account> result = bank.findByName(name);
        if (result.isEmpty()) {
            System.out.println("일치하는 계좌가 없습니다.");
            return;
        }
        System.out.println("검색 결과 " + result.size() + "건:");
        for (Account a : result) {
            System.out.println(a);   // Account의 toString() 활용
        }
    }

    private static void handleDelete(Scanner sc, Bank bank) {
        System.out.println("===== 계좌 삭제 =====");
        System.out.println("!!주의 - 관리자만 삭제하여야 하며 잔액이 0원인 계좌만 삭제 가능합니다.!!");
        System.out.print("삭제할 계좌번호: ");
        String number = sc.next();
        try {
            int result = bank.closeAccount(Integer.parseInt(number));
            if (result == 1) {
                System.out.println("존재하지 않는 계좌번호 입니다.");
                return;
            }
            if (result == 2) {
                System.out.println("계좌 내에 잔액이 존재합니다.");
                return;
            }
            System.out.println("계좌가 삭제되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }
    }
}
