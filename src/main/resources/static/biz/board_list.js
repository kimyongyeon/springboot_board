// onCreate, onStart, onResume, Activity 실행, onPause(), onDestory(), Activity 종료
var App = {
  // 사용자 인터페이스 초기화
  onCreate: function(){
    this.fnBoardList();
    CommonUtil.fnMenuLiActive(0);
  },
  fnBoardList: function() {
    var data = {};
    // var data = [];
    // for (var i = 0; i < 100000; i++) {
    //   var tmp = [];
    //   for (var i = 0; i < 100000; i++) {
    //     tmp[i] = 'hue';
    //   }
    //   data[i] = tmp;
    // };
    // xdata.data = data;
    CommonUtil.fnAjaxCall("/boardList", data, function(data){
      var htmlText = CommonUtil.getHtmlText("board_list_tpl",data);
      $("#board_list_div").html(htmlText(data));
    });
  },
  fnDetailView: function (bno) {
    location.href = "/boardTplEdit?bno=" + bno;
  }
}
