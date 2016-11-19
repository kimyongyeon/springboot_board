// onCreate, onStart, onResume, Activity 실행, onPause(), onDestory(), Activity 종료
var App = {
  // 사용자 인터페이스 초기화
  onCreate: function(){
    console.log("board_edit::onCreate start...!!!");
    console.log("fnMenuLiActive:3");
    CommonUtil.fnMenuLiActive(3);
    CommonUtil.getComboList();
    console.log("board_edit::onCreate end...!!!");
  },
  // 삭제
  fnDelete: function() {
    console.log("삭제 합니다.")
  },
  // 목록
  fnList: function() {
    console.log("목록 으로 이동 합니다.")
  },
  // 수정
  fnEdit: function() {
    console.log("수정 합니다.")
  },
  // 리셋
  fnReset: function() {
    console.log("리셋 합니다.")
  },
  // 상세정보 불러오기
  fnDetail: function(bno) {
    var data = {};
    CommonUtil.fnAjaxCall("/board/"+bno, data, function(data){
      console.log(data);
      $("#writer").val(data.writer);
      $("#password").val(data.password);
      $("#content").val(data.content);
      $("#sex").val(data.sex);
      $("#jobGubun").val(data.jobGubun);
      $("#langGubun").val(data.langGubun);
      //var htmlText = CommonUtil.getHtmlText("job_list_tpl",data);
      //$("#job_div").html(htmlText(data));
    });
  }
}
