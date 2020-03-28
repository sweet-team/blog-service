package lx.controller;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import lx.domain.Articles;
import lx.service.ArticlesService;
import lx.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/articles/{page}/{show}/{size}")
    /*@FastJsonView(include = {
            @FastJsonFilter(clazz = Articles.class,props = {

            })
    })*/
    public ResponseEntity<List<Articles>> getArticles(Integer page,Integer size,Boolean show){
        List<Articles> articlesByPage = articlesService.getArticlesByPage(size, page, show);
        return ResponseEntity.ok(articlesByPage);
    }
    @GetMapping("/articles/{id}")
    public ResponseEntity<Articles> getArticle(Long id){
        Articles articlesById = articlesService.getArticlesById(id);
        return ResponseEntity.ok(articlesById);
    }

    @PostMapping("/articles")
    public ResponseEntity<Long> addArticles(Articles articles){
        Long id = articlesService.addArticles(articles);
        return ResponseEntity.ok(id);
    }
}
