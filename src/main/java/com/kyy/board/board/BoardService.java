package com.kyy.board.board;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yongyeonkim on 2016. 8. 16..
 */
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List boardWrite(BoardVO boardVO) {
        boardRepository.save(boardVO);
        return boardRepository.findAll();
    }

    public BoardVO loadUserByUserName(String title) {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        return boardVO;
    }
}
