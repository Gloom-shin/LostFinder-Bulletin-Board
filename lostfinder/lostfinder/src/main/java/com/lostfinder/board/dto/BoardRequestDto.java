package com.lostfinder.board.dto;

import com.lostfinder.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class BoardRequestDto {

    @Getter
    @Setter
    public static class Create{
        private String boardType;
        private String category;
        private String thumbnail;
        private String title;
        private String content;

        // 작성자의 경우 principal 로 확인

        public Board.BoardCategory getCategory() {
            return Board.BoardCategory.of(category); // 검증
        }
    }

    @Getter
    @Setter
    public static class Update{
        private String boardType;
        private String category;
        private String thumbnail;
        private String title;
        private String content;
        // 작성자의 경우 principal 로 확인

        public Board.BoardCategory getCategory() {
            return Board.BoardCategory.of(category); // 검증
        }
    }
}
