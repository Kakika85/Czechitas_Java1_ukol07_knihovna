package cz.czechitas.ukol07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KnihaSluzbaTest {

    KnihaSluzba knihaSluzba;

    @BeforeAll
    void prepareTest(){
        knihaSluzba = new KnihaSluzba();
    }

    @Test
    void getBookList() {
        List<Book> bookList = knihaSluzba.getBookList();

        Assertions.assertEquals(14, bookList.size());
    }

    @Test
    void getBooklistByAuthor() {
        String author = "Ray Bradbury";

        List<Book> booklistByAuthor = knihaSluzba.getBooklistByTitleOfPublication(author);

        Assertions.assertEquals(1,booklistByAuthor.size());
        Assertions.assertEquals(author, booklistByAuthor.get(0).getAuthor());
    }

    @Test
    void getBooklistByAnyAuthor() {
        String author = "Pepíno";

        List<Book> booklistByAuthor = knihaSluzba.getBooklistByTitleOfPublication(author);

        Assertions.assertEquals(0,booklistByAuthor.size());
    }

    @Test
    void getBooklistByMoreAuthor() {
        String author = "Josef Čapek";

        List<Book> booklistByAuthor = knihaSluzba.getBooklistByTitleOfPublication(author);

        Assertions.assertEquals(3,booklistByAuthor.size());
        Assertions.assertEquals(author, booklistByAuthor.get(0).getAuthor());
        Assertions.assertEquals(author, booklistByAuthor.get(1).getAuthor());
        Assertions.assertEquals(author, booklistByAuthor.get(2).getAuthor());
    }

    @Test
    void getBooklistByTitleOfPublication() {
       int year = 1950;

        List<Book> booklistByTitleOfPublication = knihaSluzba.getBooklistByTitleOfPublication(year);

        Assertions.assertEquals(1,booklistByTitleOfPublication.size());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(0).getAuthor());
    }

    @Test
    void getBooklistByAnyTitleOfPublication() {
        int year = 856;

        List<Book> booklistByTitleOfPublication = knihaSluzba.getBooklistByTitleOfPublication(year);

        Assertions.assertEquals(0,booklistByTitleOfPublication.size());
    }

    @Test
    void getBooklistByMoreTitleOfPublication() {
        int year = 1856;

        List<Book> booklistByTitleOfPublication = knihaSluzba.getBooklistByTitleOfPublication(year);

        Assertions.assertEquals(3,booklistByTitleOfPublication.size());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(0).getAuthor());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(1).getAuthor());
        Assertions.assertEquals(year, booklistByTitleOfPublication.get(2).getAuthor());
    }
}