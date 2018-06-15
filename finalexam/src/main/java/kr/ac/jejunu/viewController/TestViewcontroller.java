package kr.ac.jejunu.viewController;

import kr.ac.jejunu.list.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class TestViewcontroller {

    ApplicationContext applicationContext = new GenericXmlApplicationContext("daoFactory.xml");
    ArticleDao articleDao = applicationContext.getBean("articleDao", ArticleDao.class);

    @RequestMapping(value = "/")
    public String index(Model model) throws SQLException, ClassNotFoundException {

        Article checkUser = articleDao.getAticle(1);

        model.addAttribute("test",checkUser.getList_title());
        model.addAttribute("datas", articleDao.getArticleAll());


        return "index";
    }


    @RequestMapping(value = "/article/fix", method = RequestMethod.GET)
    public String fix(@RequestParam String article_id, @RequestParam String member_id, Model model) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(article_id);

        model.addAttribute("data", articleDao.getAticle(id));

        return "fix";
    }

    @RequestMapping(value = "/article/fix", method = RequestMethod.POST)
    public String fix(@RequestParam String list_title, @RequestParam String list_content, @RequestParam String list_id ,@RequestParam String member_id) throws SQLException, ClassNotFoundException {

        Article article = new Article();

        article.setList_title(list_title);
        article.setList_content(list_content);
//        article.setArticle_id(Integer.parseInt(article_id));
        article.setList_id(Integer.parseInt(list_id));

        articleDao.update(article);

        return "redirect:/";
    }

    @RequestMapping(value = "/create")
    public String create(){


        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam String list_title, @RequestParam String list_content, @RequestParam String list_id) throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(list_id);
        Article article = new Article();
        article.setList_title(list_title);
        article.setList_content(list_content);


        return "redirect:/";
    }
//    @RequestMapping(value = "/test", method = RequestMethod.POST)
//    public String test(){
//        return null;
//    }

}
