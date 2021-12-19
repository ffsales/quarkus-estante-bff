package br.sales.estante.api;

import br.sales.estante.domain.BookSerice;
import br.sales.estante.model.Book;
import br.sales.estante.dto.BookDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/v1/books")
@Tag(name = "/v1/books", description = "API de livros")
public class BooksController {

    @Inject
    private BookSerice bookSerice;

    @GET
    @Operation(description = "API que retorna uma lista de todos os livros")
    @APIResponses(value = {
            @APIResponse(description = "Retorna 200 para sucesso", responseCode = "200"),
            @APIResponse(description = "retorna 404 se não encontrar nenhum", responseCode = "404")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBook() {

        var books = bookSerice.findAll().orElseThrow(() -> new NotFoundException("Nenhum livro encontrado"));

        return Response.ok(books).build();
    }

    @POST
    @Operation(description = "API que grava livro")
    @APIResponses(value = {
            @APIResponse(description = "Retorna 201 para sucesso", responseCode = "200"),
            @APIResponse(description = "retorna 404 se não encontrar nenhum", responseCode = "404")
    })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(BookDto dto) {

        var book = Book.builder().title(dto.getTitle()).build();

        var optionalbook = bookSerice.save(book);

        if (optionalbook.isEmpty()) {
            throw new NotFoundException("Não foi possível gravar");
        }
        var uri = URI.create("/v1/books/".concat(optionalbook.get().getId().toString()));

        return Response.created(uri).build();
    }

    @GET
    @Path("/{uuid}")
    @Operation(description = "API que retorna um livro")
    @APIResponses(value = {
            @APIResponse(description = "Retorna 200 para sucesso", responseCode = "200"),
            @APIResponse(description = "retorna 404 se não encontrar nenhum", responseCode = "404")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Book find(@PathParam("uuid") String uuid) {

        var optionalBook = bookSerice.find(uuid);
        return optionalBook.orElseThrow(() -> new NotFoundException("Livro não encontrado"));
    }

}
