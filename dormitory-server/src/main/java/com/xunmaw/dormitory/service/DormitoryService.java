package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Dormitory;
import com.xunmaw.dormitory.response.ServerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (Dormitory)表服务接口
 *
 * 
 * @since 2023-01-14 15:07:18
 */
public interface DormitoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    Dormitory queryById(Integer dId);

    /**
     * 分页查询
     *
     * @param dormitory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Dormitory> queryByPage(Dormitory dormitory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dormitory 实例对象
     * @return 实例对象
     */
    Dormitory insert(Dormitory dormitory);

    /**
     * 修改数据
     *
     * @param dormitory 实例对象
     * @return 实例对象
     */
    Dormitory update(Dormitory dormitory);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dId);

    ServerResponse<Map<String, Object>> getPageInfoByName(Integer pageNum, Integer pageSize, String name);

    ServerResponse<Map<String, Object>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<Dormitory> addDormitory(String name, Integer floor, Integer buid, Integer maxNumber);

    ServerResponse<Dormitory> updateDormitory(Integer id ,String name, Integer floor, Integer buid, Integer maxNumber);

    ServerResponse<Dormitory> deleteDormitory(Integer id);

    ServerResponse<List<Dormitory>> getdormitoryList();

    ServerResponse<List<Dormitory>> getolddormitoryList();

    ServerResponse<Map<String,Object>> getCountDor();
}
