package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.Repairrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Repairrecord)表数据库访问层
 *
 * 
 * @since 2023-01-14 15:07:45
 */
@Mapper
public interface RepairrecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    Repairrecord queryById(Integer rId);

    /**
     * 查询指定行数据
     *
     * @param repairrecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Repairrecord> queryAllByLimit(Repairrecord repairrecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param repairrecord 查询条件
     * @return 总行数
     */
    long count(Repairrecord repairrecord);

    /**
     * 新增数据
     *
     * @param repairrecord 实例对象
     * @return 影响行数
     */
    int insert(Repairrecord repairrecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Repairrecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Repairrecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Repairrecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Repairrecord> entities);

    /**
     * 修改数据
     *
     * @param repairrecord 实例对象
     * @return 影响行数
     */
    int update(Repairrecord repairrecord);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteById(Integer rId);

    List<Repairrecord> queryAll();

    Repairrecord queryByTitle(String title);
}

