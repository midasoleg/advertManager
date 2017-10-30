package com.advertManager.controller;

import com.advertManager.entity.Advert;
import com.advertManager.service.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("user")
public class AdvertController {

    @Autowired
    private IAdvertService advertService;

    @GetMapping("adverts")
    public ResponseEntity<List<Advert>> getAllAdverts() {
        List<Advert> list = advertService.getAllAdverts();
        return new ResponseEntity<List<Advert>>(list,HttpStatus.OK);
    }

    @GetMapping("advert/{id}")
    public ResponseEntity<Advert> getAdvertById(@PathVariable("id") Long id){
        Advert advert = advertService.getAdvertById(id);
        return new ResponseEntity<Advert>(advert, HttpStatus.OK);
    }

    @PostMapping("advert")
    public ResponseEntity<Void> addAdvert(@RequestBody Advert advert, UriComponentsBuilder builder){
        boolean flag = advertService.createAdvert(advert);

        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/advert/{id}").buildAndExpand(advert.getAdvertId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("advert")
    public ResponseEntity<Advert> updateAdvert(@RequestBody Advert advert){
        advertService.updateAdvert(advert);
        return new ResponseEntity<Advert>(advert, HttpStatus.OK);
    }

    @DeleteMapping("advert/{id}")
    public ResponseEntity<Void> deleteAdvert(@PathVariable("id") Long id) {
        advertService.deleteAdvert(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
