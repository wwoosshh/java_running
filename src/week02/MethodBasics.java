package week02;

public class MethodBasics {
    public static void main(String[] args) {
        System.out.println(sum(10, 20));     // 30
        System.out.println(isEven(4));       // true
        System.out.println(isEven(7));       // false
        System.out.println(max(15, 8));      // 15
        greet("철수");                        // 안녕, 철수!
        greet("영희", 25);                    // 안녕, 영희!
    }

    public static int sum(int a, int b) {
        return (a + b);
    }

    public static boolean isEven(int a) {
        double b = a;
        if (a / 2 == b / 2) {
            return true;
        }
        return false;
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else if (b > a) {
            return b;
        } else {
            System.out.println("두 값이 같습니다.");
            return 0;
        }
    }

    public static String greet(String a) {
        System.out.println("안녕, " + a + "!");
        return a;
    }

    public static String greet(String a, int b) {
        if (b != 0) {
            System.out.println("안녕, " + a + "! " + b + "살이네요.");
        }
        return a;
    }
}
