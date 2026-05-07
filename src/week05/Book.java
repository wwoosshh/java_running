package week05;

/**
 * 책 한 권의 정보를 담는 데이터 클래스.
 *
 * 학습 포인트:
 *  - private 필드 + public 메서드 = 캡슐화
 *  - 단순 setter 대신 borrow() / returnBook() 같은 의미 있는 행동 메서드를 제공
 *  - toString()을 오버라이드하면 System.out.println(book) 시 자동 호출됨
 *
 * 이 클래스는 Scanner나 ArrayList를 모릅니다. 오로지 자기 자신만 표현합니다.
 */
public class Book {

    // TODO: 필드 4개 선언 (전부 private)
    //   - int id            : 책의 고유번호
    //   - String title      : 제목
    //   - String author     : 저자
    //   - boolean isBorrowed: 대출중 여부 (true면 대출중, false면 서가에 있음)


    // TODO: 생성자 작성
    //   public Book(int id, String title, String author) { ... }
    //   - id, title, author는 매개변수로 받아 필드에 저장
    //   - isBorrowed는 자동으로 false로 초기화 (새 책은 대출중이 아님)


    // TODO: getter 메서드들
    //   public int getId()         { ... }
    //   public String getTitle()   { ... }
    //   public String getAuthor()  { ... }
    //   public boolean isBorrowed(){ ... }   // boolean은 관례상 is...로 시작


    // TODO: 행동 메서드 — borrow()
    //   public void borrow() { ... }
    //   - isBorrowed를 true로 변경
    //   - (1단계에서는 단순히 상태만 바꿉니다. 검증은 Library가 담당.)


    // TODO: 행동 메서드 — returnBook()
    //   public void returnBook() { ... }
    //   - isBorrowed를 false로 변경
    //   - 메서드명이 'return'이 아닌 이유: 'return'은 자바 예약어라서 메서드명으로 쓸 수 없음


    // TODO: toString() 오버라이드
    //   @Override
    //   public String toString() { ... }
    //   - 출력 형식 예시: "[1] 자바의 정석 / 남궁성 (대출가능)"
    //   - 대출중이면 "(대출중)", 아니면 "(대출가능)"
    //   - 힌트: String.format("[%d] %s / %s (%s)", id, title, author, isBorrowed ? "대출중" : "대출가능")
}
