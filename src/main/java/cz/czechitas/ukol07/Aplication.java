package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplication {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        List<Book> bookList = bookService.getBookList();
        System.out.println("Počet načtených knih: " + bookList.size());

        List<Book> bookListAuthor = bookService.getBooklistByTitleOfPublication("Karel Čapek");
        System.out.println("Počet načtených knih od autora Karel Čapek: " + bookListAuthor.size());

        for (Book book : bookListAuthor) {
            System.out.println(book.getAuthor() + " " + book.getTitle() + " " + book.getYearOfPublication());
        }

        List<Book> booklistPublication = bookService.getBooklistByTitleOfPublication(1845);
        System.out.println("Počet načtených knih z roku 1920: " + booklistPublication.size());

        for (Book book : booklistPublication) {
            System.out.println(book.getAuthor() + " " + book.getTitle() + " " + book.getYearOfPublication());
        }
    }
}
