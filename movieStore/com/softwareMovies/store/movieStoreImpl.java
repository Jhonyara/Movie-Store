package POO.javaUniversityCourse.movieStore.com.softwareMovies.store;

import POO.javaUniversityCourse.movieStore.com.softwareMovies.data.IDataAccess;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.data.dataAccessImpl;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.domain.*;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.*;

import java.io.File;
import java.io.IOException;

public class movieStoreImpl implements ImovieStore{ //Contains the implementation required operations of program movieStore

    private final IDataAccess dataAccess;

    public movieStoreImpl(){

        this.dataAccess= new dataAccessImpl();

    }

    @Override
    public void addMovie(String movieName) {

        movie movie = new movie(movieName);

        try {

            boolean append = dataAccess.checkIfExists(FILESOURCE);

            dataAccess.write(movie,FILESOURCE,append);

            System.out.println("The movie has been added!");

        } catch (dataAccessException exception) {

            exception.printStackTrace();
            System.out.println("Exception trying add movie!");
        }

    }

    @Override
    public void listMovies()  {

        try {

            var movies = this.dataAccess.list(FILESOURCE);

            for (movie i:movies) {

                System.out.println(i);

            }

        } catch (dataAccessException exception) {

            exception.printStackTrace();
            System.out.println("Error trying access data!");

        }




    }

    @Override
    public void searchMovie(String movieName) {

        String result = null;

        try {
            result = this.dataAccess.search(FILESOURCE,movieName);
        } catch (readDataException e) {
            e.printStackTrace();
        }

        System.out.println(result);

    }

    @Override
    public void startFile() {

        try {

            if (this.dataAccess.checkIfExists(FILESOURCE)) {

                dataAccess.delete(FILESOURCE);

                dataAccess.create(FILESOURCE);

            }else {
                dataAccess.create(FILESOURCE);
            }

        } catch (dataAccessException exception){

            exception.printStackTrace();
            System.out.println("Exception trying start file!");
        }


    }

    }
