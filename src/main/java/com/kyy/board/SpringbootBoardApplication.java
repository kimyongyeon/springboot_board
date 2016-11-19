package com.kyy.board;

import com.kyy.board.board.BoardRepository;
import com.kyy.board.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBoardApplication implements CommandLineRunner {

  @Autowired
  BoardRepository boardRepository;

  @Override
  public void run(String... args) throws Exception {
    BoardVO boardVO = new BoardVO();
    boardVO.setBno(1+"");
    boardVO.setTitle("피해자 신고 ");
    boardVO.setWriter("이진욱");
    boardVO.setPassword("1234");
    boardVO.setSex(true);
    boardVO.setJobGubun("개발자 ");
    boardVO.setLangGubun("자바");
    boardVO.setContent("진정한 사랑이였다.");
    boardVO.setViewCount(1111);
    boardRepository.save(boardVO);

    boardVO = new BoardVO();
    boardVO.setBno(2+"");
    boardVO.setTitle("이대로 해서 정말 될까?");
    boardVO.setWriter("김현중");
    boardVO.setPassword("1234");
    boardVO.setSex(true);
    boardVO.setJobGubun("개발자 ");
    boardVO.setLangGubun("자바");
    boardVO.setContent("군대로 튀었다.");
    boardVO.setViewCount(1113);
    boardRepository.save(boardVO);

    boardVO = new BoardVO();
    boardVO.setBno(3+"");
    boardVO.setTitle("화장실 황제");
    boardVO.setWriter("박유천");
    boardVO.setPassword("1234");
    boardVO.setSex(true);
    boardVO.setJobGubun("개발자 ");
    boardVO.setLangGubun("자바");
    boardVO.setContent("동방신기 끝났어...");
    boardVO.setViewCount(1112);
    boardRepository.save(boardVO);
  }

  public static void main(String[] args) {
		SpringApplication.run(SpringbootBoardApplication.class, args);
	}
}
