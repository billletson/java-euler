public class Palindromes {
    public static void main(String args[]) {

    }

    public static boolean integer_is_palindrome(int number) {
        String characters = Integer.toString(number);
        int length = characters.length();
        for(int i=0;i<=length/2;i++) {
            if(characters.charAt(i)!=characters.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
