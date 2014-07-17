import java.util.*;
import java.io.*;

public class Euler1_10 {
    public static void main(String[] args) {
        System.out.println(problem_1(3, 5, 1000));
        System.out.println(problem_2(4000000));
        System.out.println(problem_3(600851475143L));
        System.out.println(problem_4());
        System.out.println(problem_5(20));
        System.out.println(problem_6(100));
        System.out.println(problem_7(10001));
        try {
            System.out.println(problem_8(5));
        } catch (FileNotFoundException e) {
            System.out.println("Problem 8 missing file");
        } catch (IOException e) {
            System.out.println("Problem 8 missing file");
        }
        System.out.println(problem_9(1000));
        System.out.println(problem_10(2000000));
    }

    /**
     * Find and sum all the multiples of X or Y below Limit
     */
    public static int problem_1(int x, int y, int limit) {
        int accum = 0;
        for(int i=1;i<limit;i++) {
            if(i%x==0 || i%y==0) {
                accum += i;
            }
        }
        return accum;
    }

    public static int problem_2(int limit) {
        List<Integer> sequence = Fibonacci.construct_fibonacci(limit);
        int accum = 0;
        for(int fib : sequence) {
            if(fib%2==0) {
                accum += fib;
            }
        }
        return accum;
    }

    public static int problem_3(long number) {
        Map<Integer,Integer> factors = Factorization.prime_factorize(number);
        List<Integer> keys = new ArrayList<Integer>();
        keys.addAll(factors.keySet());
        Collections.sort(keys);
        return keys.get(keys.size()-1);
    }

    public static int problem_4() {
        List<Integer> candidates = new ArrayList<Integer>();
        for(int i=100;i<1000;i++) {
            for(int j=100;j<1000;j++) {
                candidates.add(i*j);
            }
        }
        Collections.sort(candidates);
        for(int i=candidates.size()-1;i>=0;i--) {
            if(Palindromes.integer_is_palindrome(candidates.get(i))) {
                return candidates.get(i);
            }
        }
        return -1;
    }

    public static int problem_5(int limit) {
        Map<Integer,Integer> common = new HashMap<Integer, Integer>();
        for(int i=2;i<=limit;i++) {
            common = Factorization.factored_least_common_multiple(common, Factorization.prime_factorize(i));
        }
        return Factorization.factors_to_int(common);
    }

    public static int problem_6(int limit) {
        int sum_squares = 0;
        int square_sum = 0;
        for(int i=1;i<=limit;i++) {
            sum_squares += i * i;
            square_sum += i;
        }
        square_sum *= square_sum;
        return square_sum - sum_squares;
    }

    public static int problem_7(int index) {
        int candidate = index * index;
        List<Integer> primes = Primes.sieve_of_eratosthenes(candidate);
        while(primes.size() < index) {
            candidate *= index;
            primes = Primes.sieve_of_eratosthenes(candidate);
        }
        return primes.get(index-1);
    }

    public static int problem_8(int consec) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("problem_8.txt"));
        String full_string = "";
        String line;
        while ((line=input.readLine()) != null) {
            full_string += line;
        }
        int length = full_string.length();
        int max = 0;
        int candidate = 1;
        for(int i=0;i<length-consec;i++) {
            for(int j=0;j<consec;j++) {
                candidate *= Character.getNumericValue(full_string.charAt(i+j));
            }
            max = Integer.max(max, candidate);
            candidate = 1;
        }
        return max;
    }

    public static int problem_9(int limit) {
        // Limit must be even to have a solution
        if(limit%2==1) {
            return 0;
        } else {
            limit = limit / 2;
        }
        int sum = 0;
        int n = 1;
        int m = 2;
        boolean working = true;
        while(working) {
            sum = m * (m + n);
            if(sum == limit) {
                return (m*m - n*n) * (2 * m * n) * (m*m + n*n);
            } else if (sum > limit) {
                if(m - n == 1) {
                    working = false;
                } else {
                    n++;
                    m = n + 1;
                }
            } else {
                m++;
            }
        }
        return 0;
    }

    public static long problem_10(int limit) {
        List<Integer> primes = Primes.sieve_of_eratosthenes(limit);
        long accum = 0;
        for(int x : primes) {
            accum += x;
        }
        return accum;
    }
}
