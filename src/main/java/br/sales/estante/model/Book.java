package br.sales.estante.model;

import java.util.UUID;


public class Book {

    private UUID id;
    private String title;
//    private Genre genre;
//    private Publishing publishing;
//    private Publishing licensor;
//    private CreativeTeam creativeTeam;
//    private Country country;

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
