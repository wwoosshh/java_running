package week02;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    public static String fizzBuzz(int n) {
        String name = "";
        if (n % 3 == 0) name += "Fizz";
        if (n % 5 == 0) name += "Buzz";
        return name.isEmpty() ? String.valueOf(n) : name;
    }
}