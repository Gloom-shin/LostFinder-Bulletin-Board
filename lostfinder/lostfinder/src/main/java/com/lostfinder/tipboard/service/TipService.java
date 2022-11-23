package com.lostfinder.tipboard.service;

import com.lostfinder.tipboard.entity.Tip;
import com.lostfinder.tipboard.repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipService {

    private final TipRepository tipRepository;

    public Tip createTip(Tip tip){
        Tip save = tipRepository.save(tip);

        LocalDateTime createAt = save.getCreateAt();
        System.out.println("createAt = " + createAt);
        return save;
    }


    public Tip findTip(Long id){
        Tip verifiedTip = findVerifiedTip(id);

        return verifiedTip;
    }


    public Tip findVerifiedTip(Long id){
        Optional<Tip> findTip = tipRepository.findById(id);
        return findTip.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    }
}
