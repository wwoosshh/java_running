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

    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public boolean isBorrowed(){return isBorrowed;}

    public void borrow(){
        isBorrowed = true;
    }

    public void returnBook(){
        isBorrowed = false;
    }

    @Override
    public String toString(){
        return String.format("[%d] %s / %s (%s)", id, title, author, isBorrowed ? "대출중" : "대출가능");
    }
}
