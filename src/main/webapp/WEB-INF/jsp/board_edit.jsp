<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script id="job_list_tpl" type="text/x-handlebars-template">
  <select class="form-control" id="jobGubun" name="jobGubun">
    <option value="">선택사항없음</option>
    {{#jobList}}
    <option value="{{code}}">{{codeNm}}</option>
    {{/jobList}}
  </select>
</script>
<script id="lang_list_tpl" type="text/x-handlebars-template">
  <select class="form-control" id="langGubun" name="langGubun">
    <option value="">선택사항없음</option>
    {{#langList}}
    <option value="{{code}}">{{codeNm}}</option>
    {{/langList}}
  </select>
</script>

<ul class="breadcrumb">
  <li><a href="/boardTplList">Home</a></li>
  <li class="active">Write</li>
</ul>

<div style="text-align: center">
  <h1>Springboot Board Edit </h1>
</div>

<div class="content">
  <form class="form-horizontal">
    <fieldset>
      <legend style="margin-bottom: 50px;"> </legend>
      <div class="form-group">
        <label for="writer" class="col-lg-2 control-label">글쓴이</label>
        <div class="col-lg-10">
          <input type="text" class="form-control" id="writer" name="writer" placeholder="아이디">
        </div>
      </div>
      <div class="form-group">
        <label for="title" class="col-lg-2 control-label">제목</label>
        <div class="col-lg-10">
          <input type="text" class="form-control" id="title" name="title" placeholder="제목">
        </div>
      </div>
      <div class="form-group">
        <label for="password" class="col-lg-2 control-label">비밀번호</label>
        <div class="col-lg-10">
          <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
      </div>
      <div class="form-group">
        <label for="content" class="col-lg-2 control-label">내용</label>
        <div class="col-lg-10">
          <textarea class="form-control" rows="3" id="content" name="content"></textarea>
        </div>
      </div>
      <div class="form-group">
        <label class="col-lg-2 control-label">성별</label>
        <div class="col-lg-10">
          <div class="radio" style="float: left;">
            <label>
              <input type="radio" name="sex" id="sex1" value="true" checked="">
              남
            </label>
            <label>
              <input type="radio" name="sex" id="sex2" value="false">
              여
            </label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-lg-2 control-label">직업</label>
        <div class="col-lg-10">
          <div id="job_div"></div>
          <br>
          <div id="lang_div"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-lg-10 col-lg-offset-2">
          <button type="button" class="btn btn-default" onclick="App.fnReset()">리셋</button>
          <button type="button" class="btn btn-default" onclick="App.fnEdit()">수정</button>
          <button type="button" class="btn btn-default" onclick="App.fnDelete()">삭제</button>
          <button type="button" class="btn btn-default" onclick="App.fnList()">목록</button>
        </div>
      </div>
    </fieldset>
  </form>

  <!--공통함수 -->
  <script src="common/common.js"></script>
  <!--서비스 로직 -->
  <script src="biz/board_edit.js"></script>

  <script>
    $(function(){
      App.onCreate();
      App.fnDetail("${param.bno}");
    });
  </script>

</div>
