/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionFactory;
import entity.Elements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vl
 */
public class ElementDao implements DAO<Elements> {

    @Override
    public void insert(Elements t) {
        String query = "insert into elements (elementid, name, discription,  image) values (?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, t.getElementid());
                preparedStatement.setString(2, t.getName());
                preparedStatement.setString(3, t.getDescription());
                preparedStatement.setString(4, t.getImage());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {

            }

        }
    }

    @Override
    public void delete(Elements t) {
        String query = "delete from where elementid = ?";
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, t.getElementid());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
            }

        }
    }

    @Override
    public List getAll() {
        List<Elements> objectCollection = new ArrayList();
        String query = ("select * from elements");
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rezult = statement.executeQuery();
            while (rezult.next()) {
                Elements Object = new Elements();

                Object.setElementid(rezult.getInt(1));
                Object.setName(rezult.getString(2));
                Object.setDescription(rezult.getString(3));
                Object.setImage(rezult.getString(4));
                objectCollection.add(Object);
            }

        } catch (Exception ex) {

        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ElementDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return objectCollection;
    }

    @Override
    public void update(Elements t) {
    }

    @Override
    public Elements getById(int id) {
        String query = "select from elements where elementid=?";
        Connection connection = null;
        Elements obj = new Elements();
        try {
            connection = ConnectionFactory.getConnection();
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);

                ResultSet rezult = preparedStatement.executeQuery();

                if (rezult.next()) {

                    obj.setElementid(rezult.getInt(1));
                    obj.setName(rezult.getString(2));
                    obj.setDescription(rezult.getString(3));
                    obj.setImage(rezult.getString(4));
                    return obj;
                }
            }
            connection.close();
        } catch (SQLException ex) {
            
        }
return null;
    

}
}