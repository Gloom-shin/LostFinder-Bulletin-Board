package com.lostfinder.board.controller;

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
public class TipController {

    private final BoardService boardService;
    private final Board board;    @GetMapping("/{boardType}")
    public ResponseEntity<?> pageGoodTip(@RequestParam int page,
                                         @PathVariable String boardType){
        int defaultPageSize = 6;
        // boardType 검사 필요
        Board.Type verifyType = Board.Type.of(boardType);
        Page<Board> tipPage = boardService.findBoards(page-1, defaultPageSize, verifyType);
        List<Board> tipList = tipPage.getContent();
        return new ResponseEntity<>(tipList, HttpStatus.OK);
    }

    @GetMapping("/{boardType}/{tipId}")
    public ResponseEntity<?>  selectGoodTip(@PathVariable String boardType, @PathVariable Long tipId){
        Board board = boardService.findBoard(tipId);
        return new ResponseEntity<>(board, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?>  createGoodTip(@RequestBody Board board ){
        Board createBoard = boardService.createBoard(board);
        return new ResponseEntity<>(createBoard ,HttpStatus.OK); //DTO 필요

    }

    @PatchMapping("/{tipId}")
    public ResponseEntity<?>  updateGoodTip(@PathVariable Long boardId, @RequestBody Board board){
        Board updateBoard = boardService.updateBoard(boardId, board);
        return new ResponseEntity<>(updateBoard, HttpStatus.OK);

    }

    @DeleteMapping("/{tipId}")
    public void deleteGoodTip(@PathVariable Long tipId){
        boardService.deleteBoard(tipId);
    }

}
