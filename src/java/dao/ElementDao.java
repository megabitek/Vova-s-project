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
import java.sql.SQLException;
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
        String query = "delete from elements (elementid, name, discription,  image) values (?, ?, ?, ?)";
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
    }

    @Override
    public void update(Elements t) {
    }

    @Override
    public Elements getById(int id) {
    }

}
