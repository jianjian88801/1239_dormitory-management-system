package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Repairrecord;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.sql.RepairrecordSql;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Repairrecord)表服务接口
 *
 * 
 * @since 2023-01-14 15:07:45
 */
public interface RepairrecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    Repairrecord queryById(Integer rId);

    /**
     * 分页查询
     *
     * @param repairrecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Repairrecord> queryByPage(Repairrecord repairrecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param repairrecord 实例对象
     * @return 实例对象
     */
    Repairrecord insert(Repairrecord repairrecord);

    /**
     * 修改数据
     *
     * @param repairrecord 实例对象
     * @return 实例对象
     */
    Repairrecord update(Repairrecord repairrecord);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rId);

    ServerResponse<PageInfo<RepairrecordSql>> getPageInfoByName(Integer pageNum, Integer pageSize, String name);

    ServerResponse<PageInfo<RepairrecordSql>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<Repairrecord> addRepair(Integer sid, String title);

    ServerResponse<Repairrecord> updateRepair(Integer did,Integer id);

    ServerResponse<Repairrecord> deleteRepair(Integer id);
}
