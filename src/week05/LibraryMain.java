package week05;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자와 대화하는 입출력 클래스. 프로그램의 진입점.
 * <p>
 * 학습 포인트:
 * - Scanner와 System.out은 오직 이 클래스에만 등장합니다.
 * - 이 클래스는 Library에게 "일을 시키고", 결과를 화면에 표시할 뿐입니다.
 * - 책의 내부 필드(isBorrowed 등)에는 직접 접근하지 않고, Book이 제공하는 메서드만 씁니다.
 * <p>
 * 이 패턴이 백엔드 사고방식의 시작입니다:
 * 사용자 입력 처리 (이 클래스) ←→ 비즈니스 로직 (Library) ←→ 데이터 (Book)
 * 장차 Spring에서는 각각 Controller / Service / Entity가 됩니다.
 */
public class LibraryMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            printMenu();
            String input = sc.next();
            switch (input) {
                case "1" -> handleRegister(sc, library);
                case "2" -> handleList(library);
                case "3" -> handleSearch(sc, library);
                case "4" -> handleBorrow(sc, library);
                case "5" -> handleReturn(sc, library);
                case "0" -> {
                    System.out.println("종료합니다.");
                    sc.close();
                    return;
                }
                default -> System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
            System.out.println("────────────");
        }
    }

    private static void printMenu() {
        System.out.println("====== 도서관 시스템 ======");
        System.out.println("1. 책 등록");
        System.out.println("2. 전체 목록 보기");
        System.out.println("3. 제목으로 검색");
        System.out.println("4. 대출");
        System.out.println("5. 반납");
        System.out.println("0. 종료");
        System.out.print("입력: ");
    }

    /**
     * 책 등록 화면.
     * - Scanner로 제목, 저자를 입력받고 library.register() 호출
     * - 등록 완료 메시지 출력
     */
    private static void handleRegister(Scanner sc, Library library) {
        System.out.println("====== 책 등록 화면 ======");
        sc.nextLine();
        System.out.print("책 제목을 입력해주세요: ");
        String title = sc.nextLine();
        System.out.print("책 저자를 입력해주세요: ");
        String author = sc.nextLine();
        library.register(title, author);
        System.out.println(title + " | " + author + " 가 등록되었습니다.");
        // 힌트: sc.next()는 공백으로 끊겨서 "자바의 정석" 같은 제목 입력이 어렵습니다.
        //       sc.nextLine()을 쓰되, 직전의 sc.next() 뒤에 남은 줄바꿈을 sc.nextLine()으로 한 번 비우는 패턴이 일반적입니다.
    }

    /**
     * 전체 목록 화면.
     * - library.findAll()로 받은 List<Book>을 한 줄씩 출력
     * - 비어있으면 "등록된 책이 없습니다." 출력
     */
    private static void handleList(Library library) {
        List<Book> list = library.findAll();
        if (list.isEmpty()) {
            System.out.println("등록된 책이 없습니다.");
            return;       // 뒤 루프로 안 가고 함수 종료
        }
        for (Book book : list) {
            System.out.println(book);
        }
        // 힌트: for (Book book : list) { System.out.println(book); }
        //       Book에 toString()이 잘 구현되어 있다면 이대로 동작합니다.
    }

    /**
     * 검색 화면.
     * - 키워드 입력받고 library.searchByTitle() 호출
     * - 결과가 비어있으면 "검색 결과가 없습니다." 출력
     * - 아니면 한 줄씩 출력
     */
    private static void handleSearch(Scanner sc, Library library) {
        System.out.println("====== 제목으로 검색 ======");
        sc.nextLine();
        System.out.print("검색할 키워드를 입력하세요: ");
        String keyword = sc.nextLine();
        List<Book> result = library.searchByTitle(keyword);
        if (result.isEmpty()) {
            System.out.println("검색결과가 없습니다.");
            return;
        }
        for (Book book : result) {
            System.out.println(book);
        }
    }

    /**
     * 대출 화면.
     * - 책 id 입력받기 (숫자)
     * - library.borrow(id)의 결과(boolean)에 따라 메시지 출력
     * true  → "대출 완료"
     * false → "대출 실패: 책이 없거나 이미 대출중입니다."
     * <p>
     * 입력 검증 힌트:
     * try {
     * int id = Integer.parseInt(sc.next());
     * ...
     * } catch (NumberFormatException e) {
     * System.out.println("숫자를 입력하세요.");
     * }
     */
    private static void handleBorrow(Scanner sc, Library library) {
        System.out.println("====== 대출 화면 ======");
        System.out.print("대출할 책의 id를 입력하세요: ");
        try {
            int id = Integer.parseInt(sc.next());
            if (library.borrow(id)) {
                System.out.println("대출 완료");
            } else {
                System.out.println("대출 실패: 책이 없거나 이미 대출중입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
        }
    }

    /**
     * 반납 화면.
     * - 책 id 입력받기
     * - library.returnBook(id)의 결과에 따라 메시지 출력
     * true  → "반납 완료"
     * false → "반납 실패: 책이 없거나 이미 반납된 상태입니다."
     */
    private static void handleReturn(Scanner sc, Library library) {
        System.out.println("====== 반납 화면 ======");
        System.out.print("반납할 책의 id를 입력하세요: ");
        try {
            int id = Integer.parseInt(sc.next());
            if (library.returnBook(id)) {
                System.out.println("반납 완료");
            } else {
                System.out.println("반납 실패: 책이 없거나 이미 반납되었습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
        }
    }
}
