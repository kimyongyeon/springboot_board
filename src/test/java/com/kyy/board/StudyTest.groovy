package com.kyy.board

import com.kyy.board.board.BoardRepository
import com.kyy.board.board.BoardService
import com.kyy.board.board.BoardVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
/**
 * Created by yongyeonkim on 2016. 8. 16..
 */
@ContextConfiguration
@DataJpaTest
class StudyTest extends Specification {

    @Autowired
    BoardRepository boardRepository

    @Autowired
    TestEntityManager testEntityManager

    def "실제로 프로세스 맞는지"() {
        given:
        boardRepository.save(new BoardVO(title: "나는 누구인가..."))
        when:
        def list = boardRepository.findAll()
        then:
        list.first().title == "나는 누구인가..."
    }

    // persist : 추가
    // merge : 수정
    def "하나의 글을 작성합니다 "() {
        given:

        // 추가
        def board = new BoardVO()
        board.setTitle("하나의 글")
        board.setContent("하나의내용")
        testEntityManager.persist(board)

        // 수정
        board.setBno("1")
        board.setTitle("수정...")
        testEntityManager.merge(board)

        // 삭제
//        board.setBno("1")
//        testEntityManager.remove(board)

        when:
        def e = boardRepository.findAll()

        then:
        e.first().title == board.title
        println e.first().bno
    }

    def "하나의 글만 가져오는 함수를 테스트해본다"() {
        given:
        def title = "test title"
        def board = new BoardVO()
        board.setTitle(title)

        def boardRepository = Mock(BoardRepository.class)
        def service = new BoardService(boardRepository)

        when:
        def userDetails = service.loadUserByUserName(title)

        then:
        // 가짜 repo의 findOne 호출 null 반환 되도록 인터렉션 작성
        boardRepository.findOne(1) >> null
        // 그때 발생한 예외가 무엇인지 확인
        def e = thrown(Exception.class)
        e.message == "dd"
    }


}
