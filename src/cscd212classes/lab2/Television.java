package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){

        if(make == null) throw new IllegalArgumentException("Make is null");
        if(model == null) throw new IllegalArgumentException("Model is null");
        if(screenSize < 32) throw new IllegalArgumentException("Screen size too low");
        if(resolution < 720) throw new IllegalArgumentException("Resolution too low");

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.fourK = (resolution == 2160);
    }
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){
        this(make, model, smart, screenSize, resolution);
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return  fourK == that.fourK &&
                resolution == that.resolution &&
                screenSize == that.screenSize &&
                smart == that.smart &&
                make.equals(that.make) &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fourK, make, model, resolution, screenSize, smart);
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    @Override
    public int compareTo(Television another){

       if(another == null) throw new IllegalArgumentException("Null input for Television.compareTo");
       if(this.make.compareTo(another.make) == 0){
           if(this.model.compareTo(another.model) == 0){
               return this.screenSize - another.screenSize;
           }
           return this.model.compareTo(another.model);
       }
       return this.make.compareTo(another.make);
    }
}
