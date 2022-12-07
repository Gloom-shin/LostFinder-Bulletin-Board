package com.lostfinder.board.entity;

import lombok.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

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
    private BoardType boardType;

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
    private LocalDateTime createdAt = LocalDateTime.now();


    public enum BoardType{
        tip, community;
        public static BoardType of(String type){
            return Arrays.stream(BoardType.values())
                    .filter(s -> s.name().equals(type))
                    .findAny()
                    .orElseThrow();
        }
    }

}

