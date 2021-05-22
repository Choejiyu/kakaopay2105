## kakaopay2105  

### 특정 고객 거래내역 조회 서비스 개발
---

개요

* [프레임워크](#프레임워크)
* [테스트페이지 주소](#테스트 페이지 주소)
* [API Specifications](#API Specifications)
* [요구사항 및 문제해결 전략](#요구사항및 문제해결 전략)

---

## 프레임워크

>> JDK 1.8

>> Spring Boot

>> My Batis

>> lombok 

>> Maven

>> In memory DB  H2 

---

## [테스트 페이지 주소](http://localhost:8090/home)
>> http://localhost:8090/home

---
## API Specifications

 1.	2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
 >>  구현 방법 / GET 방식  
 >>  url : /getResult01

2.	2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발. (취소여부가 ‘Y’ 거래는 취소된 거래임)

>>  구현 방법 / GET 방식  
  >>  url : /getResult02


3.	연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임)
>>  구현 방법 / GET 방식  
>>  url : /getResult03

4.	분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
>>  구현 방법 / GET 방식  
 >>  Response 
 >>  url : /getResult04


---
## 요구사항 및 문제해결 전략
  * H2 데이터 베이스 사용하요 간단한 프로젝트를 위한 DB환경 구축 
  * 거래내역, 은행, 고객 csv 데이터 앱 기동과 동시에 create table / insert 완료 
  * 각 api 에 필요한 ENTITY 생성 
  * Lombok 라이브러리를 이용해 별도로 getter, setter 작성 필요하지않아 개발 용이함
  * view 단에 버튼 만들어 api 눈에 보이게 명시함.
  * UNIT TEST 
   ** BaseController 는 Junit Tewt 선택 
   ** MainController 는 MockMvc Test 선택


