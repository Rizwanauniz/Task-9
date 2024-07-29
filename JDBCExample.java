import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/yourDatabase"; 
        String dbUser = "yourUsername"; 
        String dbPassword = "yourPassword";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Query A
            System.out.println("Query A:");
            String queryA = "SELECT ename, sal FROM Empl WHERE sal >= 2200";
            PreparedStatement statementA = connection.prepareStatement(queryA);
            ResultSet resultSetA = statementA.executeQuery();
            while (resultSetA.next()) {
                System.out.println(resultSetA.getString("ename") + ", " + resultSetA.getDouble("sal"));
            }

            // Query B
            System.out.println("\nQuery B:");
            String queryB = "SELECT * FROM Empl WHERE comm IS NULL";
            PreparedStatement statementB = connection.prepareStatement(queryB);
            ResultSet resultSetB = statementB.executeQuery();
            while (resultSetB.next()) {
                System.out.println(resultSetB.getString("ename") + ", " + resultSetB.getString("job"));
            }

            // Query C
            System.out.println("\nQuery C:");
            String queryC = "SELECT ename, sal FROM Empl WHERE sal NOT BETWEEN 2500 AND 4000";
            PreparedStatement statementC = connection.prepareStatement(queryC);
            ResultSet resultSetC = statementC.executeQuery();
            while (resultSetC.next()) {
                System.out.println(resultSetC.getString("ename") + ", " + resultSetC.getDouble("sal"));
            }

            // Query D
            System.out.println("\nQuery D:");
            String queryD = "SELECT ename, job, sal FROM Empl WHERE mgr IS NULL";
            PreparedStatement statementD = connection.prepareStatement(queryD);
            ResultSet resultSetD = statementD.executeQuery();
            while (resultSetD.next()) {
                System.out.println(resultSetD.getString("ename") + ", " + resultSetD.getString("job") + ", " + resultSetD.getDouble("sal"));
            }

            // Query E
            System.out.println("\nQuery E:");
            String queryE = "SELECT ename FROM Empl WHERE ename LIKE '__A%'";
            PreparedStatement statementE = connection.prepareStatement(queryE);
            ResultSet resultSetE = statementE.executeQuery();
            while (resultSetE.next()) {
                System.out.println(resultSetE.getString("ename"));
            }

            // Query F
            System.out.println("\nQuery F:");
            String queryF = "SELECT ename FROM Empl WHERE ename LIKE '%T'";
            PreparedStatement statementF = connection.prepareStatement(queryF);
            ResultSet resultSetF = statementF.executeQuery();
            while (resultSetF.next()) {
                System.out.println(resultSetF.getString("ename"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
