package week05;

import java.util.ArrayList;
import java.util.List;

/**
 * 책들의 컬렉션을 관리하는 비즈니스 로직 클래스.
 *
 * 학습 포인트:
 *  - 이 클래스는 Scanner와 System.out을 모릅니다. (입출력 모름)
 *  - 결과를 "반환"만 합니다. 화면에 어떻게 표시할지는 LibraryMain이 결정합니다.
 *  - 이 분리 덕분에 나중에 콘솔이 아닌 웹/GUI로 바꿔도 이 클래스는 한 줄도 안 바뀝니다.
 *
 * 향후 확장 포인트:
 *  - 2단계: books를 파일에서 읽고/쓰는 로직 추가 (이 클래스의 메서드만 수정)
 *  - 3단계: 이 클래스를 BookRepository + LibraryService로 분리
 */
public class Library {

    // TODO: 필드 2개 선언
    //   - private ArrayList<Book> books : 책들을 담는 리스트
    //   - private int nextId            : 다음에 등록될 책의 id (1부터 시작)


    // TODO: 생성자
    //   public Library() { ... }
    //   - books를 새 ArrayList로 초기화
    //   - nextId를 1로 초기화


    /**
     * 책 등록.
     * - 새 Book 객체를 만들어 books에 추가
     * - id는 nextId를 사용하고, 사용 후 nextId를 1 증가
     */
    public void register(String title, String author) {
        // TODO: 구현
    }

    /**
     * 전체 책 목록 반환.
     * - books 리스트를 그대로 반환하면 됩니다.
     * - 반환 타입이 List<Book>인 이유: 호출자가 ArrayList 구현 세부사항을 몰라도 되도록.
     */
    public List<Book> findAll() {
        // TODO: 구현
        return null;
    }

    /**
     * 제목에 keyword를 포함하는 책들을 검색.
     * - books를 순회하면서 book.getTitle().contains(keyword)인 책만 모은다.
     * - 결과를 새 ArrayList에 담아 반환.
     * - 일치하는 책이 없으면 빈 리스트를 반환 (null 반환 금지!).
     */
    public List<Book> searchByTitle(String keyword) {
        // TODO: 구현
        return null;
    }

    /**
     * 책 대출.
     *
     * 성공 조건: id에 해당하는 책이 존재하고, 아직 대출중이 아님.
     *
     * @return 대출 성공이면 true, 실패(책 없음 OR 이미 대출중)면 false
     *
     * 구현 힌트:
     *   1. books를 순회하면서 id가 일치하는 Book을 찾는다
     *   2. 못 찾으면 return false
     *   3. 찾았는데 이미 isBorrowed()이면 return false
     *   4. 그 외에는 book.borrow() 호출 후 return true
     */
    public boolean borrow(int id) {
        // TODO: 구현
        return false;
    }

    /**
     * 책 반납.
     *
     * 성공 조건: id에 해당하는 책이 존재하고, 현재 대출중임.
     *
     * @return 반납 성공이면 true, 실패(책 없음 OR 이미 반납된 상태)면 false
     */
    public boolean returnBook(int id) {
        // TODO: 구현
        return false;
    }
}
