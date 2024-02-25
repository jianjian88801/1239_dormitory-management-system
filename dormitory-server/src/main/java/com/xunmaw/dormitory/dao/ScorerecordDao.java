package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.Scorerecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Scorerecord)表数据库访问层
 *
 * 
 * @since 2023-01-16 04:09:09
 */
@Mapper
public interface ScorerecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    Scorerecord queryById(Integer scoreId);

    /**
     * 查询指定行数据
     *
     * @param scorerecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Scorerecord> queryAllByLimit(Scorerecord scorerecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param scorerecord 查询条件
     * @return 总行数
     */
    long count(Scorerecord scorerecord);

    /**
     * 新增数据
     *
     * @param scorerecord 实例对象
     * @return 影响行数
     */
    int insert(Scorerecord scorerecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Scorerecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Scorerecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Scorerecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Scorerecord> entities);

    /**
     * 修改数据
     *
     * @param scorerecord 实例对象
     * @return 影响行数
     */
    int update(Scorerecord scorerecord);

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 影响行数
     */
    int deleteById(Integer scoreId);

    List<Scorerecord> queryByAll();

    List<Scorerecord> queryByMid(Integer mid);

    Scorerecord queryByMidAndMid(Integer sid, Integer mid);
}

