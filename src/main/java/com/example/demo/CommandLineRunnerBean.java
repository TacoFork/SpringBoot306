package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    public void run(String...args){

        //Create director
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        //Create movie
        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars...");
        movie.setDirector(director);

        //Crate another movie
        Movie movie2 = new Movie();
        movie2.setTitle("DeathStar Ewoks");
        movie2.setYear(2011);
        movie2.setDescription("About Ewoks on the DeathStar");
        movie2.setDirector(director);

        //add movie to empty list
        Set<Movie> movies = new HashSet<>(); //cant just call a set have to use HashSet
        movies.add(movie);
        movies.add(movie2);

//        movieRepository.save(movie);
//        movieRepository.save(movie2);

        //save directors to the database
        director.setMovies(movies);
        directorRepository.save(director);
        //Don't have to save movies to movie repository because of the relationship between the two classes.
        //It automatically saves to the movie repository when the director is saved to director repository.
    }
}
