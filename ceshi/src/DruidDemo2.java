import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="insert into account values(null ,?,?)";
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,"王");
           pstmt.setString(2,"1");
          int count =pstmt.executeUpdate();
            System.out.println("共更新"+count+"条信息");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
