package com.lostfinder.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto {
    private List<?> pageList;

    private PageInfo pageInfo;

    public MultiResponseDto(List<?> pageList, Page page) {
        this.pageList = pageList;
        this.pageInfo = new PageInfo(page.getNumber() +1, page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
