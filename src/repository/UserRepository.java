package repository;

import model.User;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User>{
    @Override
    public User read(String username, String password) {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (id, login, password) VALUES (?,?,?)");

            stmt.setInt(1, 2);
            stmt.setString(2, "Nikita");
            stmt.setString(3, "12345");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean update(User user, User tr) {
        return false;
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionManager.open()) {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
            String name;

            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                User user = new User(id, login, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
