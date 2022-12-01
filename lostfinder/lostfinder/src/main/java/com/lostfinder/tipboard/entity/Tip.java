package com.lostfinder.tipboard.entity;

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
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipId;

    @Column
    private String title;

    @Column
    private String writer;

    @Column
    private String content;

    @Column
    private int commentCount = 0;

    @CreatedDate
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();
}
