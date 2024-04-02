package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class KnihaSluzba {
    private List<Book> bookList;

    public KnihaSluzba() {
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) { // "cz/czechitas/ukol07/knihy.json"
            ObjectMapper objectMapper = new ObjectMapper();
            bookList = objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }


}
