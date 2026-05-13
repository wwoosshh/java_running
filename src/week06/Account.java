package week06;

/**
 * ATM에서 사용할 계좌 클래스.
 *
 * 학습 포인트:
 *  - 클래스는 "상태(필드) + 행동(메서드)"의 묶음입니다.
 *  - private 필드 + public 메서드 = 캡슐화
 *  - 잔액(balance)이라는 상태는 deposit()/withdraw()라는 행동을 통해서만 바뀝니다.
 *  - 외부(AtmMain)에서 balance를 직접 += 하지 못하게 막는 것이 캡슐화의 핵심.
 *
 * 구현 순서 추천 (위에서 아래로):
 *  1) 필드 선언
 *  2) 생성자
 *  3) getBalance()
 *  4) deposit()
 *  5) withdraw()  ← 실패 케이스가 있어서 boolean 반환
 */
public class Account {

    // ────────────────────────────────────────────
    // TODO 1) 잔액 필드를 선언하세요.
    //   - 접근 제어자: private
    //   - 타입: int
    //   - 이름: balance
    //
    //   예: private int balance;
    // ────────────────────────────────────────────


    /**
     * 새 계좌를 만듭니다. 잔액은 0원으로 시작합니다.
     *
     * TODO 2) 생성자 본문에서 balance를 0으로 초기화하세요.
     *   힌트: this.balance = 0;
     *   (사실 int 필드는 선언만 해도 자동으로 0이지만, 명시적으로 적는 습관을 들이면 좋습니다.)
     */
    public Account() {
        // TODO 2)
    }

    /**
     * 현재 잔액을 반환합니다.
     *
     * TODO 3) balance를 그대로 반환하세요.
     *   힌트: return balance;
     */
    public int getBalance() {
        // TODO 3)
        return 0;
    }

    /**
     * 입금. 잔액에 amount만큼 더합니다.
     *
     * @param amount 입금할 금액 (양수라고 가정)
     *
     * TODO 4) balance에 amount를 더하세요.
     *   힌트: balance += amount;
     *   (this.balance = this.balance + amount; 와 같은 뜻입니다.)
     */
    public void deposit(int amount) {
        // TODO 4)
    }

    /**
     * 출금. 잔액이 부족하면 출금하지 않고 false를 반환합니다.
     *
     * @param amount 출금할 금액
     * @return 출금 성공 여부 (성공: true, 잔액 부족: false)
     *
     * TODO 5) 아래 순서대로 구현하세요.
     *   ① 만약 balance가 amount보다 작으면 → return false; (즉시 종료)
     *   ② 그렇지 않으면 balance에서 amount를 빼고 → return true;
     *
     *   힌트:
     *     if (balance < amount) return false;
     *     balance -= amount;
     *     return true;
     *
     * 왜 boolean을 반환할까?
     *   호출하는 쪽(AtmMain)이 성공/실패에 따라 다른 메시지를 출력하게 하려고.
     *   (예외 throw는 더 나중에 배웁니다. 지금은 boolean 반환으로 충분합니다.)
     */
    public boolean withdraw(int amount) {
        // TODO 5)
        return false;
    }
}
