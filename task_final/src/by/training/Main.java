package by.training;

import by.training.entity.Role;
import by.training.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Connection cn = null;

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/think",
                    "root", "");
            Statement st = null;
            try {
                st = cn.createStatement();
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("SELECT* FROM users");
                    ArrayList<User> lst = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String login = rs.getString(2);
                        String email = rs.getString(3);
                        String password = rs.getString(4);
                        Role role = Role.ADMINISTRATOR;
                        lst.add(new User(id, login, email, password, role));

                    }
                    if (lst.size() > 0) {
                        System.out.println(lst.get(0).getLogin());
                    } else {
                        System.out.println("Not found");
                    }
                } finally { // для 3-го блока try
                    /*
                     * закрыть ResultSet, если он был открыт
                     * или ошибка произошла во время
                     * чтения из него данных
                     */
                    if (rs != null) { // был ли создан ResultSet
                        rs.close();
                    } else {
                        System.err.println(
                                "ошибка во время чтения из БД");
                    }
            }
        } finally {
                /*
                 * закрыть Statement, если он был открыт или ошибка
                 * произошла во время создания Statement
                 */
                if (st != null) { // для 2-го блока tryst.close();
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException e) { // для 1-го блока try
            System.err.println("DB connection error: " + e);
            /*
             * вывод сообщения о всех SQLException
             */
        } finally {
            /*
             * закрыть Connection, если он был открыт
             */
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }
    }
}
