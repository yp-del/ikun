package org.day0723.dao.impl;

import org.day0723.dao.StudentDAO;
import org.day0723.pojo.Student;
import org.day0723.test1.DBUTIL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangpeng
 * @date 2024/7/22 下午3:52
 */
public class StudentDAOImpl implements StudentDAO {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
    @Override
    public void insert(Student student) {
        try(
                Connection c = DBUTIL.getConnection();
                Statement st = c.createStatement();
                //传参麻烦 性能较差 存在sql注入攻击问题
                //PerparedStatement
                //先编译 后传参 效率高
                //传参方便
                //有效防止sql注入攻击问题
        ){
            String sql = "insert into student(name,gender,birthday,addr,qqnumber)"
                    +"values('%s','%s','%s','%s','%d')";
            sql = String.format(sql,student.getName(),student.getGender(),
                    sdf.format(student.getBirthday()),
                    student.getAddr(),student.getQqnumber());
            st.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name=?,gender=?,birthday=?,qqnumber=? where id=?";
        //?表示代传的参数
        try(
            Connection c = DBUTIL.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
        ){
            //给sql语句进行参数传递
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3, new Date(student.getBirthday().getTime()));
            ps.setLong(4,student.getQqnumber());
            ps.setInt(5,student.getId());
            ps.execute();
            // 1 表示给第一个问号传的参数
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id=?";
        Connection c= null;
        try{
                c = DBUTIL.getConnection();
                //关闭事务自动提交
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            c.commit();
        }catch (SQLException e) {
            try{
                c.rollback();
                //异常则回滚事务
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try{
                c.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Integer count() {
        String sql = "select count(*) from student";
        try(
            Connection c = DBUTIL.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Student findById(Integer id) {
        String sql = "select * from student where id=?";
        Student student = null;
        try(
                Connection c = DBUTIL.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                student = new Student();
                student.setId(id);
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddr(rs.getString("addr"));
                student.setQqnumber(rs.getLong("qqnumber"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return findWithLimit(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> findByNameLike(String name) {
        return findByNameLikeWithLimit(name,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> findByNameLikeWithLimit(String name, int start, int limit) {
        String sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        List<Student> stus = new ArrayList<>();
        try(
                Connection c = DBUTIL.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            ps.setString(1,name);
            ps.setInt(2,start);
            ps.setInt(3,limit);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddr(rs.getString("addr"));
                student.setQqnumber(rs.getLong("qqnumber"));
                stus.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stus.size()==0?null:stus;
    }

    @Override
    public List<Student> findWithLimit(int start, int limit) {
        String sql = "select * from student limit ?,?";
        List<Student> stus = new ArrayList<Student>();
        try(
               Connection c = DBUTIL.getConnection();
               PreparedStatement ps = c.prepareStatement(sql);
                ){
            ps.setInt(1,start);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            //遍历结果集
            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddr(rs.getString("addr"));
                student.setQqnumber(rs.getLong("qqnumber"));
                stus.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stus.size()==0?null:stus;
        //jcisjd
    }
}
