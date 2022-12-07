package com.lostfinder.board.controller;

import com.lostfinder.board.dto.BoardRequestDto;
import com.lostfinder.board.dto.mapper.BoardMapper;
import com.lostfinder.board.entity.Board;
import com.lostfinder.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper mapper;
    @PostMapping("/{boardType}")
    public ResponseEntity<?>  createGoodTip(@RequestBody BoardRequestDto.Create createBoard,
                                            @PathVariable String boardType){
        // boardType 검사 필요
        Board.BoardType verifyType = Board.BoardType.of(boardType);
        Board board = mapper.createdBoardToBoard(createBoard);
        Board saveBoard = boardService.createBoard(board, verifyType);
        return new ResponseEntity<>(saveBoard ,HttpStatus.OK); //DTO 필요

    }
    @PatchMapping("/{boardType}/{boardId}")
    public ResponseEntity<?>  updateGoodTip(@RequestBody BoardRequestDto.Update updateBoard,
                                            @PathVariable String boardType,
                                            @PathVariable Long boardId){
        // boardType 검사만 필요, id만 있어도 어떤 게시글인지 알 수 있기 때문에
        Board.BoardType.of(boardType);
        Board board = mapper.updateBoardToBoard(updateBoard);
        Board saveBoard = boardService.updateBoard(boardId, board);
        return new ResponseEntity<>(saveBoard, HttpStatus.OK);

    }

    @GetMapping("/{boardType}")
    public ResponseEntity<?> pageGoodTip(@RequestParam int page,
                                         @PathVariable String boardType){
        int defaultPageSize = 6;
        // boardType 검사 필요
        Board.BoardType verifyType = Board.BoardType.of(boardType);
        Page<Board> tipPage = boardService.findBoards(page-1, defaultPageSize, verifyType);
        List<Board> tipList = tipPage.getContent();
        return new ResponseEntity<>(tipList, HttpStatus.OK);
    }

    @GetMapping("/{boardType}/{boardId}")
    public ResponseEntity<?>  selectGoodTip(@PathVariable Long boardId){
        Board board = boardService.findBoard(boardId);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public void deleteGoodTip(@PathVariable Long boardId){
        boardService.deleteBoard(boardId);
    }

}
