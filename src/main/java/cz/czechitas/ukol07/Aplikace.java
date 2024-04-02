package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {
    public static void main(String[] args) {
        KnihaSluzba knihaSluzba = new KnihaSluzba();
        List<Book> bookList1 = knihaSluzba.getBookList();
        System.out.println("Počet načtených knih: " + bookList1.size());
    }


}
