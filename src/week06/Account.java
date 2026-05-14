package week06;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance;
    private List<String> history;

    public Account() {
        this.balance = 0;
        this.history = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public List<String> getHistory() {
        return history;
    }

    public boolean deposit(int amount) {
        if (amount < 0) return false;
        balance += amount;
        history.add(String.format("+%d", amount));
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount < 0) return false;
        if (balance < amount) return false;
        balance -= amount;
        history.add(String.format("-%d", amount));
        return true;
    }
}
