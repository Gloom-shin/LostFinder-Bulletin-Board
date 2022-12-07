package com.lostfinder.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class BoardRequestDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private String boardType;
        private String category;
        private String thumbnail;
        private String title;
        private String content;

        // 작성자의 경우 principal 로 확인
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        private String boardType;
        private String category;
        private String thumbnail;
        private String title;
        private String content;
        // 작성자의 경우 principal 로 확인
    }
}
