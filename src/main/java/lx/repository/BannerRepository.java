package lx.repository;

import lx.domain.Banner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository  extends CrudRepository<Banner,Long> {

}
