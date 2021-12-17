package br.sales.estante.domain;

import br.sales.estante.model.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookSerice {

    public Optional<List<Book>> findAll() {

        Book book = new Book();

        return Optional.of(Collections.singletonList(book));
    }
}
