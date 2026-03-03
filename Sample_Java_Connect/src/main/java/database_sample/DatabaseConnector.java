package database_sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseConnector {

    private static DatabaseConnector connector;

    private Connection connection;
    private final String driver_name;
    private final String host;
    private final int port;
    private final String jdbc_url;
    private final String db_name;
    private final String user_id;
    private final String user_pass;

    private DatabaseConnector() {
        driver_name = "com.mysql.cj.jdbc.Driver";
        host = "";
        port = 3306;
        db_name = "test";
        user_id = "test_user";
        user_pass = "testpass";
        jdbc_url = "jdbc:mysql://" + host + ":" + port + "/" + db_name + "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";

        try {
            Class.forName(driver_name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ドライバーが見つかりませんでした", e);
        }

        try {
            connection = DriverManager.getConnection(jdbc_url, user_id, user_pass);
        } catch (SQLException e) {
            throw new RuntimeException("データベース接続中に問題が発生しました", e);
        }
    }

    public static DatabaseConnector getInstance() {
        if (connector == null) {
            connector = new DatabaseConnector();
        }
        return connector;
    }

    public TestDatabase getData(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM test_table");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int getId = rs.getInt("id");
                String getName = rs.getString("name");
                String getClassName = rs.getString("class");
                if (getId == id) {
                    return new TestDatabase(getId, getName, getClassName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQLに問題が発生しました", e);
        }

        return null;
    }
}
