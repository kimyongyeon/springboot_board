var CommonUtil = {
  init: function() {
    console.log("CommonUtil::init() start");
  },
  fnPageGo: function(idx) {
    if (idx === 0) { // 메인화면
      location.href = "/main";
    } else if(idx === 2) { // 글쓰기
      location.href = "/boardTplCreate";
    } else if(idx === 3) { // 글상세
      location.href = "/boardTplEdit?bno=1";
    } else if(idx === 1) { // 글목록
      location.href = "/boardTplList";
    } else if(idx === 4) { // 페이징
      location.href = "/boardTplPagingList";
    }
  },
  fnAjaxCall: function(url, data, callback, type) {
    $.ajax({
      url: url,
      type: type || 'GET',
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
      data: data,
      success: function(data, textStatus, jqXHR) {
        callback(data);
      },
      xhr: function () {
        console.log("xhr start");
        var xhr = new window.XMLHttpRequest();
        xhr.upload.addEventListener("progress", function (evt) {
          console.log("hide");
          if (evt.lengthComputable) {
            var percentComplete = evt.loaded / evt.total;
            console.log(percentComplete);
            $('.progress').css({
              width: percentComplete * 100 + '%'
            });
            if (percentComplete === 1) {
              $('.progress').addClass('hide');
            }
          }
        }, false);
        xhr.addEventListener("progress", function (evt) {
          if (evt.lengthComputable) {
            var percentComplete = evt.loaded / evt.total;
            console.log(percentComplete);
            $('.progress').css({
              width: percentComplete * 100 + '%'
            });
          } else {
            $('.progress').addClass('hide');
          }
        }, false);
        return xhr;
      },
      error: function(jqXHR, textStatus, errorThrown) {
        if(jqXHR.status === 200) {
          callback(data);
        } else {
          console.log(textStatus);
          console.log(jqXHR);
        }
      },
      statusCode: {
        404: function() {
          alert("[url: " + url + "] page not found");
        }
      }
    });
  },
  fnMenuLiActive: function(s) {
    s = s || 0;
    if(s !== "") {
      $("li").removeClass("active");
      $("ul.nav").find("li:eq("+s+")").addClass("active");
    }
  },
  getHtmlText: function(templateID, data) {
    // Template 취득
    var templateText = $("#" + templateID).html();
    var compiledText = Handlebars.compile(templateText);
    return compiledText;
  },
  // select 목록
  getComboList: function() {
    console.log("CommonUtil::getCommboList() -> /commonJobList call start");
    // 직업 목록
    var data = {};
    CommonUtil.fnAjaxCall("/commonJobList", data, function(data){
      console.log(data);
      var htmlText = CommonUtil.getHtmlText("job_list_tpl",data);
      $("#job_div").html(htmlText(data));
      console.log("CommonUtil::getCommboList() -> /commonJobList call end");
    });

    console.log("CommonUtil::getCommboList() -> /commonLangList call start");
    // 개발언어 목록
    var data = {};
    CommonUtil.fnAjaxCall("/commonLangList", data, function(data){
      console.log(data);
      var htmlText = CommonUtil.getHtmlText("lang_list_tpl",data);
      $("#lang_div").html(htmlText(data));
      console.log("CommonUtil::getCommboList() -> /commonLangList call end");
    });
  }
}
