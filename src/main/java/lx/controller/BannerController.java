package lx.controller;

import lx.domain.Banner;
import lx.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("/banner")
    public ResponseEntity<List<Banner>> getBanner(){
        List<Banner> banners= this.bannerService.getBanner();
        return ResponseEntity.ok(banners);
    }
    @GetMapping("/banner{id}")
    public ResponseEntity<Banner> getBannerById(Long id){
        Banner banner= this.bannerService.getBannerById(id);
        return ResponseEntity.ok(banner);
    }
}
