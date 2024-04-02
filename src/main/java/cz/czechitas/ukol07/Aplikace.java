package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {
    public static void main(String[] args) {
        KnihaSluzba knihaSluzba = new KnihaSluzba();
        List<Book> bookList = knihaSluzba.getBookList();
        System.out.println("Počet načtených knih: " + bookList.size());

        List<Book> bookListAuthor = knihaSluzba.getBooklistByTitleOfPublication("Karel Čapek");
        System.out.println("Počet načtených knih od autora Karel Čapek: " + bookListAuthor.size());

        List<Book> booklistPublication = knihaSluzba.getBooklistByTitleOfPublication(1845);
        System.out.println("Počet načtených knih z roku 1920: " + booklistPublication.size());

        for (Book book : booklistPublication) {
            System.out.println(book.getAuthor() + " " + book.getTitle() + " " + book.getYearOfPublication());
        }
    }
}
