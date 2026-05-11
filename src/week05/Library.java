package week05;
import java.util.ArrayList;
import java.util.List;
public class Library {

    private List<Book> books;
    private int nextId = 1;

    public Library(){
        books = new ArrayList<Book>();
    }

    public void register(String title, String author) {
        Book book = new Book(nextId, title, author);
        nextId++;
        books.add(book);
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keyword)) result.add(book);
        }
        return result;
    }

    public boolean borrow(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) return false;
                book.borrow();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isBorrowed()) return false; //만약 대출중이지 않은데 반납을 시도할경우 false
                book.returnBook();
                return true;
            }
        }
        return false;
    }
}
