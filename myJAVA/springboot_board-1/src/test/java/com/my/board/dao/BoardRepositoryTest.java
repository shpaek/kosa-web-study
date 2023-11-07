package com.my.board.dao;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.my.board.dto.Board;
import com.my.board.dto.Reply;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

@SpringBootTest
class BoardRepositoryTest {
	@Autowired
	BoardOracleRepository repository;
	@Test
	@DisplayName("게시글 전체 검색 테스트")
	@Transactional
	void testSelectAll() throws FindException {
		List<Board> list = repository.selectAll();
		int expectedSize = 3;
		Assertions.assertEquals(expectedSize, list.size());
	}

	@Test
	@DisplayName("게시글번호 1번의 상세조회")
	@Transactional
	void testSelectByBoardNo() throws FindException	{
		int boardNo = 1;
		Board board = repository.selectByBoardNo(boardNo);
		String expectedTitle = "제목1";
		int expectedReplySize = 4;
		Assertions.assertEquals(expectedTitle, board.getBoardTitle());
		Assertions.assertEquals(expectedReplySize, board.getReplies().size());
	}

	@Test
	@DisplayName("존재하지 않는 게시글번호로 상세조회")
	@Transactional
	void testSelectByBoardNo2() throws FindException {
		int boardNo = 0;
		Board board = repository.selectByBoardNo(boardNo);
		Assertions.assertNull(board);


		Assertions.assertThrows(FindException.class, ()->{
			repository.selectByBoardNoOptional(boardNo);
		});
	}

	@Test
	@DisplayName("게시글 작성")
	@Transactional
	void testWriteBoard() throws AddException {
		Board b = new Board();
		b.setBoardTitle("테스트2");
		b.setBoardContent("테스트게시글2");
		b.setBoardId("A");
		repository.insertBoard(b);

		List<Board> list;
		try {
			list = repository.selectAll();
			boolean flag = false;
			for(Board b1: list) {
				if(b1.getBoardTitle().equals(b.getBoardTitle())
						&& b1.getBoardContent().equals(b.getBoardContent())) {
					flag = true;
					break;
				}
			}
			Assertions.assertTrue(flag);
		} catch (FindException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("게시글 수정")
	@Transactional
	void testUpdateBoard() throws ModifyException {
		int boardNo = 5;
		String boardId = "010";

		Board b = new Board();
		b.setBoardNo(boardNo);
		b.setBoardContent("수정게시글");
		b.setBoardId(boardId);

		List<Board> list;
		try {
			list = repository.selectAll();
			boolean flag = false;
			for(Board b1: list) {
				if(b1.getBoardNo()==boardNo && b1.getBoardId().equals(boardId)) {
					repository.updateBoard(b);
					try {
						list = repository.selectAll();
						if(b1.getBoardContent().equals(b.getBoardContent())) {
							flag = true;
							break;
						}
					} catch (FindException e) {
						e.printStackTrace();
					}
				}
			}Assertions.assertTrue(flag);
		} catch (FindException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("게시글 삭제")
	@Transactional
	void testDeleteBoard() throws RemoveException {
		int boardNo = 7;
		String boardId = "A";

		try {
			List<Board> list = repository.selectAll();
			boolean flag = false;
			for(Board b1: list) {
				if(b1.getBoardNo()==boardNo && b1.getBoardId().equals(boardId)) {
					repository.deleteBoard(boardNo);
					for(Board b2: list) {
						if(b2.getBoardNo()!=boardNo) {
							flag = true;
							break;
						}
					}
				}
			}
			Assertions.assertTrue(flag);
		} catch (FindException e) {
			e.printStackTrace();
		}
	}


	@Test
	@DisplayName("답글 작성")
	@Transactional
	void testWriteReply() throws AddException {
		Reply r = new Reply();
		r.setReplyBoardNo(1);
		r.setReplyContent("테스트답글입니다5");
		r.setReplyId("B");
		//		r.setReplyParentNo(null);
		r.setReplyParentNo(2);
		repository.insertReply(r);

		Board b;
		try {
			b = repository.selectByBoardNo(r.getReplyBoardNo());
			List<Reply> replyList = b.getReplies();
			boolean flag = false;
			for(Reply r1: replyList) {
				if(r1.getReplyContent().equals(r.getReplyContent())
						&& r1.getReplyId().equals(r.getReplyId())) {
					flag = true;
					break;
				}
			}
			Assertions.assertTrue(flag);
		} catch (FindException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("답글 수정")
	@Transactional
	void testModifyReply() throws ModifyException {
		Reply r = new Reply();
		r.setReplyNo(6);
		r.setReplyContent("테스트답글수정");

		int replyBoardNo = 1;
		String replyId = "B";

		Board b;
		try {
			b = repository.selectByBoardNo(replyBoardNo);
			List<Reply> replyList = b.getReplies();
			boolean flag = false;
			for(Reply r1: replyList) {
				if(r1.getReplyNo()==r.getReplyNo() && r1.getReplyId().equals(replyId)) {
					repository.updateReply(r);
					if(r1.getReplyContent().equals(r.getReplyContent())) {
						flag = true;
						break;
					}
				}
			}
			Assertions.assertTrue(flag);
		} catch (FindException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("답글 삭제")
	@Transactional
	void testRemoveReply() throws RemoveException {
		int replyNo = 14;
		String replyId = "010";
		int replyBoardNo = 1;

		try {
			Board b = repository.selectByBoardNo(replyBoardNo);
			List<Reply> replyList = b.getReplies();
			boolean flag = false;
			for(Reply r1: replyList) {
				if(r1.getReplyNo()==replyNo && r1.getReplyId().equals(replyId)) {
					repository.deleteReply(replyNo);
					for(Reply r2: replyList) {
						if(r2.getReplyNo()!=replyNo){
							flag = true;
							break;
						}
					}
				}
			}
			Assertions.assertTrue(flag);
		} catch (FindException e) {
			e.printStackTrace();
		}

	}

}
