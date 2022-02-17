package POO.javaUniversityCourse.movieStore.com.softwareMovies.data;

import POO.javaUniversityCourse.movieStore.com.softwareMovies.domain.movie;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.*;

import java.io.*;
import java.util.*;

public class dataAccessImpl implements IDataAccess{



    @Override
    public boolean checkIfExists(String fileName) {

        File file = new File(fileName);

        return file.exists();//return value (exists or not?)

    }

    @Override
    public List<movie> list(String fileName) throws readDataException { //add the movies inside the file to movieList

        File file = new File(fileName);

        List<movie> movieList = new ArrayList<>(); //create the list for add the movies from the file

        try {

            var reader = new BufferedReader(new FileReader(file));

            String line = null; //assign a null value for each line in the text file

            line = reader.readLine(); //read the lines

            while (line!=null) {

                var movie = new movie(line); //new movie with the name of the movie

                movieList.add(movie); //add the movie to the list

                line = reader.readLine();//and continues reading

            }

            reader.close(); //for last, close


        } catch (IOException exception) {

            exception.printStackTrace();
            throw new readDataException("Exception trying list movies!"+exception.getMessage());

        }

        return movieList;

    }

    @Override
    public void write(movie movie, String fileName, boolean append) throws writeDataException {

        File file = new File(fileName);

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(file,append)); //for append new content in the file

            writer.println(movie.toString()); //for print in the file in each line

            writer.close();//for last, close the writer

            System.out.println("Movie added: "+movie.toString());


        } catch (IOException exception){

            exception.printStackTrace();
            throw new writeDataException("Exception trying write in the file!");

        }

    }

    @Override
    public String search(String fileName, String search) throws readDataException {

        File file = new File(fileName);

        String result = null; //Save the result

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;

            line = reader.readLine(); //for check one by one the lines

            int index = 1;

            while (line != null){

                if (search!=null && search.equalsIgnoreCase(line)) { //if are equals and isn't null

                    result = search+" has been founded in index "+index+"!";
                    break;

                }

                line = reader.readLine();
                index++;

            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return result;
    }

    @Override
    public void create(String fileName) throws dataAccessException{

        File file = new File(fileName);
        try {

            PrintWriter newFile = new PrintWriter(new FileWriter(file)); //For create new file in the route
            newFile.close();

            System.out.println("The new file has been created!");

        } catch (IOException exception) {

            exception.printStackTrace();
            throw new dataAccessException("Exception trying create file!");
        }


    }

    @Override
    public void delete(String fileName) {

        File file = new File(fileName);

        if (file.exists()) {

            file.delete();

            System.out.println("The file has been deleted!");

        }

    }


}
