package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * 
 * @since 2023-01-14 20:02:08
 */
@Mapper
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param admin 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(Admin admin, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param admin 查询条件
     * @return 总行数
     */
    long count(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Admin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Admin> entities);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过账户名查找数据
     * @param account
     * @return
     */
    Admin queryByAccount(String account);

    /**
     * 通过账户名和密码查找查找数据
     * @param account
     * @param password
     * @return
     */
    Admin queryByPwdAccount(String account,String password);

    /**
     * 查询所有数据
     * @return
     */
    List<Admin> queryAll();

    List<Admin> queryAllByAccount(String account);
}

