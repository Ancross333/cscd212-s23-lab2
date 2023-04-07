package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {

    public int compare(Television t1, Television t2){
        if(t1 == null || t2 == null)
            throw new IllegalArgumentException("One or more null Television objects");

        if(t1.getResolution() - t2.getResolution() == 0){
            return t1.getMake().compareTo(t2.getMake());
        }

        return t1.getResolution() - t2.getResolution();
    }
}
