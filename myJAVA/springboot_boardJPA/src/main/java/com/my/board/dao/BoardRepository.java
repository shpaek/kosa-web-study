package com.my.board.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.board.entity.BoardEntity;
import com.my.exception.FindException;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	/**
	 * 게시글 목록을 검색한다
	 * @return 게시글 목록
	 * @throws FindException
	 */
	@Query(value="SELECT b.*,\r\n"
			+ "		(SELECT COUNT(*) FROM board_reply2 WHERE reply_board_no=b.board_no)replycnt\r\n"
			+ "		FROM board2 b\r\n"
			+ "		ORDER BY board_no DESC", nativeQuery = true)
	public List<BoardEntity> selectAll() throws FindException;
	
	/**
	 * 게시글 상세정보를 검색한다
	 * @param boardNo 게시글 번호
	 * @return 게시글 상세정보
	 * @throws FindException
	 */
	@Query(value="SELECT *\r\n"
			+ "		FROM board2 b LEFT JOIN\r\n"
			+ "		(SELECT level, r1.* FROM\r\n"
			+ "		board_reply2 r1 START WITH reply_parent_no IS NULL\r\n"
			+ "		CONNECT BY PRIOR\r\n"
			+ "		reply_no = reply_parent_no\r\n"
			+ "		ORDER SIBLINGS BY reply_no DESC)r\r\n"
			+ "		ON\r\n"
			+ "		b.board_no = r.reply_board_no\r\n"
			+ "		WHERE board_no = :boardNo", nativeQuery = true)
	public List<Object[]> selectByBoardNo(int boardNo) throws FindException;
	
	
}