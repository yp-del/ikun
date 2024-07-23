package org.day0723.dao;

import org.day0723.pojo.Student;

import java.util.List;

/**
 * @author yangpeng
 * @date 2024/7/22 下午3:34
 */
public interface StudentDAO {
    /**插入一个学生信息
     * @param student 要插入的学生信息 主键无需提供
     */
    void insert(Student student);

    /**根据学生id修改学生的所有信息
     * @param student 要修改的学生id和要修改的字段值
     */
    void update(Student student);

    /**根据主键删除一个学生信息
     * @param id 要删除的学生信息的id
     */
    void delete(Integer id);

    /**统计表记录总数
     * @return 返回表记录总数 如果为0 表示没有数据
     */
    Integer count();//select count(*)

    /**根据id查找对应的学生信息
     * @param id 要获取的学生的id
     * @return id对应的学生信息 如果不存在则返回null
     */
    Student findById(Integer id);

    /**获取所有学生信息
     * @return 所有学生信息
     */
    List<Student> findAll();

    /**根据名称模糊查询学生
     * @param name 模糊查询关键字
     * @return 模糊查询的学生结果
     */
    List<Student> findByNameLike(String name);

    /**根据名字进行模糊分页查询
     * @param name 模糊查询关键字
     * @param start limit起始参数
     * @param limit 要分页查询的行数
     * @return 返回分页查询的结果 若找不到则返回null
     */
    List<Student> findByNameLikeWithLimit(String name, int start, int limit);

    /**分页查询学生
     * @param start limit起始关键字
     * @param limit 要分页截取的行数
     * @return 分页查询的的学生数据 如果没有数据则返回null
     */
    List<Student> findWithLimit(int start, int limit);
}
