package cz.czechitas.ukol07;

public class Book {
    private String author;
    private String title;
    private int yearOfPublication;

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Autor knihy je povinný údaj. Prosím vyplňte.");
        }
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Název knihy je povinný údaj. Prosím vyplňte.");
        }
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        if (yearOfPublication < 1440) {
            throw new IllegalArgumentException("Rok výtisku knihy nemůže být starší než 1440");
        }
        this.yearOfPublication = yearOfPublication;
    }
}
