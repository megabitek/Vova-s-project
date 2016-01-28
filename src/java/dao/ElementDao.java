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
        String query = "delete from elements where ";
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
    public List getAll() {
        List<Elements> objectCollection = new ArrayList();
        String query = "select * from elements";
        Connection connection = null;
        connection = ConnectionFactory.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
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
            } catch (SQLException ex) {
                System.out.println("Can't get all");
            } finally {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ElementDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return objectCollection;
    }

    @Override
    public void update(Elements t) {
         String query = ("update elements set name=?,  description=?, image=? where elementid=?");
        try {

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(4, t.getElementid());
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getDescription());
            preparedStatement.setString(3, t.getImage());
            preparedStatement.execute();
            connection.close();
        } catch (Exception ex) {
        }
        
    }

    @Override
    public Elements getById(int id) {
         Elements Object = new Elements();
        String query = ("select * from elements where elenemtid=?");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rezult = statement.executeQuery();

            if (rezult.next()) {

                Object.setElementid(rezult.getInt(1));
                Object.setName(rezult.getString(2));
                Object.setDescription(rezult.getString(3));
                Object.setImage(rezult.getString(4));

                return Object;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

}
