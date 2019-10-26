import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCTest {
    public static void main(String[] args) throws Exception{
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;

        try{
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url="jdbc:mysql://localhost:3306/chenqijia?useSSL=FALSE&serverTimezone=UTC";
            String user="root";
            String password="2063339424";
            connection=DriverManager.getConnection(url,user,password);
            //获取statement
            String sql="select * from tb_user where id=?";
            preparedStatement=connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,1);
            //执行查询
            rs=preparedStatement.executeQuery();
            //处理结果集
            while(rs.next())
            {
                System.out.println(rs.getString("user_Name"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("birthday"));
            }


        }finally{
            if(rs!=null)
            {
                rs.close();
            }
            if(preparedStatement!=null)
            {
                preparedStatement.close();
            }
            if(connection!=null)
            {
                connection.close();
            }
        }
    }
}
