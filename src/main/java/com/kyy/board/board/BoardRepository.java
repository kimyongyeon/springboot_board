package com.kyy.board.board;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yongyeonkim on 2016. 8. 16..
 */
public interface BoardRepository extends JpaRepository<BoardVO, String>{
}
