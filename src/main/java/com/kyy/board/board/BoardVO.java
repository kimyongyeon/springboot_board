package com.kyy.board.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by yongyeonkim on 2016. 8. 16..
 */
@Entity // jpa entity
@Table(name = "tb_board") // 테이블명
@Data // setter / getter
@AllArgsConstructor // 인자가 모두 있는 생성자
@NoArgsConstructor // 인자없는 기본 생성자
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bno; // 게시판번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수

}
