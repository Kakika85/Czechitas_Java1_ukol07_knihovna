package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

public class KnihaSluzba {

    private List<Book> bookList;

    public KnihaSluzba() {
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            bookList = objectMapper.readValue(inputStream, new TypeReference<List<Book>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public static void main(String[] args) {
        KnihaSluzba knihaSluzba = new KnihaSluzba();
        List<Book> bookList1 = knihaSluzba.getBookList();
        System.out.println("Počet načtených knih: " + bookList1.size());
    }



   private final ObjectMapper objectMapper = JsonMapper.builder()
        .addModule(Jdk8Module())
        .build();

    private Module Jdk8Module() {
        return null;
    }
    private final Path cestaKDatum = Path.of("src/main/resources/cz/czechitas/ukol07/knihy.json");


}
