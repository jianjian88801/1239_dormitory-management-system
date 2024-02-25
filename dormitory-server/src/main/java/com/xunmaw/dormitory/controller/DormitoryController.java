package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Dormitory;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.DormitoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Dormitory)表控制层
 *
 * 
 * @since 2023-01-14 15:07:18
 */
@RestController
@RequestMapping("dormitory")
public class DormitoryController {
    /**
     * 服务对象
     */
    @Resource
    private DormitoryService dormitoryService;

    /**
     * 分页查询
     *
     * @param dormitory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Dormitory>> queryByPage(Dormitory dormitory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dormitoryService.queryByPage(dormitory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Dormitory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dormitoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dormitory 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Dormitory> add(Dormitory dormitory) {
        return ResponseEntity.ok(this.dormitoryService.insert(dormitory));
    }

    /**
     * 编辑数据
     *
     * @param dormitory 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Dormitory> edit(Dormitory dormitory) {
        return ResponseEntity.ok(this.dormitoryService.update(dormitory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dormitoryService.deleteById(id));
    }

    @GetMapping("/GetPageAll")
    public ServerResponse<Map<String,Object>> GetPageAll(@RequestParam("pageNum") Integer pageNum,
														 @RequestParam("pageSize") Integer pageSize,
														 @RequestParam(name = "name",defaultValue = "") String name) {
        if (!"".equals(name)){
            return this.dormitoryService.getPageInfoByName(pageNum,pageSize,name);//宿舍名称模糊查询
        }
        else {
            return this.dormitoryService.getPageInfo(pageNum, pageSize);//全部分页
        }
    }

    @RequestMapping("/addDormitory")
    public ServerResponse<Dormitory> addDormitory(@RequestParam("name") String name,
                                                         @RequestParam("floor") Integer floor,
                                                         @RequestParam("buid") Integer buid,
                                                           @RequestParam("maxNumber") Integer maxNumber ) {
            return this.dormitoryService.addDormitory(name,floor,buid,maxNumber);
    }

    @RequestMapping("/updateDormitory")
    public ServerResponse<Dormitory> updateDormitory(@RequestParam("id") Integer id,@RequestParam("name") String name,
                                                  @RequestParam("floor") Integer floor,
                                                  @RequestParam("buid") Integer buid,
                                                  @RequestParam("maxNumber") Integer maxNumber ) {
        return this.dormitoryService.updateDormitory(id,name,floor,buid,maxNumber);
    }

    @RequestMapping("/deleteDormitory")
    public ServerResponse<Dormitory> deleteDormitory(@RequestParam("id") Integer id) {
        return this.dormitoryService.deleteDormitory(id);
    }

    @RequestMapping("/getdormitoryList")
    public ServerResponse<List<Dormitory>> getdormitoryList() {
        return this.dormitoryService.getdormitoryList();
    }
    @RequestMapping("/getolddormitoryList")
    public ServerResponse<List<Dormitory>> getolddormitoryList() {
        return this.dormitoryService.getolddormitoryList();
    }

    @RequestMapping("/countDor")
    public ServerResponse<Map<String,Object>> getCountDor() {
        return this.dormitoryService.getCountDor();
    }

}

