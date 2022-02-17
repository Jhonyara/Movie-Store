package POO.javaUniversityCourse.movieStore.com.softwareMovies.domain;

public class movie {

    private String name;

    public movie(){

    }
    public movie(String name){

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
