package week06;

import java.util.Comparator;
import java.util.List;

/**
 * 학생 리스트를 받아 통계/집계 결과를 돌려주는 클래스.
 *
 * 학습 포인트 (Week 5 Library와의 차이):
 *  - Library는 books를 "보관"했습니다(상태 O). ScoreStats는 아무것도 보관하지 않습니다(상태 X).
 *    매번 List<Student>를 인자로 받아 가공만 합니다 → 백엔드의 "유틸 서비스" 패턴.
 *  - 각 메서드 본문은 Stream 한 줄로 끝나는 것이 이상적입니다.
 *  - for/if를 쓰지 않으려고 노력해보세요. 안 되면 일단 for로 짜고 → 나중에 stream으로 변환.
 *
 * Stream 치트시트 (이 파일 안에서 다 쓰입니다):
 *  - students.stream().mapToInt(Student::getScore).sum()         // 합계
 *  - students.stream().mapToInt(Student::getScore).average()     // OptionalDouble
 *  - students.stream().filter(s -> s.getScore() >= 60)           // 조건 필터
 *  - students.stream().map(Student::getName)                     // 변환
 *  - students.stream().max(Comparator.comparingInt(Student::getScore))  // Optional<Student>
 *  - students.stream().sorted(Comparator.comparingInt(Student::getScore).reversed())
 *  - .toList()                                                   // 리스트로 모으기 (Java 16+)
 *  - .count()                                                    // long 반환
 *
 * OptionalDouble/Optional 처리:
 *  - .orElse(기본값)   → 비어있으면 기본값
 *  - .getAsDouble()    → 비어있으면 예외 (사용 비추천)
 */
public class ScoreStats {

    /**
     * 전체 평균 점수.
     * 학생이 없으면 0.0 반환.
     *
     * 힌트: mapToInt(Student::getScore).average().orElse(0.0)
     */
    public double average(List<Student> students) {
        // TODO
        return 0.0;
    }

    /**
     * 전체 점수의 합계.
     *
     * 힌트: mapToInt(Student::getScore).sum()
     */
    public int total(List<Student> students) {
        // TODO
        return 0;
    }

    /**
     * 가장 높은 점수를 받은 학생 1명.
     * 학생이 없으면 null 반환.
     *
     * 힌트: max(Comparator.comparingInt(Student::getScore)).orElse(null)
     */
    public Student top(List<Student> students) {
        // TODO
        return null;
    }

    /**
     * 합격선(passLine) 이상인 학생들의 "이름"만 모은 리스트.
     * 예: passLine=60 → ["김지훈", "이서연", "최유진"]
     *
     * 힌트: filter(...) → map(Student::getName) → toList()
     */
    public List<String> passedNames(List<Student> students, int passLine) {
        // TODO
        return List.of();
    }

    /**
     * 점수 내림차순으로 정렬된 학생 리스트.
     * 원본 리스트는 변경하지 않고 새 리스트를 반환합니다 (Stream은 원본을 안 건드림).
     *
     * 힌트: sorted(Comparator.comparingInt(Student::getScore).reversed()).toList()
     */
    public List<Student> sortedDesc(List<Student> students) {
        // TODO
        return List.of();
    }

    /**
     * 합격선 이상인 학생 수.
     *
     * 힌트: filter(...).count()  // count()는 long 반환
     */
    public long passCount(List<Student> students, int passLine) {
        // TODO
        return 0L;
    }
}
