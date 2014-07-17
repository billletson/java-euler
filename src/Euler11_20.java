import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*

/**
 * Created by Bill on 7/4/2014.
 */
public class Euler11_20 {
    public static void main(String[] args) {
        try {
            System.out.println(problem_11());
        } catch (FileNotFoundException e) {
            System.out.println("Problem 11 missing file");
        } catch (IOException e) {
            System.out.println("Problem 11 missing file");
        }
    }

    public static int problem_11(int consec) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("problem_11.txt"));
        int[][] matrix;
        String line;
        int i = 0;
        while((line = input.readLine()) != null) {

        }
    }
}
