package com.lostfinder.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class BoardResponseDto {

    @Getter
    @Setter
    public static class Detail{
        private String thumbnail;
        private String title;
        private String nickName;
        private String category;
        private LocalDateTime createdAt;
        private int commentCount;
        private int recommendCount;
        private String Content;
    }

    @Getter
    @Setter
    public static class ThePagePosts{
        private String thumbnail;
        private String title;
        private String nickName;
        private String category;
        private LocalDateTime createdAt;
    }
}
