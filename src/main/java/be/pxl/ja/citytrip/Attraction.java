package be.pxl.ja.citytrip;

public class Attraction {
    private String name;
    private double time;
    private int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public Attraction(String naam, double tijd, int rate) {
        this.name = naam;
        this.time = tijd;
        this.rating = rate;
    }

    public int compareTo(Attraction attraction){
        return Integer.compare(attraction.rating, this.rating );
        // output 1 parameter 1 groter dan parameter 2, output 0 parameters gelijk, output -1 parameter 1 kleiner dan parameter 2
    }

    public double getWeigth(){
        return time;
    }

    @Override
    public String toString() {
        return  String.format("%-20s | %4s day | %3s",name, time, rating);
    }
}
