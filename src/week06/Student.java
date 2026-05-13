package week06;

/**
 * 학생 한 명을 표현하는 데이터 클래스.
 *
 * 학습 포인트:
 *  - Week 5 Book과 동일한 패턴: private 필드 + 생성자 + getter + toString()
 *  - 이번엔 borrow() 같은 "행동 메서드"는 없습니다. 순수 데이터 객체(VO)에 가깝습니다.
 *  - Stream에서 Student::getName, Student::getScore 처럼 "메서드 레퍼런스"로 자주 불립니다.
 *
 * 왜 이렇게 단순한가?
 *  - Week 6의 주인공은 ScoreStats에서 다룰 Stream/람다입니다.
 *  - 데이터 모델이 복잡하면 새 문법에 집중하기 어렵습니다. 일부러 가볍게 둡니다.
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        // TODO: 필드 두 개 초기화 (this.~ = ~)
    }

    // TODO: getName() 작성 — name을 반환
    // TODO: getScore() 작성 — score를 반환

    /**
     * 화면 출력용 문자열.
     * 예: "김지훈(92점)"
     *
     * 힌트: String.format("%s(%d점)", name, score)
     */
    @Override
    public String toString() {
        // TODO: 위 형식으로 반환
        return null;
    }
}
