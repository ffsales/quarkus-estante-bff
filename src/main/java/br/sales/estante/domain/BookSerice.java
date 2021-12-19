package br.sales.estante.domain;

import br.sales.estante.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.redis.client.RedisClient;
import io.smallrye.common.annotation.NonBlocking;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookSerice {

    @Inject
    RedisClient redisClient;

    public Optional<List<Book>> findAll() {

        Book book = new Book();

        return Optional.of(Collections.singletonList(book));
    }

    @Transactional
    @NonBlocking
    public Optional<Book> save(Book book) {

        book.setId(UUID.randomUUID());
        try {
            String bookPayload = new ObjectMapper().writeValueAsString(book);
            redisClient.append(book.getId().toString(), bookPayload);
            redisClient.save();
            return Optional.of(book);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
