package com.kyy.board.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yongyeonkim on 2016. 8. 21..
 */
@RestController
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    /**
     * 게시판 쓰기
     * @param boardVO
     */
    @RequestMapping(value = "/boardCreate", method = RequestMethod.POST)
    public void postCreate(@ModelAttribute("boardVO") BoardVO boardVO) {
        boardRepository.save(boardVO);
    }

    /**
     * 게시판 목록보기
     * @return
     */
    @RequestMapping(value = "/boardList", method = RequestMethod.GET)
    public List getList() {
        return boardRepository.findAll();
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
    @RequestMapping(value = "/boardEdit", method = RequestMethod.PUT)
    public void putEdit(@ModelAttribute("boardVO") BoardVO boardVO) {
        boardRepository.save(boardVO);
    }

    /**
     * 게시판 삭제
     * @param boardVO
     */
    @RequestMapping(value = "/boardDel", method = RequestMethod.DELETE)
    public void deleteDel(@ModelAttribute("boardVO") BoardVO boardVO) {
        boardRepository.delete(boardVO);
    }
}
