package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Scorerecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.xunmaw.dormitory.response.ServerResponse;

/**
 * (Scorerecord)表服务接口
 *
 * 
 * @since 2023-01-16 04:09:22
 */
public interface ScorerecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    Scorerecord queryById(Integer scoreId);

    /**
     * 分页查询
     *
     * @param scorerecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Scorerecord> queryByPage(Scorerecord scorerecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param scorerecord 实例对象
     * @return 实例对象
     */
    Scorerecord insert(Scorerecord scorerecord);

    /**
     * 修改数据
     *
     * @param scorerecord 实例对象
     * @return 实例对象
     */
    Scorerecord update(Scorerecord scorerecord);

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer scoreId);

    ServerResponse<Scorerecord> ScoreAdd(Integer sid, Integer  mid,Integer score);
}
