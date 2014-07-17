import java.util.*;

public class Primes {
    public static void main(String[] args){

    }

    public static List<Integer> sieve_of_eratosthenes(int limit) {
        boolean[] prime_status = new boolean[limit+1];
        Arrays.fill(prime_status, true);
        List<Integer> primes = new ArrayList<Integer>();
        if(limit >= 2) {
            prime_status[0] = false;
            prime_status[1] = false;
            for (int i = 2; i < limit+1; i++) {
                if (prime_status[i]) {
                    primes.add(i);
                    for (int j = 2 * i; j < limit; j += i) {
                        prime_status[j] = false;
                    }
                }
            }
        }
        return primes;
    }
}
