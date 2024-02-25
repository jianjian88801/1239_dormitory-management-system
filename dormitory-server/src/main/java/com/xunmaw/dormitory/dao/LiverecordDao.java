package com.xunmaw.dormitory.dao;

import com.xunmaw.dormitory.entity.Liverecord;
import com.xunmaw.dormitory.sql.LiveRecordSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Liverecord)表数据库访问层
 *
 * 
 * @since 2023-01-14 15:07:34
 */
@Mapper
public interface LiverecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param lId 主键
     * @return 实例对象
     */
    Liverecord queryById(Integer lId);

    /**
     * 查询指定行数据
     *
     * @param liverecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Liverecord> queryAllByLimit(Liverecord liverecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param liverecord 查询条件
     * @return 总行数
     */
    long count(Liverecord liverecord);

    /**
     * 新增数据
     *
     * @param liverecord 实例对象
     * @return 影响行数
     */
    int insert(Liverecord liverecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Liverecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Liverecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Liverecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Liverecord> entities);

    /**
     * 修改数据
     *
     * @param liverecord 实例对象
     * @return 影响行数
     */
    int update(Liverecord liverecord);

    /**
     * 通过主键删除数据
     *
     * @param lId 主键
     * @return 影响行数
     */
    int deleteById(Integer lId);

    List<LiveRecordSql> queryAllByName(String name);

    List<LiveRecordSql> queryAll();

    List<Liverecord> queryAllEntity();
}

