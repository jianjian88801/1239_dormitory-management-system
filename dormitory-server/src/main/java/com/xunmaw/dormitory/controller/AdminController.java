package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Admin;
import com.xunmaw.dormitory.service.AdminService;
import com.xunmaw.dormitory.response.ServerResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Admin)表控制层
 *
 *
 * @since 2023-01-14 20:02:07
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Admin>> queryByPage(Admin admin, PageRequest pageRequest) {
        return ResponseEntity.ok(this.adminService.queryByPage(admin, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Admin> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.adminService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Admin> add(Admin admin) {
        return ResponseEntity.ok(this.adminService.insert(admin));
    }

    /**
     * 编辑数据
     *
     * @param admin 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Admin> edit(Admin admin) {
        return ResponseEntity.ok(this.adminService.update(admin));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.adminService.deleteById(id));
    }

    @GetMapping("/uppwd")
    public ServerResponse<Map<String,Object>> updatePwd(@RequestParam("id") Integer id,
														@RequestParam("oldpwd") String oldpwd,
														@RequestParam("newpwd") String newpwd) {

        return this.adminService.updatePwd(id,oldpwd,newpwd);
    }

        @GetMapping("/GetPageAll")
    public ServerResponse<PageInfo<Admin>> GetPageAll(@RequestParam("pageNum") Integer pageNum,
                                                         @RequestParam("pageSize") Integer pageSize,
                                                         @RequestParam(name = "account",defaultValue = "") String account) {
        if (!"".equals(account)){
            return this.adminService.getPageInfoByAccount(pageNum,pageSize,account);//模糊查询账户名
        }else {
            return this.adminService.getPageInfo(pageNum, pageSize);
        }
    }

    @GetMapping("/addAdmin")
    public ServerResponse<Admin> addAdmin(@RequestParam("account") String account,
                                                    @RequestParam("password") String password) {
        return this.adminService.addAdmin(account,password);
    }

    @GetMapping("/updateAdmin")
    public ServerResponse<Admin> updateAdmin(@RequestParam("id") Integer id,@RequestParam("account") String account,
                                          @RequestParam("password") String password) {
        return this.adminService.updateAdmin(id,account,password);
    }

    @GetMapping("/deleteAdmin")
    public ServerResponse<Admin> deleteAdmin(@RequestParam("id") Integer id) {
        return this.adminService.deleteAdmin(id);
    }

    @RequestMapping("/count")
    public ServerResponse<Integer> Getcount() {
        return this.adminService.Getcount();
    }

}

