import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


//Learning about autoboxing and unboxing.

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> myDouble = new ArrayList<Double>();
        for (double dbl=0.0; dbl<10.0; dbl+=0.5){
            myDouble.add(Double.valueOf(10));
        }

        for(int i=0; i<myDouble.size(); i++ ){
            double  val = myDouble.get(i).doubleValue();
        }

    }
}
