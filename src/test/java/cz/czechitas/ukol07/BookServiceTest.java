package cz.czechitas.ukol07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookServiceTest {

    BookService bookService;

    @BeforeAll
    void prepareTest() {
        bookService = new BookService();
    }

    @Test
    void getBookList() {
        List<Book> bookList = bookService.getBookList();

        Assertions.assertEquals(15, bookList.size());
    }

    @Test
    void getBooklistByAuthor_Single() {
        String author = "Ray Bradbury";

        List<Book> booklistByAuthor = bookService.getBooklistByTitleOfPublication(author);

        Assertions.assertEquals(1, booklistByAuthor.size());
        Assertions.assertEquals(author, booklistByAuthor.get(0).getAuthor());
    }

    @Test
    void getBooklistByAuthor_None() {
        String author = "Pepíno";

        List<Book> booklistByAuthor = bookService.getBooklistByTitleOfPublication(author);

        Assertions.assertEquals(0, booklistByAuthor.size());
    }

    @Test
    void getBooklistByAuthor_More() {
        String author = "Josef Čapek";

        List<Book> booklistByAuthor = bookService.getBooklistByTitleOfPublication(author);

        Assertions.assertEquals(3, booklistByAuthor.size());
        Assertions.assertEquals(author, booklistByAuthor.get(0).getAuthor());
        Assertions.assertEquals(author, booklistByAuthor.get(1).getAuthor());
        Assertions.assertEquals(author, booklistByAuthor.get(2).getAuthor());
    }

    @Test
    void getBooklistByTitleOfPublication_Single() {
        int year = 1950;

        List<Book> booklistByTitleOfPublication = bookService.getBooklistByTitleOfPublication(year);

        Assertions.assertEquals(1, booklistByTitleOfPublication.size());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(0).getYearOfPublication());
    }

    @Test
    void getBooklistByTitleOfPublication_None() {
        int year = 856;

        List<Book> booklistByTitleOfPublication = bookService.getBooklistByTitleOfPublication(year);

        Assertions.assertEquals(0, booklistByTitleOfPublication.size());
    }

    @Test
    void getBooklistByTitleOfPublication_More() {
        int year = 1856;

        List<Book> booklistByTitleOfPublication = bookService.getBooklistByTitleOfPublication(year);

        Assertions.assertEquals(2, booklistByTitleOfPublication.size());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(0).getYearOfPublication());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(1).getYearOfPublication());
    }

    @Test
    void getBooklistByAuthor_WrongAuthor() {
        IllegalArgumentException ex = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Book b = new Book();
                b.setAuthor("");
            },
            "Autor nesmí projít s empty stringem!"
        );
        Assertions.assertTrue(ex.getMessage().contains("Autor knihy je povinný údaj."));
    }

    @Test
    void getBooklistByAuthor_CorrectAuthor() {
        String author = "Tomáš Marný";
        String title = "ahoj";
        int yearPublication = 2020;

        Book b = new Book();
        b.setAuthor(author);
        b.setTitle(title);
        b.setYearOfPublication(yearPublication);

        Assertions.assertEquals(author, b.getAuthor());
        Assertions.assertEquals(title, b.getTitle());
        Assertions.assertEquals(yearPublication, b.getYearOfPublication());
    }

    @Test
    void getBooklistByTitle_WrongTitle() {
        IllegalArgumentException ex = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Book b = new Book();
                b.setTitle("");
            },
            "Název knihy nesmí projít s empty stringem!"
        );
        Assertions.assertTrue(ex.getMessage().contains("Název knihy je povinný údaj."));
    }

    @Test
    void getBooklistByTitleOfPublication_WrongYear() {
        IllegalArgumentException ex = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Book b = new Book();
                b.setYearOfPublication(890);
            },
            "Rok výtisku nesmí projít s nižší hodnotou než 1440!"
        );
        Assertions.assertTrue(ex.getMessage().contains("Rok výtisku knihy nemůže být starší než 1440"));
    }
}