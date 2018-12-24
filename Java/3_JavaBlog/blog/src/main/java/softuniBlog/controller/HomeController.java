package softuniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuniBlog.entity.Article;
import softuniBlog.repository.ArticleRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ArticleRepository articleRepository;                           //   свързано с ф-я detals - readmore

    @GetMapping("/")
    public String index(Model model) {

        List<Article> articles = this.articleRepository.findAll();          // свързано с ф-я detals - readmore

        model.addAttribute("view", "home/index");
        model.addAttribute("articles", articles);                         // свързано с ф-я detals - readmore
        return "base-layout";
    }
}
