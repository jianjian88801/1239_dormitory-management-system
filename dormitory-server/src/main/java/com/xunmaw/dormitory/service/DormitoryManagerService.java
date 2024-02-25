package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Building;
import com.xunmaw.dormitory.entity.DormitoryManager;
import com.xunmaw.dormitory.response.ServerResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DormitoryManager)表服务接口
 *
 * 
 * @since 2023-01-14 15:07:26
 */
public interface DormitoryManagerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DormitoryManager queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dormitoryManager 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DormitoryManager> queryByPage(DormitoryManager dormitoryManager, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dormitoryManager 实例对象
     * @return 实例对象
     */
    DormitoryManager insert(DormitoryManager dormitoryManager);

    /**
     * 修改数据
     *
     * @param dormitoryManager 实例对象
     * @return 实例对象
     */
    DormitoryManager update(DormitoryManager dormitoryManager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    ServerResponse<PageInfo<DormitoryManager>> getPageInfoByAccount(Integer pageNum, Integer pageSize, String account);

    ServerResponse<PageInfo<DormitoryManager>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo<DormitoryManager>> getPageInfoByName(Integer pageNum, Integer pageSize, String account);

    ServerResponse<DormitoryManager> addDorManager(String name, String number, String account, String password, Integer sex);

    ServerResponse<DormitoryManager> updateDorManager(Integer id, String name, String number, String account, String password, Integer sex);

    ServerResponse<DormitoryManager> deleteDroManager(Integer id);

    ServerResponse<Integer> getCount();

    ServerResponse<Integer> getscore(Integer mid);

    ServerResponse<Building> changeManager(Integer mid, Integer id);
}
