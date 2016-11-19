<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- table list template start -->
<script id="board_list_tpl" type="text/x-handlebars-template">
  {{#boardList}}
  <tr>
    <td>{{bno}}</td>
    <td><a href="#" onclick="App.fnDetailView({{bno}})">{{title}}</a></td>
    <td>{{writer}}</td>
    <td>{{viewCount}}</td>
  </tr>
  {{/boardList}}
</script>
<!-- table list template end -->

<ul class="breadcrumb">
  <li><a href="/boardTplList">Home</a></li>
  <li class="active">List</li>
</ul>

<div style="text-align: center">
  <h1>Springboot Board List </h1>
</div>

<div class="content">

  <table class="table table-striped table-hover ">
    <thead>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>글쓴이</th>
      <th>조회수</th>
    </tr>
    </thead>
    <tbody id="board_list_div">
    </tbody>
  </table>

  <ul class="pagination">
    <li class="disabled"><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
  </ul>

  <!--공통함수 -->
  <script src="common/common.js"></script>
  <!--서비스 로직 -->
  <script src="biz/board_page_list.js"></script>

  <script>
    $(function(){
      App.onCreate();
    });

  </script>

</div>
