package week07;

import java.util.ArrayList;
import java.util.List;


public class Bank {

    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1;
    }

    public Account openAccount(String ownerName) {
        Account account = new Account(nextAccountNumber, ownerName);
        nextAccountNumber++;
        accounts.add(account);
        return account;
    }

    public Account findByNumber(int accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) return a;
        }
        return null;
    }
    public List<Account> findByName(String name) {
        List<Account> result = new ArrayList<>();
        for (Account a : accounts) {
            if (a.getOwnerName().contains(name)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }

    public int transfer(int fromNumber, int toNumber, int amount) {
        if (fromNumber == toNumber) return 1; //출발계좌와 도착계좌가 같은경우

        Account from = findByNumber(fromNumber);
        if (from == null) return 2; //출발계좌가 없는경우

        Account to = findByNumber(toNumber);
        if (to == null) return 3; //도착계좌가 없는경우

        int result = from.withdraw(amount);
        if (result == 1) return 4;  // 음수
        if (result == 2) return 5;  // 잔액 부족

        boolean depositOk = to.deposit(amount);
        if (!depositOk) {
            from.deposit(amount);     // ← 보상: 출금했던 돈 돌려놓기
            return 6;                  // ← 새 에러 코드
        }
        return 0;
    }

    public int closeAccount(int number) {
        Account account = findByNumber(number);   // ← 객체 받기
        if (account == null) {
            return 1;
        }
        if (account.getBalance() != 0) {
            return 2;
        }
        accounts.remove(account);
        return 0;
    }
}
