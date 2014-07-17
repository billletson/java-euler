import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 7/4/2014.
 */
public class Fibonacci {
    public static void main(String[] args) {

    }

    public static List<Integer> construct_fibonacci(int limit) {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(1);
        sequence.add(2);
        int length = sequence.size();
        int candidate = sequence.get(length-1) + sequence.get(length-2);
        while(candidate<limit) {
            sequence.add(candidate);
            length++;
            candidate = sequence.get(length-1) + sequence.get(length-2);
        }
        return sequence;
    }
}
