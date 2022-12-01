package com.lostfinder.tipboard.service;

import com.lostfinder.tipboard.entity.Tip;
import com.lostfinder.tipboard.repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
    public Page<Tip> findTips(int page, int size){
        return tipRepository.findAll(PageRequest.of(page, size));
    }



    public Tip updateTip(Long id, Tip editTip){
        Tip verifiedTip = findVerifiedTip(id);

        if(editTip.getTitle() != null){
            verifiedTip.setTitle(editTip.getTitle());
        }
        if(editTip.getContent() != null){
            verifiedTip.setContent(editTip.getContent());
        }

        return tipRepository.save(verifiedTip);
    }


    public void deleteTip(Long id){
        Tip verifiedTip = findVerifiedTip(id);
        tipRepository.delete(verifiedTip);
        System.out.println("게시글이 삭제되었습니다.");
    }

    public Tip findVerifiedTip(Long id){
        Optional<Tip> findTip = tipRepository.findById(id);
        return findTip.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시물입니다."));

    }
}
