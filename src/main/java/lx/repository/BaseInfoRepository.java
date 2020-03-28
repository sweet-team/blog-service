package lx.repository;

import lx.domain.BaseInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseInfoRepository extends CrudRepository<BaseInfo,Long> {

}
