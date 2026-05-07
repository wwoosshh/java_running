# 도서관 관리 시스템 — 설계 문서

작성일: 2026-05-07
대상: 자바 학습자 (백엔드 개발자 지향)
선행 학습: 변수, 배열, 메서드, Scanner, switch
이번에 처음 다루는 개념: **클래스, 객체, 생성자, ArrayList, 캡슐화, 계층 분리**

---

## 1. 문제 정의

**무엇을 만드는가:** 콘솔에서 동작하는 도서관 책 관리 프로그램.

**왜 만드는가:** 백엔드 개발의 핵심 사고방식인 **"관심사의 분리"**, **"데이터 클래스와 로직 클래스의 분리"**, **"입출력과 비즈니스 로직의 분리"** 를 처음으로 체득하기 위함.

이 예제를 마치면 다음을 이해하게 된다:
- 왜 Spring의 Entity / Service / Controller가 분리되어 있는지
- 왜 데이터를 메모리에서 다루는 코드와 파일/DB에 저장하는 코드가 분리되어야 하는지
- 캡슐화(`private` 필드 + `public` 메서드)가 왜 중요한지

---

## 2. 기능 명세 (1단계 — 메모리 버전)

| 번호 | 기능 | 입력 | 출력/효과 |
|---|---|---|---|
| 1 | 책 등록 | 제목, 저자 | id 자동 부여, "등록 완료" 메시지 |
| 2 | 전체 목록 조회 | (없음) | 모든 책의 정보 출력 |
| 3 | 제목으로 검색 | 키워드 | 제목에 키워드를 포함한 책 목록 출력 |
| 4 | 대출 | 책 id | 성공 시 "대출 완료", 실패 시 "대출 실패" |
| 5 | 반납 | 책 id | 성공 시 "반납 완료", 실패 시 "반납 실패" |
| 0 | 종료 | (없음) | 프로그램 종료 |

**실패 조건 (대출/반납):**
- 해당 id의 책이 없음
- 대출하려는 책이 이미 대출중
- 반납하려는 책이 이미 반납됨

---

## 3. 실행 규칙

1. 프로그램을 실행하면 메뉴가 반복적으로 표시된다.
2. 사용자는 0~5 중 하나를 입력하여 기능을 선택한다.
3. 잘못된 입력(범위 밖, 숫자가 아닌 값)은 "올바른 메뉴 번호를 입력하세요" 메시지를 출력하고 메뉴로 돌아간다.
4. `0`을 입력하면 종료한다.
5. 데이터는 메모리에만 보관되며, 종료 시 사라진다 (1단계 한정).

---

## 4. 아키텍처

### 클래스 구조

```
src/week05/
├── Book.java          ← 데이터 클래스 (책 한 권을 표현)
├── Library.java       ← 비즈니스 로직 클래스 (책들을 관리)
├── LibraryMain.java   ← 입출력 클래스 (사용자와 대화)
└── DESIGN.md          ← 이 문서
```

### 클래스별 책임

| 클래스 | 책임 | 알아야 하는 것 | 모르는 것 (중요!) |
|---|---|---|---|
| `Book` | 책 한 권의 정보를 담고, 자기 자신의 상태(대출중/아님)를 변경할 수 있다 | 자기 자신의 필드 | Scanner, ArrayList, 다른 책의 존재 |
| `Library` | 책들의 컬렉션을 관리한다. 등록/검색/대출/반납 로직 수행 | `Book`, `ArrayList` | Scanner, System.out |
| `LibraryMain` | 사용자의 입력을 받고, `Library`에게 일을 시키고, 결과를 출력한다 | Scanner, System.out, `Library` | `Book`의 내부 구조 |

**핵심 원칙:** "누가 무엇을 모르는가"가 명확하게 분리되어 있어야 한다. `Library`는 입출력을 모르고, `Book`은 컬렉션을 모른다. 이것이 계층 분리의 본질이다.

---

## 5. 클래스 설계 상세

### 5.1 `Book` 클래스

**필드 (전부 `private`):**
- `int id` — 책의 고유번호 (등록 순서대로 1, 2, 3...)
- `String title` — 책 제목
- `String author` — 저자
- `boolean isBorrowed` — 대출중 여부 (생성 시 `false`)

**생성자:**
- `Book(int id, String title, String author)` — `isBorrowed`는 자동으로 `false`로 초기화

**메서드:**
- `getId()`, `getTitle()`, `getAuthor()` — getter
- `isBorrowed()` — 대출 여부 조회 (boolean용 getter는 `is`로 시작)
- `borrow()` — 대출 처리 (`isBorrowed = true`)
- `returnBook()` — 반납 처리 (`isBorrowed = false`)
- `toString()` — `[1] 자바의 정석 / 남궁성 (대출가능)` 형식

**학습 포인트:**
- `private 필드 + public 메서드` 패턴 = 캡슐화
- `setIsBorrowed(true)` 같은 단순 setter 대신 `borrow()` / `returnBook()` 같은 **의미 있는 행동 메서드** 노출
- `toString()` 오버라이드로 `System.out.println(book)` 자연스럽게 가능

