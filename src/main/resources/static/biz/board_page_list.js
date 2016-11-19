// onCreate, onStart, onResume, Activity 실행, onPause(), onDestory(), Activity 종료
var App = {
  // 사용자 인터페이스 초기화
  onCreate: function(){
    console.log("board_page_list::onCreate start...!!!");
    this.fnBoardList();
    console.log("fnMenuLiActive:1");
    CommonUtil.fnMenuLiActive(1);
    console.log("board_page_list::onCreate end...!!!");
  },
  fnBoardList: function() {
    var data = {};
    CommonUtil.fnAjaxCall("/boardPagingList", data, function(data){
      console.log(data);
      data = data.boardList.content;
      data = {boardList : data};
      console.log(data);
      var htmlText = CommonUtil.getHtmlText("board_list_tpl",data);
      $("#board_list_div").html(htmlText(data));
    });
  },
  fnDetailView: function (bno) {
    location.href = "/boardTplEdit?bno=" + bno;
  }
}
