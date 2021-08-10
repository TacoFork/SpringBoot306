package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String genre;

    //sets do not allow duplicates
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //cascade and fetch are configurations and have to do with how the database retrieves/updates information
    //CascadeType.All is saying if the director is deleted so will all his movies. FetchType.EAGER is saying whenever we call for the director all of the movie objects are called as well.
    // FetchType.LAZY means everytime you call the director only the movies specified will be called.
    private Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
