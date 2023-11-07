package com.my.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.board.entity.ReplyEntity;
import com.my.exception.FindException;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

	@Query(value="SELECT *\r\n"
			+ "		FROM board_reply2 \r\n"
			+ "		WHERE reply_no = :replyNo", nativeQuery = true)
	public ReplyEntity selectByReplyNo(int replyNo) throws FindException;

}