package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Building;
import com.xunmaw.dormitory.entity.DormitoryManager;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.DormitoryManagerService;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DormitoryManager)表控制层
 *
 * 
 * @since 2023-01-14 15:07:26
 */
@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {
    /**
     * 服务对象
     */
    @Resource
    private DormitoryManagerService dormitoryManagerService;

    /**
     * 分页查询
     *
     * @param dormitoryManager 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DormitoryManager>> queryByPage(DormitoryManager dormitoryManager, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dormitoryManagerService.queryByPage(dormitoryManager, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DormitoryManager> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dormitoryManagerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dormitoryManager 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DormitoryManager> add(DormitoryManager dormitoryManager) {
        return ResponseEntity.ok(this.dormitoryManagerService.insert(dormitoryManager));
    }

    /**
     * 编辑数据
     *
     * @param dormitoryManager 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DormitoryManager> edit(DormitoryManager dormitoryManager) {
        return ResponseEntity.ok(this.dormitoryManagerService.update(dormitoryManager));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dormitoryManagerService.deleteById(id));
    }

    @GetMapping("/GetPageAll")
    public ServerResponse<PageInfo<DormitoryManager>> GetPageAll(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(name = "account", defaultValue = "") String account,
            @RequestParam(name = "name",defaultValue = "") String name) {
        if (!"".equals(account)){
            return this.dormitoryManagerService.getPageInfoByAccount(pageNum,pageSize,account);//模糊查询账户名
        }
        if (!"".equals(name)){
            return this.dormitoryManagerService.getPageInfoByName(pageNum,pageSize,name);//姓名模糊查询
        }
        else {
            return this.dormitoryManagerService.getPageInfo(pageNum, pageSize);
        }
    }

    @GetMapping("/addDorManager")
    public ServerResponse<DormitoryManager> addDorManager(@RequestParam("name") String name,
                                               @RequestParam("number") String number,
                                               @RequestParam("account") String account,
                                               @RequestParam("password") String password,
                                               @RequestParam("sex") Integer sex
                                          ) {
        return this.dormitoryManagerService.addDorManager(name,number,account,password,sex);
    }

    @RequestMapping("/updateDorManager")
    public ServerResponse<DormitoryManager> updateDorManager(@RequestParam("id") Integer id,
                                                            @RequestParam("name") String name,
                                                          @RequestParam("number") String number,
                                                          @RequestParam("account") String account,
                                                          @RequestParam("password") String password,
                                                          @RequestParam("sex") Integer sex) {
        return this.dormitoryManagerService.updateDorManager(id,name,number,account,password,sex);
    }

    @RequestMapping("/deleteDroManager")
    public ServerResponse<DormitoryManager> deleteDroManager(@RequestParam("id") Integer id) {
        return this.dormitoryManagerService.deleteDroManager(id);
    }

    @RequestMapping("/count")
    public ServerResponse<Integer> getCount() {
        return this.dormitoryManagerService.getCount();
    }

    @RequestMapping("/getscore")
    public ServerResponse<Integer> getscore(@RequestParam("mid") Integer mid) {
        return this.dormitoryManagerService.getscore(mid);
    }

    @RequestMapping("/changeManager")
    public ServerResponse<Building> changeManager(@RequestParam("mid") Integer mid, @RequestParam("id") Integer id) {
        return this.dormitoryManagerService.changeManager(mid,id);
    }


}

