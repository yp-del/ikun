package org.day0723.test1;

/**
 * @author yangpeng
 * @date 2024/7/22 下午2:49
 */
public class Test {
    public static void main(String[] args) {
        //驱动加载
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("驱动加载成功");
//        //获取jdbc连接
//        String url = "jdbc:mysql://localhost:3306/nuist?characterEncoding=utf8";
//        String username = "root";
//        String password = "a12345";
//        Connection connection = null;
//        try {
//            connection =
//                    DriverManager.getConnection(url, username, password);
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("获取连接成功");
//        //创建编译语句
//        try {
//            Statement s = connection.createStatement();
//            //准备一个sql语句
//            String sql = "insert into  stu (name,gender,brithday,addr,qqnumber)" +
//                    "values ('刘倩','女','2003-09-07','江苏南京','2536471736')";
//            //运行sql语句
//            s.execute(sql);
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
        //驱动加载 链接获取 创建编译语句对象 执行语句
        //驱动加载 连接获取 创建编译语句对象 执行语句 获取查询结果集
//        Student s1 =new Student(0,"无畏","男",new Date(0),"南京",110);
//        StudentDAO studentDAO = new StudentDAOImpl();
//        studentDAO.insert(s1);
//        Student s2=new Student(6,"不留情","女",new Date(),"南京",2147483646);
//        StudentDAO studentDAO = new StudentDAOImpl();
//        studentDAO.update(s2);
    }
}
