package com.lostfinder.tipboard.controller;

import com.lostfinder.tipboard.entity.Tip;
import com.lostfinder.tipboard.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tip/goodtip")
@RequiredArgsConstructor
public class TipController {

    private final TipService tipService;

    @GetMapping
    public String selectGoodTip(Model model){
        Tip tip = tipService.findTip(1L);
        model.addAttribute("tip", tip);
        return "tip/goodtip";
    }
    @PostMapping
    public String createGoodTip(@RequestBody Tip tip , Model model){
        Tip tip1 = tipService.createTip(tip);

        model.addAttribute("tip", tip1);
        return "tip/tip-details";
    }

}
