package com.lostfinder.tipboard.controller;

import com.lostfinder.tipboard.entity.Tip;
import com.lostfinder.tipboard.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tip/goodtip")
@RequiredArgsConstructor
public class TipController {

    private final TipService tipService;

    @GetMapping
    public ResponseEntity<?> pageGoodTip(int page){
        Page<Tip> tipPage = tipService.findTips(page-1, 6);
        List<Tip> tipList = tipPage.getContent();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{tipId}")
    public ResponseEntity<?>  selectGoodTip(@PathVariable Long tipId){
        Tip tip = tipService.findTip(tipId);
        return new ResponseEntity<>(tip, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?>  createGoodTip(@RequestBody Tip tip ){
        Tip createTip = tipService.createTip(tip);
        return new ResponseEntity<>(createTip ,HttpStatus.OK); //DTO 필요

    }

    @PatchMapping("/{tipId}")
    public ResponseEntity<?>  updateGoodTip(@PathVariable Long tipId, @RequestBody Tip tip){
        Tip updateTip = tipService.updateTip(tipId, tip);
        return new ResponseEntity<>(updateTip, HttpStatus.OK);

    }

    @DeleteMapping("/{tipId}")
    public void deleteGoodTip(@PathVariable Long tipId){
        tipService.deleteTip(tipId);
    }

}
