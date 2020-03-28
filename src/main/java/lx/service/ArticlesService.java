package lx.service;

import jdk.nashorn.internal.ir.CallNode;
import lx.domain.Articles;
import lx.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.persistence.criteria.*;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesRepository articlesRepository;

    private String escape(String html){
        String s = HtmlUtils.htmlEscape(html);
        return s;
    }
    private String unescape(String esHtml){
        String s = HtmlUtils.htmlUnescape(esHtml);
        return s;
    }

    public Articles getArticlesById(Long id){
        Optional<Articles> byId = this.articlesRepository.findById(id);
        Articles articles = byId.get();
        articles.setContext(unescape(articles.getContext()));
        return articles;
    }
    public List<Articles> getArticlesByPage(Integer size, Integer page, Boolean isShow){
        Page<Articles> show = this.articlesRepository.findAll(new Specification<Articles>() {
            @Override
            public Predicate toPredicate(Root<Articles> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Boolean> show = root.get("show");
                Predicate equal = criteriaBuilder.equal(show, isShow);
                query.where(equal);
                return null;
            }
        }, PageRequest.of(page, size));
        List<Articles> content = show.getContent();
        content.stream().peek( t ->{t.setContext(unescape(t.getContext()));});
        return content;
    }
    public Long getArticlesTotalNumber(Boolean isTotal,Boolean show){
        if (isTotal){
            return this.articlesRepository.count();
        }
        return this.articlesRepository.countAllByShow(show);
    }

    public Long addArticles(Articles articles) {
        articles.setContext(escape(articles.getContext()));
        articles.setDate(System.currentTimeMillis());
//        articles.setType();
        return null;
    }

}
