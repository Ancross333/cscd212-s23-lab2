package cscd212classes.lab2;


public class Television implements Comparable<Television>{

    //Instance Fields
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    //EVC that does all the work
    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){

        if(make == null ||
                model == null ||
                screenSize < 32 ||
                resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.fourK = (resolution == 2160);
    }

    //Lazy EVC
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){
        this(make, model, smart, screenSize, resolution);
    }

    //Getters

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getScreenSize() {
        return this.screenSize;
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


    //Fancy Hashcode

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution +
                Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }


    //Fancy toString
    @Override
    public String toString(){
        return this.make + "-" + this.model + ", " + this.screenSize + " inch"
                + (this.smart? " smart " : " ") + "tv with " +
                (fourK? "4K" : resolution) + " resolution";
    }


    @Override
    public int compareTo(Television another){

       if(another == null) throw new IllegalArgumentException("null parameter in the compareTo method");
       if(this.make.compareTo(another.make) == 0){
           if(this.model.compareTo(another.model) == 0){
               return this.screenSize - another.screenSize;
           }
           return this.model.compareTo(another.model);
       }
       return this.make.compareTo(another.make);
    }
}
