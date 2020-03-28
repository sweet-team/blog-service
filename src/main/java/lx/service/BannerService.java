package lx.service;

import lx.domain.Banner;
import lx.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    public List<Banner> getBanner() {
        Iterable<Banner> all = bannerRepository.findAll();
        ArrayList<Banner> banners = new ArrayList<>();
        all.forEach(x ->{banners.add(x);});
        return banners;
    }

    public Banner getBannerById(Long id) {
        Optional<Banner> byId = bannerRepository.findById(id);
        return byId.get();
    }
}
