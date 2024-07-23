package org.day0723.Test;

import org.day0723.dao.StudentDAO;
import org.day0723.dao.impl.StudentDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yangpeng
 * @date 2024/7/23 上午11:02
 */
public class testStudentDAO {
    private StudentDAO studentDAO;
    @Before
    public void init(){
        studentDAO = new StudentDAOImpl();
    }
    @Test
    public void testFindById(){
        Assert.assertNotNull(studentDAO.findById(1));
    }
    @Test
    public void testCount(){
        Assert.assertEquals(7,(long)studentDAO.count());
    }
    @Test
    public void testFindAll(){
        Assert.assertNotNull(studentDAO.findAll());
    }
    @Test
    public void testFindByNameLike(){
        Assert.assertNotNull(studentDAO.findByNameLike("刘"));
    }
    @Test
    public void testFindByNameLikeWithLimit(){
        Assert.assertNotNull(studentDAO.findByNameLikeWithLimit("刘",0,6));
    }
    @Test
    public void testFindWithLimit(){
        Assert.assertNotNull(studentDAO.findWithLimit(0,1));
    }
}
