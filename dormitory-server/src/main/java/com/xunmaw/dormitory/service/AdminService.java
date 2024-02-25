package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Admin;
import com.xunmaw.dormitory.response.ServerResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * (Admin)表服务接口
 *
 * 
 * @since 2023-01-14 20:02:10
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Admin> queryByPage(Admin admin, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通用登录
     * @param account
     * @param password
     * @return
     */
    ServerResponse<Map<String, Object>> login(String account,String password);

    ServerResponse<Map<String, Object>> updatePwd(Integer id, String oldpwd, String newpwd);

    ServerResponse<PageInfo<Admin>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo<Admin>> getPageInfoByAccount(Integer pageNum, Integer pageSize, String account);

    ServerResponse<Admin> addAdmin(String account, String password);

    ServerResponse<Admin> updateAdmin(Integer id,String account, String password);

    ServerResponse<Admin> deleteAdmin(Integer id);

    ServerResponse<Integer> Getcount();
}
