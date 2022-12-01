package com.lostfinder.tipboard.controller;

import com.lostfinder.tipboard.entity.Tip;
import com.lostfinder.tipboard.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tip/goodtip")
@RequiredArgsConstructor
public class TipController {

    private final TipService tipService;

    @GetMapping
    public String pageGoodTip(int page,  Model model){
        Page<Tip> tipPage = tipService.findTips(page-1, 6);
        List<Tip> tipList = tipPage.getContent();
        model.addAttribute("tipList",tipList);
        return "tip/goodtip";
    }

    @GetMapping("/{tipId}")
    public String selectGoodTip(@PathVariable Long tipId, Model model){
        Tip tip = tipService.findTip(tipId);
        model.addAttribute("tip", tip);
        return "tip/tip-details";
    }
    @PostMapping
    public String createGoodTip(@RequestBody Tip tip , Model model){
        Tip createTip = tipService.createTip(tip);

        model.addAttribute("tip", createTip);
        return "tip/tip-details";
    }

    @PatchMapping("/{tipId}")
    public String updateGoodTip(@PathVariable Long tipId, @RequestBody Tip tip, Model model){
        Tip updateTip = tipService.updateTip(tipId, tip);
        model.addAttribute("updateTip", updateTip);
        return "tip/tip-details";
    }

    @DeleteMapping("/{tipId}")
    public void deleteGoodTip(@PathVariable Long tipId){
        tipService.deleteTip(tipId);
    }

}
