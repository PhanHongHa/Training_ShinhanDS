package com.example.demoJDBC;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private JdbcTemplate template;

    @Transactional
    public List<Item> getAllItems() {
        List<Item> items = template.query(
                " SELECT item.ID, item.NAME, item.CATEGORY FROM ITEM item "
                , (result, rowNum) -> new Item(
                        result.getInt("ID"),
                result.getString("NAME"),
                        result.getString("CATEGORY"))
        );
        return items;
    }

    public Item getItem(int itemId) {
        String query = "SELECT * FROM ITEM WHERE ID=?";
        Item item = template.queryForObject(query, new Object[]{itemId}, new BeanPropertyRowMapper<>(Item.class));

        return item;
    }

    /*Adding an item into database table*/
    public int addItem(int id, String name, String category) {
        String query = "INSERT INTO ITEM VALUES(?,?,?)";
        return template.update(query, id, name, category);
    }

    /*delete an item from database*/
    public int deleteItem(int id) {
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query, id);
    }
}