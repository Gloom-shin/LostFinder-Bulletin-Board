package com.lostfinder.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column
    private String boardType;

    @Column
    private String category;

    @Column
    private String thumbnail;


    @Column
    private String title;

    @Lob
    private String content;

    @Column
    private int commentCount = 0;

    @Column
    private int recommendCount = 0;

    @CreatedDate
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();
}
