package week07;

import java.util.ArrayList;
import java.util.List;

/**
 * 계좌 클래스.
 *
 * Week 6 Account에 비해 두 가지가 추가됐습니다:
 *   1) accountNumber — 어느 계좌인지 식별 (Bank가 발급해서 생성자로 넘겨줌)
 *   2) ownerName    — 예금주 이름
 *
 * 거래 내역(history)은 Week 6 도전 과제 C에서 만든 패턴 그대로입니다.
 *
 * 학습 포인트:
 *  - 객체에 "식별자(ID)"를 두면 컬렉션에서 찾을 수 있게 됩니다.
 *  - 검증은 Account 본인이 책임집니다 (handler가 또 검증하더라도 백엔드 방어선 유지).
 *  - 메시지 출력(System.out)은 절대 Account 안에서 하지 않습니다.
 *    Account는 "결과(boolean)"만 돌려주고, 메시지는 호출자(BankMain)가 결정합니다.
 */
public class Account {

    // ────────────────────────────────────────────
    // TODO 1) 필드 4개를 private으로 선언하세요.
    //   - int accountNumber
    //   - String ownerName
    //   - int balance
    //   - List<String> history
    // ────────────────────────────────────────────


    /**
     * 생성자. Bank가 호출하면서 계좌번호와 예금주 이름을 넘겨줍니다.
     * 초기 잔액은 0원, 거래 내역은 빈 리스트.
     *
     * TODO 2) 4개 필드를 모두 초기화하세요.
     *   힌트:
     *     this.accountNumber = accountNumber;
     *     this.ownerName = ownerName;
     *     this.balance = 0;
     *     this.history = new ArrayList<>();
     *
     *   주의: history를 절대 생성자 바깥에서 초기화하지 마세요.
     *         메서드 안에서 new ArrayList<>() 하면 매번 새로 만들어서 내역이 사라집니다.
     */
    public Account(int accountNumber, String ownerName) {
        // TODO 2)
    }

    // ────────────────────────────────────────────
    // TODO 3) getter 4개를 작성하세요.
    //   - getAccountNumber() : int
    //   - getOwnerName()     : String
    //   - getBalance()       : int
    //   - getHistory()       : List<String>
    //
    //   getHistory()는 그대로 history를 반환해도 OK입니다.
    //   (방어적 복사를 하고 싶다면: return new ArrayList<>(history);)
    // ────────────────────────────────────────────


    /**
     * 입금. 음수는 거부.
     * 성공 시 거래 내역에 "+amount" 추가.
     *
     * @return 성공: true, 거부: false
     *
     * TODO 4) 힌트:
     *   if (amount < 0) return false;
     *   balance += amount;
     *   history.add("+" + amount);   // 또는 String.format("+%d", amount)
     *   return true;
     */
    public boolean deposit(int amount) {
        // TODO 4)
        return false;
    }

    /**
     * 출금. 음수 또는 잔액 부족 시 거부.
     * 성공 시 거래 내역에 "-amount" 추가.
     *
     * @return 성공: true, 거부: false
     *
     * TODO 5) 힌트:
     *   if (amount < 0) return false;
     *   if (balance < amount) return false;
     *   balance -= amount;
     *   history.add("-" + amount);
     *   return true;
     */
    public boolean withdraw(int amount) {
        // TODO 5)
        return false;
    }

    /**
     * 전체 목록 화면 등에 사용할 표시 문자열.
     * 형식 예: "[1] 김지훈 — 잔액: 10000원"
     *
     * TODO 6) String.format("[%d] %s — 잔액: %d원", accountNumber, ownerName, balance);
     */
    @Override
    public String toString() {
        // TODO 6)
        return null;
    }
}
