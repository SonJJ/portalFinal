package kr.ac.jejunu.list;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class daoTest {

    ArticleDao articleDao;

    @Before
    public void setting(){
        ApplicationContext applicationContext = new GenericXmlApplicationContext("daoFactory.xml");
        articleDao = applicationContext.getBean("articleDao",ArticleDao.class);
    }


    @Test
    public void getAticle() throws SQLException, ClassNotFoundException {

        Article checkUser = articleDao.getAticle(1);

        assertThat(1,is(checkUser.getList_id()));
        assertThat("test",is(checkUser.getList_content()));
    }



}