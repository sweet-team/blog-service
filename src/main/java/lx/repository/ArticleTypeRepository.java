package lx.repository;

import lx.domain.ArticleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTypeRepository  extends CrudRepository<ArticleType,String> {
}
