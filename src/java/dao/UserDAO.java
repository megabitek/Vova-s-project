/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionFactory;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vl
 */
public class UserDAO implements DAO<User> {

    @Override
    public void insert(User t) {
        try {
            String query = "insert into user (userid, fullname,  password) values (?, ?, ?)";
            Connection connection = null;
           
            connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getnextID());
            preparedStatement.setString(2, t.getFullName());
            preparedStatement.setString(3, t.getPassword());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("not insert user");
        } catch (Exception ex) {
            System.out.println("not insert user");
        }
    }

    @Override
    public void delete(User t) {
        try {
            String query = "delete from user where userid = ?";

            try (Connection connection = ConnectionFactory.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, t.getUserid());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Not delete user!");
        } catch (Exception ex) {

        }
    }

    @Override
    public List<User> getAll() {
        List<User> objectCollection = new ArrayList<>();
        String query = ("select * from user");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = connection.prepareStatement(query);
            ResultSet Rezult = Statement.executeQuery();
            while (Rezult.next()) {
                User Object = new User();

                Object.setUserid(Rezult.getInt(1));
                Object.setFullName(Rezult.getString(2));
                Object.setPassword(Rezult.getString(4));
                objectCollection.add(Object);
            }
            connection.close();
        } catch (Exception ex) {
            return null;
        }

        return objectCollection;
    }

    @Override
    public void update(User t) {
        String query = ("update user set fullname=?,   password=?  where userid=?");
        try {

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(5, t.getUserid());
            preparedStatement.setString(1, t.getFullName());
            preparedStatement.setString(3, t.getPassword());
            preparedStatement.execute();
            connection.close();
        } catch (Exception ex) {
        }
    }

    @Override
    public User getById(int id) {
        User Object = new User();
        String query = ("select * from user where id=?");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = connection.prepareStatement(query);
            Statement.setInt(1, id);

            ResultSet Rezult = Statement.executeQuery();

            if (Rezult.next()) {
                Object.setUserid(Rezult.getInt(1));
                Object.setPassword(Rezult.getString(4));
                connection.close();
                return Object;
            } else {
                connection.close();
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public User getByLogin(String login) {
        User Object = new User();
        String query = ("select * from user where fullname=?");
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement Statement = connection.prepareStatement(query);
            Statement.setString(1, login);

            ResultSet rezult = Statement.executeQuery();

            if (rezult.next()) {
                Object.setUserid(rezult.getInt(1));
                Object.setFullName(rezult.getString(2));
                Object.setPassword(rezult.getString(3));
                connection.close();
                return Object;
            } else {
                connection.close();
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

}
