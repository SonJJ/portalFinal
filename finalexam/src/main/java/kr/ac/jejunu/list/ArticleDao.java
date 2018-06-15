package kr.ac.jejunu.list;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;


public class ArticleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Article getAticle(int id) throws ClassNotFoundException, SQLException {
        Object[] objects = new Object[] {id};
        String sql = "select * FROM travel_list WHERE list_id = ?";
        Article article1 = null;

        try {
            article1 = jdbcTemplate.queryForObject(sql,objects,(resultSet,i) ->{
                Article article = new Article();
                article.setList_id(resultSet.getInt("list_id"));
//                article.setArticle_id(resultSet.getInt("article_id"));
                article.setList_title(resultSet.getString("list_title"));
                article.setList_content(resultSet.getString("list_content"));
                article.setOcc_time(resultSet.getTime("occ_time"));
                return article;
            });
        } catch (DataAccessException e) {
            throw e;
        }

        return article1;
    }

    public void add(Article article) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO articles (list_id, list_title, list_content, occ_time) VALUES(?,? ,?, now())";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, article.getList_id());
            preparedStatement.setString(2, article.getList_title());
            preparedStatement.setString(3, article.getList_content());
            return preparedStatement;
        }, keyHolder);


    }

    public void update(Article article) throws SQLException, ClassNotFoundException {
        Object[] objects = new Object[]{article.getList_title(), article.getList_content(), article.getList_id()};
        String sql = "update travel_list set list_title = ? , list_content = ? where list_id = ?";
        jdbcTemplate.update(sql, objects);
    }

    public void delete(int list_id) throws SQLException, ClassNotFoundException {
        Object[] objects = new Object[]{list_id};
        String sql = "delete from articles where list_id = ?";
        jdbcTemplate.update(sql,objects);
    }

    public void deleteAll() throws SQLException {
        Object[] objects = null;
        String sql = "delete from articles";
        jdbcTemplate.update(sql,objects);
    }

    public List<Article> getArticleAll() throws SQLException {
        String sql = "select * FROM articles ORDER BY list_id";
        List<Article> myList = (List<Article>)this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Article>(Article.class));
        return myList;
    }
}
