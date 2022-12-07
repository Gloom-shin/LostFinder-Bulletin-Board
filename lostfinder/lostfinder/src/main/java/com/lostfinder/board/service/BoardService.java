package com.lostfinder.board.service;

import com.lostfinder.board.entity.Board;
import com.lostfinder.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(Board board, Board.BoardType type){
        board.setBoardType(type);
        Board save = boardRepository.save(board);
        LocalDateTime createAt = save.getCreateAt();
        System.out.println("createAt = " + createAt);
        return save;
    }


    public Board findBoard(Long id){
        Board verifiedTip = findVerifiedBoard(id);

        return verifiedTip;
    }
    public Page<Board> findBoards(int page, int size, Board.BoardType verifyType){
        return boardRepository.findByBoardType(verifyType, PageRequest.of(page, size));
    }



    public Board updateBoard(Long id, Board editBoard){
        Board verifiedBoard = findVerifiedBoard(id);

        if(editBoard.getTitle() != null){
            verifiedBoard.setTitle(editBoard.getTitle());
        }
        if(editBoard.getContent() != null){
            verifiedBoard.setContent(editBoard.getContent());
        }

        return boardRepository.save(verifiedBoard);
    }


    public void deleteBoard(Long id){
        Board verifiedTip = findVerifiedBoard(id);
        boardRepository.delete(verifiedTip);
        System.out.println("게시글이 삭제되었습니다.");
    }

    public Board findVerifiedBoard(Long id){
        Optional<Board> findBoard = boardRepository.findById(id);
        return findBoard.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    }
}
