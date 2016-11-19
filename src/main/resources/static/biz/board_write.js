// onCreate, onStart, onResume, Activity 실행, onPause(), onDestory(), Activity 종료
var App = {
  // 사용자 인터페이스 초기화
  onCreate: function(){
    console.log("board_write::onCreate start...!!!");
    console.log("fnMenuLiActive:2");
    CommonUtil.fnMenuLiActive(2);
    CommonUtil.getComboList();
    console.log("board_write::onCreate end...!!!");
  },
  // 글쓰기
  fnWrite: function() {
    var data = {
      writer: $("#writer").val(),
      title: $("#title").val(),
      password: $("#password").val(),
      content: $("#content").val(),
      sex: $("#sex").val(),
      jobGubun: $("#jobGubun").val(),
      langGubun: $("#langGubun").val(),
    };
    CommonUtil.fnAjaxCall("/boardCreate", JSON.stringify(data), function(data){
        CommonUtil.fnPageGo(1); // list 화면으로 이동한다.
    }, "post");
  }
}
