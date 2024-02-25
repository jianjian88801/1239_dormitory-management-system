package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Liverecord;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.sql.LiveRecordSql;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Liverecord)表服务接口
 *
 * 
 * @since 2023-01-14 15:07:34
 */
public interface LiverecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param lId 主键
     * @return 实例对象
     */
    Liverecord queryById(Integer lId);

    /**
     * 分页查询
     *
     * @param liverecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Liverecord> queryByPage(Liverecord liverecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param liverecord 实例对象
     * @return 实例对象
     */
    Liverecord insert(Liverecord liverecord);

    /**
     * 修改数据
     *
     * @param liverecord 实例对象
     * @return 实例对象
     */
    Liverecord update(Liverecord liverecord);

    /**
     * 通过主键删除数据
     *
     * @param lId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer lId);

    ServerResponse<PageInfo<LiveRecordSql>> getPageInfoByName(Integer pageNum, Integer pageSize, String name);

    ServerResponse<PageInfo<LiveRecordSql>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<Liverecord> addLive(Integer sid, Integer did);

    ServerResponse<Liverecord> updateLive(Integer id, Integer sid, Integer did);

    ServerResponse<Liverecord> deleteLive(Integer id);
}
