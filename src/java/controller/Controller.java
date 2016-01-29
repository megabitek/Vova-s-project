/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dao.UserDAO;
import entity.User;

/**
 *
 * @author vl
 */
public class Controller {

    public static User checkUser(String login, String password) {
        UserDAO dao = new UserDAO();
        User user = dao.getByLogin(login);
        if (user!=null){
        if (user.getPassword().equals(password)) {
            return user;
        } }
        return null;

    }

    public static void addUser(String login, String password) {
        User user = new User();
        user.setFullName(login);
        user.setPassword(password);
        DAO dao = new UserDAO();
        dao.insert(user);
    }
}
