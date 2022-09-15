import model.User;
import repository.Repository;
import repository.UserRepository;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Repository<User> userRepository = new UserRepository();

        User user = new User();
        user.setUsername("admin");
        user.setPassword("12345");
        Repository<User> repository = new UserRepository();
        System.out.println(userRepository.create(user));


//        try (Connection conn = ConnectionManager.open()) {
//
//            System.out.println("Connection to Store DB successful!");
////                PreparedStatement stmt = conn.prepareStatement("UPDATE users SET login=?, password=? WHERE id=?");
////            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
//            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (id, login, password) VALUES (?,?,?)");
//
//            stmt.setInt(1, 2);
//            stmt.setString(2, "Nikita");
//            stmt.setString(3, "12345");
//
//
//
////          PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE login=? AND password=?");
//
////                stmt.setInt(3, 3);
//                stmt.execute();
////            String name;
////            while (rs.next()) {
////                name = rs.getString("password");
////                System.out.println("-----------------");
////                System.out.println(name + "\n");
////            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
