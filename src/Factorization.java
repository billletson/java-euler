import java.util.*;

public class Factorization {
    public static void main (String[] args) {

    }

    public static Map<Integer,Integer> prime_factorize(long number) {
        List<Integer> primes = Primes.sieve_of_eratosthenes((int) Math.sqrt(number));
        Map<Integer,Integer> factors = new HashMap<Integer,Integer>();
        for(int i=0;i<primes.size();i++) {
            int divisor = primes.get(i);
            while(number%divisor==0) {
                number = number / divisor;
                if(factors.get(divisor)==null) {
                    factors.put(divisor, 1);
                } else {
                    factors.put(divisor, factors.get(divisor)+1);
                }
            }
        }
        if(number > 1) {
            factors.put((int) number, 1);
        }
        return factors;
    }

    public static Map<Integer,Integer> factored_least_common_multiple(Map<Integer,Integer> first, Map<Integer,Integer> second) {
        Map<Integer,Integer> common = new HashMap<Integer,Integer>();
        Set<Integer> factors = new HashSet<Integer>();
        factors.addAll(first.keySet());
        factors.addAll(second.keySet());
        for(int factor : factors) {
            if(first.get(factor)==null) {
                common.put(factor, second.get(factor));
            } else if(second.get(factor)==null) {
                common.put(factor, first.get(factor));
            } else {
                common.put(factor, Integer.max(first.get(factor), second.get(factor)));
            }
        }
        return common;
    }

    public static int factors_to_int(Map<Integer,Integer> factors) {
        int accum = 1;
        for(int factor : factors.keySet()) {
            accum *= Math.pow(factor, factors.get(factor));
        }
        return accum;
    }
}
