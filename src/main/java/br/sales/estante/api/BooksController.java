package br.sales.estante.api;

import br.sales.estante.domain.BookSerice;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

}
