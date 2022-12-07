package com.lostfinder.board.dto.mapper;

import com.lostfinder.board.dto.BoardRequestDto;
import com.lostfinder.board.dto.BoardResponseDto;
import com.lostfinder.board.entity.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") //스프링에서 사용하기 위해 설정
public interface BoardMapper {
    Board createdBoardToBoard(BoardRequestDto.Create createBoard);
    Board updateBoardToBoard(BoardRequestDto.Update updateBoard);

    BoardResponseDto.Detail BoardToDetailBoard(Board board);

    List<BoardResponseDto.ThePagePosts> BoardListToBoardPage(List<Board> boards);

}
