package week07;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Account {

    private int accountNumber;
    private String ownerName;
    private int balance;
    private List<String> history;

    private static final int MAX_BALANCE = 1_000_000_000;
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Account(int accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
        this.history = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public boolean deposit(int amount) {
        if (amount <= 0) return false; //음수 입금
        if (balance + amount > MAX_BALANCE) return false; //계좌 한도를 넘게 입금할때
        balance += amount;
        history.add(LocalDateTime.now().format(TIME_FORMAT) + " +" + amount + "원");
        return true;
    }

    public int withdraw(int amount) {
        if (amount <= 0) return 1; //음수를 출금하는 경우
        if (balance < amount) return 2; //잔액이 부족한 경우

        balance -= amount;
        history.add(LocalDateTime.now().format(TIME_FORMAT) + " -" + amount + "원");
        return 0;
    }


    @Override
    public String toString() {
        return String.format("[%d] %s - 잔액: %d원", accountNumber, ownerName, balance);
    }
}
