package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.DormitoryManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DormitoryManager)表数据库访问层
 *
 * 
 * @since 2023-01-14 15:07:26
 */
@Mapper
public interface DormitoryManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DormitoryManager queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dormitoryManager 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DormitoryManager> queryAllByLimit(DormitoryManager dormitoryManager, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dormitoryManager 查询条件
     * @return 总行数
     */
    long count(DormitoryManager dormitoryManager);

    /**
     * 新增数据
     *
     * @param dormitoryManager 实例对象
     * @return 影响行数
     */
    int insert(DormitoryManager dormitoryManager);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DormitoryManager> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DormitoryManager> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DormitoryManager> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DormitoryManager> entities);

    /**
     * 修改数据
     *
     * @param dormitoryManager 实例对象
     * @return 影响行数
     */
    int update(DormitoryManager dormitoryManager);

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
    DormitoryManager queryByAccount(String account);

    /**
     * 通过账户名和密码查找查找数据
     * @param account
     * @param password
     * @return
     */
    DormitoryManager queryByPwdAccount(String account,String password);

    List<DormitoryManager> queryAll();

    List<DormitoryManager> queryAllByAccount(String account);

    List<DormitoryManager> queryAllByName(String name);

    DormitoryManager queryAllByNumber(String number);

    Integer queryAllByStatus();
}

