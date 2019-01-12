import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public static void main(String[] args){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hoteldb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "fhx.1234"
            );
//            serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&user=root&password=gogogo
        }catch (Exception e){

        }
        if(connection!=null){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }


    }
}
