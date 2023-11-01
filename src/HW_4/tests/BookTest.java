package HW_4.tests;
import HW_4.main.Book;
import HW_4.main.InMemoryBookRepository;
import HW_4.main.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class BookTest {
    List<Book> bookList;

    @BeforeEach
    void testinit() {
        bookList = Arrays.asList(
                new Book("1", "title1", "author1"),
                new Book("2", "title2", "author2"),
                new Book("3", "title3", "author3"),
                new Book("4", "title4", "author4"),
                new Book("5", "title5", "author5"),
                new Book("6", "title6", "author6"),
                new Book("7", "title7", "author7"),
                new Book("8", "title8", "author8"),
                new Book("9", "title9", "author9")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void testGetBookById(String id) {
        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);

        when(bookRepository.findById(id)).thenReturn(bookList.get(Integer.parseInt(id) - 1));

        BookService bookService = new BookService(bookRepository);

        assertEquals(String.format("Book{id='%1$s', title='title%1$s', author='author%1$s'}", id), bookService.findBookById(id).toString());
    }

    @Test
    void testFindAllBooks() {
        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);

        when(bookRepository.findAll()).thenReturn(bookList);

        BookService bookService = new BookService(bookRepository);

        assertEquals(bookList, bookService.findAllBooks());
    }
}