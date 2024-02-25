package com.xunmaw.dormitory.service.impl;

import com.xunmaw.dormitory.dao.DormitoryManagerDao;
import com.xunmaw.dormitory.entity.Admin;
import com.xunmaw.dormitory.dao.AdminDao;
import com.xunmaw.dormitory.entity.DormitoryManager;
import com.xunmaw.dormitory.entity.Student;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.AdminService;
import com.xunmaw.dormitory.util.RedisUtil;
import com.xunmaw.dormitory.util.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.xunmaw.dormitory.dao.StudentDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Admin)表服务实现类
 *
 * 
 * @since 2023-01-14 20:02:10
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private DormitoryManagerDao dormitoryManagerDao;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param admin       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Admin> queryByPage(Admin admin, PageRequest pageRequest) {
        long total = this.adminDao.count(admin);
        return new PageImpl<>(this.adminDao.queryAllByLimit(admin, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adminDao.deleteById(id) > 0;
    }

    /**
     * 三个角色登录的实现
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public ServerResponse<Map<String, Object>> login(String account, String password) {
        //用获取到的账户名和密码在数据库中查找
        Admin admin = adminDao.queryByAccount(account);
        Student student = studentDao.queryByAccount(account);
        DormitoryManager dormitoryManager = dormitoryManagerDao.queryByAccount(account);
        if (admin == null && student == null && dormitoryManager == null)
            return ServerResponse.createByErrorMessage("账户名不存在");
        Admin admin1 = adminDao.queryByPwdAccount(account, password);
        Student student1 = studentDao.queryByPwdAccount(account, password);
        DormitoryManager dormitoryManager1 = dormitoryManagerDao.queryByPwdAccount(account, password);
        if (admin1 == null && student1 == null && dormitoryManager1 == null)
            return ServerResponse.createByErrorMessage("密码输入错误");
        Map<String, Object> map = new HashMap<>();
        if (admin1 != null) {
            map.put("user", admin1);
            map.put("role", 1);
        }
        if (student1 != null) {
            map.put("user", student1);
            map.put("role", 3);
        }
        if (dormitoryManager1 != null) {
            map.put("user", dormitoryManager1);
            map.put("role", 2);
        }
        String token = TokenUtil.token(account, password);
        map.put("token", token);
        redisUtil.set(account, token);//存储token到redis中
        return ServerResponse.createBySuccess("身份验证成功!", map);
    }

    @Override
    public ServerResponse<Map<String, Object>> updatePwd(Integer id, String oldpwd, String newpwd) {
        Admin admin = adminDao.queryById(id);
        Student student = studentDao.queryById(id);
        DormitoryManager dormitoryManager = dormitoryManagerDao.queryById(id);
        if (admin == null && student == null && dormitoryManager == null)
            return ServerResponse.createByErrorMessage("用户不存在，修改密码失败");
        Map<String, Object> map = new HashMap<>();
        if (admin != null && admin.getPassword().equals(oldpwd)) {
            admin.setPassword(newpwd);
            admin.setUpdateTime(new Date());
            admin.setVersion(admin.getVersion() + 1);
            adminDao.update(admin);
            map.put("admin", admin);
        }
        if (student != null && student.getPassword().equals(oldpwd)) {
            student.setPassword(newpwd);
            student.setUpdateTime(new Date());
            student.setVersion(student.getVersion() + 1);
            studentDao.update(student);
            map.put("student", student);
        }
        if (dormitoryManager != null && dormitoryManager.getPassword().equals(oldpwd)) {
            dormitoryManager.setPassword(newpwd);
            dormitoryManager.setUpdateTime(new Date());
            dormitoryManager.setVersion(dormitoryManager.getVersion() + 1);
            dormitoryManagerDao.update(dormitoryManager);
            map.put("dormitoryManager", dormitoryManager);
        }
        if (map.size() == 0) return ServerResponse.createByErrorMessage("旧密码输入错误!");
        return ServerResponse.createBySuccess("修改成功", map);
    }

    @Override
    public ServerResponse<PageInfo<Admin>> getPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = this.adminDao.queryAll();
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        return ServerResponse.createBySuccess("获取分页数据成功!", pageInfo);
    }

    @Override
    public ServerResponse<PageInfo<Admin>> getPageInfoByAccount(Integer pageNum, Integer pageSize, String account) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = this.adminDao.queryAllByAccount(account);
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        return ServerResponse.createBySuccess("获取分页数据成功!", pageInfo);
    }

    @Override
    public ServerResponse<Admin> addAdmin(String account, String password) {
        Admin admin = this.adminDao.queryByAccount(account);
        if (admin != null) return ServerResponse.createByErrorMessage("此账号太受欢迎了,换一个试试吧!");
        Admin admin1 = new Admin();
        admin1.setAccount(account);
        admin1.setPassword(password);
        admin1.setCreateTime(new Date());
        admin1.setUpdateTime(new Date());
        admin1.setVersion(1);
        admin1.setStatus(true);
        int insert = this.adminDao.insert(admin1);
        if (insert!=1) ServerResponse.createByErrorMessage("数据添加失败,请检查服务器!");
        return ServerResponse.createBySuccess("新增成功!",admin1);
    }

    @Override
    public ServerResponse<Admin> updateAdmin(Integer id,String account, String password) {
        Admin admin = this.adminDao.queryByAccount(account);
        if (admin!= null) return ServerResponse.createByErrorMessage("此账号太受欢迎了,换一个试试吧!");
        //如果不存在的话
        Admin admin2 = adminDao.queryById(id);//谁要修改
        admin2.setAccount(account);
        admin2.setPassword(password);
        admin2.setUpdateTime(new Date());
        admin2.setVersion(admin2.getVersion()+1);
        int update = adminDao.update(admin2);
        if (update!=1) return  ServerResponse.createByErrorMessage("数据修改失败,请检查服务器!");
        return ServerResponse.createBySuccess("修改信息成功!",admin2);
    }

    @Override
    public ServerResponse<Admin> deleteAdmin(Integer id) {
        Admin admin = this.adminDao.queryById(id);
        if (admin == null) return ServerResponse.createByErrorMessage("此id对应的用户不存在");
        admin.setStatus(false);
        admin.setUpdateTime(new Date());
        admin.setVersion(admin.getVersion()+1);
        int update = adminDao.update(admin);
        if (update!=1) return  ServerResponse.createByErrorMessage("数据删除失败,请检查服务器!");
        return ServerResponse.createBySuccess("删除用户成功!",admin);
    }

    @Override
    public ServerResponse<Integer> Getcount() {
        return ServerResponse.createBySuccess("超管人数!",this.adminDao.queryAll().size());
    }
}
