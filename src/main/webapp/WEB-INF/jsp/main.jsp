<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="jumbotron" style="padding: 50px;">
  <h1>스프링 부트 스터디 일요일 모임</h1>
  <p>
    <strong>학습목표</strong><br>
    1. spock을 이용한 테스트 환경 구축 및 BDD개발 방식으로 개발하기.<br>
    2. 스프링 부트 설정을 알아봅니다.<br>
    3. 프론트앤드 자바스크립트 css 관리는 어떻게 하는지?<br>
    4. JPA에 대해서 알아 봅니다.<br>
    5. Spring Security를 이용한 로그인 처리 해주세요. <br>
    6. paging을 구현해 보자. <br>
    7. native query는 어떻게 해야 하나? <br>
    8. 게시판에 롤링 배너를 넣어주세요.
  </p>
  <p><a class="btn btn-primary btn-lg">더보기</a></p>
</div>

<div class="content">
  <div style="text-align: left">
    <h1>공지사항</h1>
  </div>
<ul class="list-group">
  <li class="list-group-item">
    <span class="badge">14</span>
    공지사항 테이블을 만들고.
  </li>
  <li class="list-group-item">
    <span class="badge">2</span>
    공지사항 데이터를 채워주세요.
  </li>
  <li class="list-group-item">
    <span class="badge">1</span>
    공지사항 게시판도 필요하겠죠.
  </li>
</ul>
  <div style="text-align: left">
    <h1>회원목록</h1>
  </div>
<div class="list-group">
  <a href="#" class="list-group-item">
    <h4 class="list-group-item-heading">자바개발자</h4>
    <p class="list-group-item-text">김태희 - 각 그룹별로 개발자들 현황을 보여주세요.</p>
  </a>
  <a href="#" class="list-group-item">
    <h4 class="list-group-item-heading">자바개발자</h4>
    <p class="list-group-item-text">아이유 - 여기도 설계해서 완성해 보아요.</p>
  </a>
</div>

</div>

<!--공통함수 -->
<script src="common/common.js"></script>

<script>
  $(function(){
    CommonUtil.fnMenuLiActive(0);
  });
</script>
