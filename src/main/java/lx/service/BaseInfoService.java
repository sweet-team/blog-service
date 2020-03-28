package lx.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.effect.Bloom;
import lx.domain.BaseInfo;
import lx.repository.BaseInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class BaseInfoService {

    @Autowired
    private BaseInfoRepository baseInfoRepository;

    public BaseInfo getBaseInfo(){
        Iterable<BaseInfo> all = baseInfoRepository.findAll();
        BaseInfo temp=null;
        for (BaseInfo b :
                all) {
            temp=b;
        }
        return temp;
    }
    public Long changeBaseInfo(BaseInfo baseInfo){
        Optional<BaseInfo> byId = this.baseInfoRepository.findById(baseInfo.getId());
        if(!byId.isPresent()){
            return null;
        }
        BaseInfo baseInfo1 = byId.get();
        BeanUtils.copyProperties(baseInfo,baseInfo1);
        BaseInfo save = this.baseInfoRepository.save(baseInfo1);
        return save.getId();
    }
    public Long createBaseInfo(BaseInfo baseInfo){
        BaseInfo save = this.baseInfoRepository.save(baseInfo);
        Long id = save.getId();
        return id;
    }
}
