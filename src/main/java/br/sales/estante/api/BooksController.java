package br.sales.estante.api;

import br.sales.estante.domain.BookSerice;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/books")
public class BooksController {

    @Inject
    private BookSerice bookSerice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBook() {

        var books = bookSerice.findAll().orElseThrow(() -> new NotFoundException("Nenhum livro encontrado"));

        return Response.ok(books).build();
    }

}
