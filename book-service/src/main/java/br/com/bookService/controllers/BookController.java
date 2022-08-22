package br.com.bookService.controllers;

import br.com.bookService.models.Book;
import br.com.bookService.proxy.CambioProxy;
import br.com.bookService.repository.BookRepository;
import br.com.bookService.response.CambioResponse;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {
    private final Environment environment;
    private final BookRepository bookRepository;

    private final CambioProxy cambioProxy;

    public BookController(Environment environment, BookRepository bookRepository, CambioProxy cambioProxy) {
        this.environment = environment;
        this.bookRepository = bookRepository;
        this.cambioProxy = cambioProxy;
    }

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        var book = bookRepository.getReferenceById(id);

        if (book == null) {
            throw new RuntimeException("Book not found.");
        }

        var params = new HashMap<String, String>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var cambioResponse = new RestTemplate().getForEntity(
            "http://localhost:8000/cambio-service/{amount}/{from}/{to}",
            CambioResponse.class,
            params
        );

        var currentPort = environment.getProperty("local.server.port");
        book.setEnvironment(currentPort);
        book.setPrice(cambioResponse.getBody().getConvertedValue());
        return book;
    }
}
