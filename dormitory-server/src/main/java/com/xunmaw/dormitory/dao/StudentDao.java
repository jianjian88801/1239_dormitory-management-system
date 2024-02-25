package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Student)表数据库访问层
 *
 *
 * @since 2023-01-15 18:36:29
 */
@Mapper
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Student queryById(Integer sId);

    /**
     * 查询指定行数据
     *
     * @param student 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Student> queryAllByLimit(Student student, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param student 查询条件
     * @return 总行数
     */
    long count(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Student> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Student> entities);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 影响行数
     */
    int deleteById(Integer sId);
    /**
     * 通过账户名查找数据
     * @param account
     * @return
     */
    Student queryByAccount(String account);

    /**
     * 通过账户名和密码查找查找数据
     * @param account
     * @param password
     * @return
     */
    Student queryByPwdAccount(String account,String password);

    List<Student> queryAllByAccount(String account);

    List<Student> queryAllByName(String name);

    List<Student> queryAll();

    Student queryAllByNumber(String number);

    Integer queryAllCount();
}

