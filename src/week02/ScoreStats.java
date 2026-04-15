package week02;

import java.util.Arrays;

public class ScoreStats {
    public static void main(String[] args) {
        int[] scores = {90, 85, 77, 92, 100};

        // Arrays.toString(arr) 로 배열을 보기 좋게 출력
        System.out.println("점수 배열: " + Arrays.toString(scores));
        System.out.println("총합: " + sum(scores));
        System.out.println("평균: " + average(scores));
        System.out.println("최고점: " + max(scores));
        System.out.println("최저점: " + min(scores));
    }

    public static int sum(int[] scores) {
        int j = 0;
        for (int score : scores) {
            j += score;
        }
        return j;
    }

    public static double average(int[] scores) {
        return (double) sum(scores) / scores.length;
    }

    public static int max(int[] scores) {
        int maxValue = scores[0];
        for (int i = 1; i < scores.length; i++) {
            maxValue = Math.max(maxValue, scores[i]);
        }
        return maxValue;
    }

    public static int min(int[] scores) {
        int minValue = scores[0];
        for (int i = 1; i < scores.length; i++) {
            minValue = Math.min(minValue, scores[i]);
        }
        return minValue;
    }
}