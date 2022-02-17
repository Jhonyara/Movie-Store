package POO.javaUniversityCourse.movieStore.com.softwareMovies.store;

import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.dataAccessException;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.readDataException;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.writeDataException;

import java.io.IOException;

public interface ImovieStore { //Contains the program operations of program movieStore

    String FILESOURCE = "movies.txt";

    void addMovie(String movieName); //don't add throws,
    void listMovies();
    void searchMovie(String movieName);
    void startFile();
}
