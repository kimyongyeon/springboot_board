package com.kyy.board.controller;

import com.kyy.board.vo.CommonVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongyeonkim on 2016. 8. 22..
 */
@RestController
public class CommonRestController {

  @RequestMapping(value = "/excelDownload")
  public View getExcelDownload() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("excelDownload");
    return new ExcelDownloadView();
  }

  /**
   * 직업 목록
   * @return
     */
  @RequestMapping(value = "/commonJobList")
  public Map getCommonJobList() {

    Map map = new HashMap();
    List list = new ArrayList();

    CommonVO commonVO = new CommonVO();
    commonVO.setCode("1");
    commonVO.setCodeNm("서버개발자");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("2");
    commonVO.setCodeNm("프론트개발자");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("3");
    commonVO.setCodeNm("서버관리자");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("4");
    commonVO.setCodeNm("DB관리자");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("5");
    commonVO.setCodeNm("만능관리자");
    list.add(commonVO);

    map.put("jobList", list);

    return map;
  }

  /**
   * 언어 목록
   * @return
     */
  @RequestMapping(value = "/commonLangList")
  public Map getCommonLangList() {

    Map map = new HashMap();
    List list = new ArrayList();

    CommonVO commonVO = new CommonVO();
    commonVO.setCode("1");
    commonVO.setCodeNm("자바");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("2");
    commonVO.setCodeNm("C#");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("3");
    commonVO.setCodeNm("Javascript");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("4");
    commonVO.setCodeNm("Scala");
    list.add(commonVO);
    commonVO = new CommonVO();
    commonVO.setCode("5");
    commonVO.setCodeNm("Angularjs");
    list.add(commonVO);

    map.put("langList", list);

    return map;
  }
}
