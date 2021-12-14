# 01.1 변수 및 배열 다루기: 배열 및 입력 값 다루기

## 실습

### 1단계 - 연락처 목록 구현

- 화면 구현
  - /static/contact/index.html 생성
    - 0: 기본 화면
    - 1: 테이블 추가
    - 2: 연락처 배열 준비 및 각 항목 확인
    - 3: 문자열에서 이름, 이메일, 전화, 회사 정보 추출
    - 4: 테이블에 추가할 tr 태그 생성
    - 5: tr 태그를 테이블에 추가
- REST API 구현
  - com.eomcs.mylist.ContactController.list()
- 화면과 REST API 연동
  - /static/contact/index.html 변경
    - 6: AJAX를 이용하여 서버의 REST API와 연동하기

### 2단계 - 연락처 입력 구현

- REST API 구현
  - com.eomcs.mylist.ContactController.add()
- 화면 구현
  - /static/contact/form.html 생성
    - 0: 기본 화면
    - 1: 입력 폼 추가
    - 2: 버튼 클릭 리스너 등록
    - 3: 버튼을 클릭할 때 입력 폼의 값을 알아내기
    - 4: 입력된 값을 서버에 보내기
    - 5: 취소 버튼 추가
    - 6: 리팩토링 - replace temp with query
      - 함수의 리턴 값을 받는 변수를 한 번만 사용할 경우 변수 대신 함수 호출을 삽입하라!
      - 즉 임시 변수를 사용할 자리에 함수 호출을 그대로 집어 넣어라!
    - 7: 필수입력 항목 검사하기
    - 8: 최적화 - 태그 찾기를 리스너 밖에 둔다.
    - 9: 등록 후 목록 화면으로 이동

### 3단계 - 연락처 데이터 유지

- REST API 기능 변경
  - com.eomcs.mylist.ContactController  변경
    - 배열을 로컬 변수에서 인스턴스 변수로 전환한다.
    - list()와 add()는 인스턴스 배열 변수를 사용한다.
    - list(): 배열에 입력된 값을 별도의 배열에 담아 리턴한다.
    - add(): 인스턴스 배열에 값을 보관한다.

### 4단계 - 연락처 상세보기 구현

- 화면 구현
  - /static/contact/view.html 생성
    - 0: form.html 을 복사해 온다.
    - 1: URL에서 쿼리스트링을 추출한다.
    - 2: 쿼리스트링에서 이메일 값을 추출한다.
    - 3: 연락처 상세 정보를 출력한다.
  - /static/contact/index.html 변경
    - 연락처의 이름에 상세보기 링크를 추가한다.
- REST API 구현
  - com.eomcs.mylist.ContactController.get()
- 화면과 REST API 연동
  - /static/contact/view.html 변경
    - 4: 서버에서 데이터 가져온다.
    - 5: 쿼리스트링 분석기 URLSearchParams 객체를 사용해서 email 파라미터를 추출한다.

### 5단계 - 연락처 변경 구현

- 화면 구현
  - /static/contact/view.html 변경
    - 6: 이메일 항목을 readonly로 변경한다.
    - 7: 변경한 내용을 서버에 보낸다.
- REST API 구현
  - com.eomcs.mylist.ContactController.update()

### 6단계 - 연락처 삭제 구현

- REST API 구현
  - com.eomcs.mylist.ContactController.delete()
- 화면 구현
  - /static/contact/view.html 변경
    - 8: 삭제 버튼 추가 및 리스너를 등록한다.
    - 9: 서버에 삭제를 요청한다.






#
