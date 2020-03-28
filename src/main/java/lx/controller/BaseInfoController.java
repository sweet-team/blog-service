package lx.controller;

import lx.domain.BaseInfo;
import lx.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseInfoController {

    @Autowired
    private BaseInfoService baseInfoService;

    @GetMapping("/about")
    public ResponseEntity<BaseInfo> baseInfo(){
        BaseInfo baseInfo = this.baseInfoService.getBaseInfo();
        return ResponseEntity.ok(baseInfo);
    }
    @PostMapping("/about")
    public ResponseEntity<Long> createBaseInfo(@RequestBody BaseInfo baseInfo){
        Long baseInfoId = this.baseInfoService.createBaseInfo(baseInfo);
        return ResponseEntity.ok(baseInfoId);
    }
    @PutMapping("/about")
    public ResponseEntity<Long> changeBaseInfo(@RequestBody BaseInfo baseInfo){
        Long aLong = this.baseInfoService.changeBaseInfo(baseInfo);
        return ResponseEntity.ok(aLong);
    }

}
