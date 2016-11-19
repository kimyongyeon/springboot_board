package com.kyy.board.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongyeonkim on 2016. 8. 21..
 */
@RestController
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    /**
     * 게시판 쓰기
     * post로 데이터를 받을때는 화면에서는 JSON.stringify를 감싸야 하고,
     * 서버에서는 RequestBody로 받아야 한다.
     * ResponseEntity 리턴시 상태값은 200 정상이나 에러가 나기 때문에 error 문법에서 후처리 해야 줘야 함.
     * 원인 분석중...
     * @param boardVO
     */
    @RequestMapping(value = "/boardCreate"
      , method = RequestMethod.POST
      , headers = HttpHeaders.ACCEPT + "=" + MediaType.APPLICATION_JSON_UTF8_VALUE
      , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> postCreate(@RequestBody BoardVO boardVO) {
      ResponseEntity<String> entity = null;
      try{
        boardRepository.save(boardVO);
        entity = new ResponseEntity<String>("Success", HttpStatus.OK);
      } catch (Exception e){
        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
      return entity;
    }

    /**
     * 게시판 목록보기
     * @return
     */
    @RequestMapping(value = "/boardList", method = RequestMethod.GET)
    public Map getList() {
      Map outMap = new HashMap();
      outMap.put("boardList", boardRepository.findAll());
      return outMap;
    }

   /**
    * 게시판 페이징 목록보기
    * @param pageable
    * @return
    */
    @RequestMapping(value = "/boardPagingList", method = RequestMethod.GET)
    public Map getPagingList(
      @PageableDefault(sort = { "bno" }, direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
      Map outMap = new HashMap();
//      Pageable pageable = new PageRequest(0, 10);
      outMap.put("boardList", boardRepository.findAll(pageable));
      return outMap;
    }


    /**
     * 게시판 상세보기
     * @param id
     * @return
     */
    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public BoardVO getList(@PathVariable(value = "id") String id) {
        return boardRepository.findOne(id);
    }

    /**
     * 게시판 수정
     * @param boardVO
     */
    @RequestMapping(value = "/boardEdit"
      , method = RequestMethod.PUT
      , headers = HttpHeaders.ACCEPT + "=" + MediaType.APPLICATION_JSON_UTF8_VALUE
      , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> putEdit(@ModelAttribute("boardVO") BoardVO boardVO) {
      ResponseEntity<String> entity = null;
      try{
        boardRepository.save(boardVO);
        entity = new ResponseEntity<String>("Success", HttpStatus.OK);
      } catch (Exception e){
        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
      return entity;
    }

    /**
     * 게시판 삭제
     * @param boardVO
     */
    @RequestMapping(value = "/boardDel"
      , method = RequestMethod.PUT
      , headers = HttpHeaders.ACCEPT + "=" + MediaType.APPLICATION_JSON_UTF8_VALUE
      , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> deleteDel(@ModelAttribute("boardVO") BoardVO boardVO) {
      ResponseEntity<String> entity = null;
      try{
        boardRepository.delete(boardVO);
        entity = new ResponseEntity<String>("Success", HttpStatus.OK);
      } catch (Exception e){
        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
      return entity;
    }
}
