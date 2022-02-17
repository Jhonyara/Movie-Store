package POO.javaUniversityCourse.movieStore.com.softwareMovies.data;

import POO.javaUniversityCourse.movieStore.com.softwareMovies.domain.movie;

import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.*;

import java.io.IOException;
import java.util.List;

public interface IDataAccess { //Contains actions to execute in .txt file



    boolean checkIfExists(String fileName)throws dataAccessException;
    List<movie> list(String fileName)throws readDataException;
    void write(movie movie,String fileName,boolean append) throws readDataException, writeDataException;
    String search(String fileName,String search)throws readDataException;
    void create(String fileName) throws dataAccessException;
    void delete(String fileName)throws dataAccessException;
}
