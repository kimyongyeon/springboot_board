package com.kyy.board;

import com.kyy.board.board.BoardRepository;
import com.kyy.board.board.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBoardApplicationTests {

	@Autowired
	BoardRepository boardRepository;

	@Test
	public void boardWrite() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("야호 ");
		boardRepository.save(boardVO);
		boardRepository.findAll().forEach(i-> System.out.println(i.getTitle()));
	}

	@Test
	public void contextLoads() {
		RequestDataController controller = new RequestDataController();
		String result = controller.withParam("keesun");
		assertThat(result, is("Obtained 'foo' query parameter value 'keesun'"));
	}



}
