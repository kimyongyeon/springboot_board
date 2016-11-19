package com.kyy.board.controller;


import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import lombok.Data;
import org.springframework.web.servlet.view.document.AbstractJExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yongyeonkim on 2016. 9. 2..
 */

public class ExcelDownloadView extends AbstractJExcelView {

  @Data
  class BoardDTO {
    private String article_num;
    private String id;
    private String title;
    private String content;
    private String hit;
    private String group_id;
    private String pos;
    private String depth;
    private String write_date;
  }

  @Override
  protected void buildExcelDocument(Map<String, Object> model, WritableWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<BoardDTO> list = new ArrayList<>();

    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setTitle("바보");
    list.add(boardDTO);

    String fileName = "excel.xls";

    response.setHeader("Content-Disposition", "attachement; filename=\""+ java.net.URLEncoder.encode(fileName, "UTF-8") + "\";charset=\"UTF-8\"");

    makeExcelFile(workbook, list);
  }

  private void makeExcelFile(WritableWorkbook workbook, List<BoardDTO> list)
    throws RowsExceededException, WriteException {

    // 시트 생성( 시트명, 인덱스 )
    WritableSheet ws = workbook.createSheet("게시물 목록", 0);

    setExcelTitle(ws);
    setExcelContent(ws, list);
  }

  private void setExcelContent(WritableSheet ws, List<BoardDTO> list)
    throws RowsExceededException, WriteException {
    for (int i = 1; i < list.size()+1; i++) {
      ws.addCell((new Label(0, i, list.get(i-1).getArticle_num()+"")));
      ws.addCell((new Label(1, i, list.get(i-1).getId()+"")));
      ws.addCell((new Label(2, i, list.get(i-1).getTitle()+"")));
      ws.addCell((new Label(3, i, list.get(i-1).getContent()+"")));
      ws.addCell((new Label(4, i, list.get(i-1).getHit()+"")));
      ws.addCell((new Label(5, i, list.get(i-1).getGroup_id()+"")));
      ws.addCell((new Label(6, i, list.get(i-1).getPos()+"")));
      ws.addCell((new Label(7, i, list.get(i-1).getDepth()+"")));
      ws.addCell((new Label(8, i, list.get(i-1).getWrite_date()+"")));
    }
  }

  private void setExcelTitle(WritableSheet ws) throws RowsExceededException,
    WriteException {
    ws.addCell((new Label(0, 0, "번호")));
    ws.addCell((new Label(1, 0, "작성자")));
    ws.addCell((new Label(2, 0, "제목")));
    ws.addCell((new Label(3, 0, "내용")));
    ws.addCell((new Label(4, 0, "조회수")));
    ws.addCell((new Label(5, 0, "그룹")));
    ws.addCell((new Label(6, 0, "포지션")));
    ws.addCell((new Label(7, 0, "하위도")));
    ws.addCell((new Label(8, 0, "작성일지")));
  }
}
