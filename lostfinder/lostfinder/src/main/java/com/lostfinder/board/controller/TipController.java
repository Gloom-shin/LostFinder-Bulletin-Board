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
@RequestMapping("/board/tip")
@RequiredArgsConstructor
public class TipController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<?> pageGoodTip(int page){
        Page<Board> tipPage = boardService.findBoards(page-1, 6);
        List<Board> tipList = tipPage.getContent();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{tipId}")
    public ResponseEntity<?>  selectGoodTip(@PathVariable Long tipId){
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
