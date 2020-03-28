package lx.controller;

import lx.domain.ArticleType;
import lx.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/articletype")
    public ResponseEntity<List<ArticleType>> allArticleType(){
        List<ArticleType> articleTypes = articleTypeService.getArticleType();
        return ResponseEntity.ok(articleTypes);
    }
    @GetMapping("/articletype/{id}")
    public ResponseEntity<ArticleType> getArticleType(String id){
        ArticleType articleTypeById = articleTypeService.getArticleTypeById(id);
        return ResponseEntity.ok(articleTypeById);
    }

}
