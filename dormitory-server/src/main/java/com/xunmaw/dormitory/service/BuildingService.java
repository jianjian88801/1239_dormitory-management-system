package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Building;
import com.xunmaw.dormitory.response.ServerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (Building)表服务接口
 *
 * 
 * @since 2023-01-14 15:07:08
 */
public interface BuildingService {

    /**
     * 通过ID查询单条数据
     *
     * @param buId 主键
     * @return 实例对象
     */
    Building queryById(Integer buId);

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Building> queryByPage(Building building, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building insert(Building building);

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building update(Building building);

    /**
     * 通过主键删除数据
     *
     * @param buId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buId);

    ServerResponse<Map<String,Object>> getPageInfoByName(Integer pageNum, Integer pageSize, String name);

    ServerResponse<Map<String,Object>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<Building> addBuilding(String name, String location);

    ServerResponse<Building> updateBuilding(Integer id,String name,String location);

    ServerResponse<Building> deleteBuilding(Integer id);

    ServerResponse<List<Building>> BuildingList();

}
