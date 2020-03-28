package lx.service;

import lx.domain.ArticleType;
import lx.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;


    public List<ArticleType> getArticleType() {
        Iterable<ArticleType> all = articleTypeRepository.findAll();
        ArrayList<ArticleType> articleTypes = new ArrayList<>();
        all.forEach(x->{articleTypes.add(x);});
        return articleTypes;
    }

    public ArticleType getArticleTypeById(String id){
        Optional<ArticleType> byId = articleTypeRepository.findById(id);
        return byId.get();
    }
}
