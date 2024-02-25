package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Dormitory)表数据库访问层
 *
 * 
 * @since 2023-01-14 15:07:18
 */
@Mapper
public interface DormitoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    Dormitory queryById(Integer dId);

    /**
     * 查询指定行数据
     *
     * @param dormitory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Dormitory> queryAllByLimit(Dormitory dormitory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dormitory 查询条件
     * @return 总行数
     */
    long count(Dormitory dormitory);

    /**
     * 新增数据
     *
     * @param dormitory 实例对象
     * @return 影响行数
     */
    int insert(Dormitory dormitory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dormitory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dormitory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dormitory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Dormitory> entities);

    /**
     * 修改数据
     *
     * @param dormitory 实例对象
     * @return 影响行数
     */
    int update(Dormitory dormitory);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 影响行数
     */
    int deleteById(Integer dId);

    /**
     * 模糊查询名称
     * @param name
     * @return
     */
    List<Dormitory> queryAllByName(String name);

    /**
     * 查询所有
     * @return
     */
    List<Dormitory> queryAll();

    /**
     * 根据名称查找单条数据
     * @param name
     * @return
     */
    Dormitory queryByName(String name);

    /**
     * 查询入住人数小于最大入住人数的宿舍列表
     * @return
     */
    List<Dormitory>  queryByLiveNumberSmallMaxNumber();
}

