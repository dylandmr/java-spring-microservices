package br.com.bookService.controllers;

import br.com.bookService.models.Book;
import br.com.bookService.proxy.CambioProxy;
import br.com.bookService.repository.BookRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

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
        try {
            var book = bookRepository.getReferenceById(id);

            var cambioResponse = cambioProxy.getCambio(book.getPrice(), "USD", currency);
            var currentPort = environment.getProperty("local.server.port");

            book.setEnvironment(currentPort + " feign");
            book.setPrice(cambioResponse.getConvertedValue());

            return book;
        } catch (EntityNotFoundException exception) {
            throw new RuntimeException("Book not found.");
        }
    }
}