### 5.2 `Library` 클래스

**필드:**
- `ArrayList<Book> books` — 책 컬렉션
- `int nextId` — 다음 책에 부여할 id (1로 시작)

**메서드:**

| 메서드 | 시그니처 | 동작 |
|---|---|---|
| 등록 | `void register(String title, String author)` | 새 `Book` 생성 후 리스트에 추가, `nextId++` |
| 전체 조회 | `List<Book> findAll()` | `books` 반환 |
| 제목 검색 | `List<Book> searchByTitle(String keyword)` | 제목에 `keyword` 포함된 책 리스트 반환 |
| 대출 | `boolean borrow(int id)` | id로 책 찾고, 가능하면 `book.borrow()` 호출. 성공 여부 반환 |
| 반납 | `boolean returnBook(int id)` | id로 책 찾고, 가능하면 `book.returnBook()` 호출. 성공 여부 반환 |

**검색/조회가 `void`가 아니라 `List<Book>`을 반환하는 이유:**
`Library`는 출력을 모른다. 결과를 반환만 하고, 표시 방법은 호출자가 결정한다. 콘솔이든, 파일이든, 웹 응답이든 `Library` 코드는 그대로다.

**대출/반납이 `boolean`을 반환하는 이유:**
실패 케이스(없음 / 이미 대출중 / 이미 반납됨)를 호출자에게 알려야 하기 때문. 처음에는 `boolean`으로 단순하게 시작하고, 나중에 예외(Exception) 또는 결과 객체로 발전시킬 수 있다.

### 5.3 `LibraryMain` 클래스

**책임:**
- 메뉴 출력
- Scanner로 사용자 입력 받기
- 입력에 따라 `library`의 메서드 호출
- 결과를 `System.out.println`으로 출력
- 잘못된 입력 처리

**메서드 구조:**
- `main(String[] args)` — Scanner 생성, Library 생성, 메인 루프
- `printMenu()` — 메뉴 출력
- `handleRegister(Scanner sc, Library library)` — 등록 화면
- `handleList(Library library)` — 목록 화면
- `handleSearch(Scanner sc, Library library)` — 검색 화면
- `handleBorrow(Scanner sc, Library library)` — 대출 화면
- `handleReturn(Scanner sc, Library library)` — 반납 화면

---

## 6. 데이터 흐름 예시 (대출)

```
1. 사용자: "4" 입력
2. LibraryMain.main() 의 switch가 4번 매칭
3. handleBorrow() 호출
4. Scanner로 책 id 입력받음 (예: 3)
5. library.borrow(3) 호출
6. Library 내부:
   - books에서 id == 3인 Book 검색
   - 못 찾으면 → return false
   - book.isBorrowed() == true 면 → return false
   - 아니면 → book.borrow() 호출 후 return true
7. LibraryMain이 boolean을 받아 메시지 출력:
   - true → "대출 완료"
   - false → "대출 실패: 없거나 이미 대출중"
8. 메뉴로 복귀
```

**관찰:** Scanner와 System.out은 `LibraryMain`에만 등장하고, `Library`와 `Book`에는 등장하지 않는다.

---

## 7. 에러 처리 방침 (1단계)

- **잘못된 메뉴 입력**: `LibraryMain`이 직접 검증하고 안내 메시지 출력
- **숫자 변환 실패**: `try-catch (NumberFormatException)` 으로 감싸서 안내 메시지 출력
- **비즈니스 실패** (대출/반납 불가): `Library`가 `boolean`으로 알리고, `LibraryMain`이 메시지 결정
- **빈 검색 결과**: `Library`는 빈 리스트 반환, `LibraryMain`이 "검색 결과 없음" 출력

---

## 8. 향후 확장 (2단계 이후, 학습 진행에 따라)

| 단계 | 추가할 것 | 학습 개념 |
|---|---|---|
| 2단계 | 파일 저장/로드 | File I/O, BufferedReader/Writer, 직렬화 |
| 3단계 | `Library`를 `BookRepository` + `LibraryService`로 분리 | 단일 책임 원칙, Repository 패턴 |
| 4단계 | `BookRepository`를 인터페이스로 변환 + `MemoryBookRepository` / `FileBookRepository` | 인터페이스, 다형성, 의존성 역전 |
| 5단계 | 회원(Member) + 대출 이력(Loan) | 객체 간 관계, 컬렉션 안의 컬렉션 |
| 6단계 | 예외(Exception) 도입 | 사용자 정의 예외, 예외 계층 |

---

## 9. 비목표 (NOT goals — 1단계에서는 안 하는 것)

- ❌ 회원 관리, 대출 이력, 대출 기한
- ❌ 파일/DB 저장
- ❌ 인터페이스/추상클래스
- ❌ 멀티스레딩, 동시성
- ❌ GUI (콘솔 전용)
- ❌ 단위 테스트 프레임워크 (JUnit) 도입 — 별도 학습 단계
