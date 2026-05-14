package week07;

import java.util.ArrayList;
import java.util.List;

/**
 * 여러 계좌를 관리하는 은행 서비스.
 *
 * Bank의 책임:
 *  - 계좌 개설 (Account를 만들고 ID 발급)
 *  - 계좌 검색 (계좌번호로 찾기)
 *  - 전체 목록 제공
 *  - 송금 (두 계좌에 걸친 작업의 조정자)
 *
 * Bank가 하지 않는 것:
 *  - Scanner 입력 → BankMain의 책임
 *  - System.out 출력 → BankMain의 책임
 *  - 잔액 변경 → Account 본인이 deposit/withdraw로 처리
 *
 * Week 5의 Library가 Book들을 관리한 방식과 같은 구조입니다.
 * 차이점: Library는 검색 결과로 "리스트"를 자주 반환했고,
 *         Bank는 검색 결과로 "단일 Account 또는 null"을 반환합니다.
 */
public class Bank {

    // ────────────────────────────────────────────
    // TODO 1) 필드 2개를 private으로 선언하세요.
    //   - List<Account> accounts
    //   - int nextAccountNumber       // 다음에 발급할 계좌번호
    // ────────────────────────────────────────────


    /**
     * TODO 2) 생성자에서 초기화하세요.
     *   - accounts = new ArrayList<>();
     *   - nextAccountNumber = 1;        // 첫 발급 번호
     */
    public Bank() {
        // TODO 2)
    }

    /**
     * 새 계좌 개설.
     * 자동으로 계좌번호를 발급하고, accounts 리스트에 추가.
     * 발급 후 nextAccountNumber를 1 증가시켜야 다음 계좌가 다른 번호를 받습니다.
     *
     * @return 생성된 Account (BankMain이 안내 메시지에 사용)
     *
     * TODO 3) 힌트 (Week 5 Library.register와 같은 패턴):
     *   Account account = new Account(nextAccountNumber, ownerName);
     *   nextAccountNumber++;
     *   accounts.add(account);
     *   return account;
     */
    public Account openAccount(String ownerName) {
        // TODO 3)
        return null;
    }

    /**
     * 계좌번호로 Account 찾기.
     *
     * @param accountNumber 찾을 계좌번호
     * @return 일치하는 Account, 없으면 null
     *
     * TODO 4) 힌트 (Week 5 Library.borrow 안의 검색 부분과 같은 패턴):
     *   for (Account a : accounts) {
     *       if (a.getAccountNumber() == accountNumber) return a;
     *   }
     *   return null;
     *
     * 왜 못 찾으면 null을 반환할까?
     *   호출자(BankMain)가 "없는 계좌입니다" 메시지를 출력할 수 있게 하기 위함.
     *   예외(throw)도 가능하지만, 신입자에겐 null 반환이 단순합니다.
     *   대신 호출자는 반드시 if (account == null) 체크를 해야 합니다.
     */
    public Account findByNumber(int accountNumber) {
        // TODO 4)
        return null;
    }

    /**
     * 모든 계좌를 반환. 원본 리스트 보호를 위해 새 리스트로 복사해서 반환.
     *
     * TODO 5) return new ArrayList<>(accounts);
     *
     * 왜 복사본을 돌려줄까?
     *   호출자가 받은 리스트에서 remove() 같은 변경을 해도 Bank 내부가 안 망가지게.
     *   (방어적 복사 — Week 5 Library.findAll에서 이미 봤습니다.)
     */
    public List<Account> findAll() {
        // TODO 5)
        return List.of();
    }

    /**
     * 송금. 출발 계좌에서 출금 → 도착 계좌로 입금.
     *
     * @return 둘 다 성공해야 true. 하나라도 실패하면 false (잔액은 그대로).
     *
     * TODO 6) 이 메서드가 이번 주차의 가장 어려운 부분입니다.
     *
     *  의사코드(먼저 종이에 적고 시작하세요):
     *    1) findByNumber(fromNumber)로 출발 계좌 찾기. null이면 return false.
     *    2) findByNumber(toNumber)로 도착 계좌 찾기. null이면 return false.
     *    3) 출발 == 도착 이면 return false. (자기 자신에게 송금 금지)
     *    4) from.withdraw(amount) 시도. false면 그대로 return false.
     *       (이때 잔액은 그대로 — withdraw가 알아서 막아줌)
     *    5) to.deposit(amount) 호출.
     *       (출금에서 amount가 양수임을 이미 보장했으니 deposit은 실패 안 함)
     *    6) return true.
     *
     *  생각해볼 거리 (지금 구현 안 해도 됨):
     *    - 출금은 성공했는데 입금이 실패한다면? (현재 설계에선 일어나지 않지만)
     *      → 도전 과제 B 참고: 보상 트랜잭션
     */
    public boolean transfer(int fromNumber, int toNumber, int amount) {
        // TODO 6)
        return false;
    }
}
