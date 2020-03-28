package lx.repository;

import lx.domain.Articles;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticlesRepository extends CrudRepository<Articles,Long> , PagingAndSortingRepository<Articles,Long>, JpaSpecificationExecutor<Articles> {
    Long countAllByShow(Boolean show);
}
