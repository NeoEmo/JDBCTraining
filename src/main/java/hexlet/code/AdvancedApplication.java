package hexlet.code;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AdvancedApplication {
    static void main(String[] args) throws SQLException {
        // Пороль другой, но для примера сделал своё соединение с postgreSQL
        var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hexlet_db", "lunev", "12345");
        var sql = "SELECT * FROM cars";
        var statement = connection.createStatement();
        var result = statement.executeQuery(sql);
        int count = 0;
        while (result.next()) {
            long id = result.getLong("id");
            String model = result.getString("model");
            String brand = result.getString("brand");
            String color = result.getString("color");
            String condition = result.getString("condition");
            System.out.println("ID: " + id + " model: " + model + " brand: " + brand + " color: " + color + " condition: " + condition);
            count++;
        }
        System.out.println("Всего записей в БД: " + count);
        statement.close();
        connection.close();
    }
}
