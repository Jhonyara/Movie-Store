package POO.javaUniversityCourse.movieStore.com.softwareMovies.laboratory;

import POO.javaUniversityCourse.movieStore.com.softwareMovies.exceptions.dataAccessException;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.store.ImovieStore;
import POO.javaUniversityCourse.movieStore.com.softwareMovies.store.movieStoreImpl;

import java.io.IOException;
import java.util.Scanner;

public class laboratory {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        var option = 0;

        ImovieStore movieStore = new movieStoreImpl();

        System.out.println("\n-------------------------" +
                "\nSoftware for movie control" +
                "\n-------------------------");


        do {
            System.out.print("\n1.Start movie control" +
                    "\n2.Add movie" +
                    "\n3.List movies" +
                    "\n4.Search movie" +
                    "\n5.Exit" +
                    "\nSelect an option: ");

            option = Integer.parseInt(scan.nextLine());

            switch (option){
                case 1:

                   movieStore.startFile();

                    break;
                case 2:

                    System.out.print("Enter movie name: ");

                    var movieName = scan.nextLine();

                    movieStore.addMovie(movieName);

                    break;
                case 3:

                    movieStore.listMovies();

                    break;
                case 4:

                    System.out.print("Enter what's movie to search: ");

                    movieName = scan.nextLine();

                    movieStore.searchMovie(movieName);

                    break;
                case 5:

                    System.out.println("Thanks for using our software :)");

                    break;
                default:
                    System.out.println("This option isn't available!");
            }
        }while (option!=5);


    }

}
