package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Repairrecord;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.RepairrecordService;
import com.xunmaw.dormitory.sql.RepairrecordSql;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Repairrecord)表控制层
 *
 * 
 * @since 2023-01-14 15:07:45
 */
@RestController
@RequestMapping("repairrecord")
public class RepairrecordController {
    /**
     * 服务对象
     */
    @Resource
    private RepairrecordService repairrecordService;

    /**
     * 分页查询
     *
     * @param repairrecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Repairrecord>> queryByPage(Repairrecord repairrecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.repairrecordService.queryByPage(repairrecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Repairrecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repairrecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param repairrecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Repairrecord> add(Repairrecord repairrecord) {
        return ResponseEntity.ok(this.repairrecordService.insert(repairrecord));
    }

    /**
     * 编辑数据
     *
     * @param repairrecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Repairrecord> edit(Repairrecord repairrecord) {
        return ResponseEntity.ok(this.repairrecordService.update(repairrecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.repairrecordService.deleteById(id));
    }

    @RequestMapping("/GetPageAll")
    public ServerResponse<PageInfo<RepairrecordSql>> GetPageAll(@RequestParam("pageNum") Integer pageNum,
																@RequestParam("pageSize") Integer pageSize,
																@RequestParam(name = "name",defaultValue = "") String name) {
        if (!"".equals(name)){
            return this.repairrecordService.getPageInfoByName(pageNum,pageSize,name);//报修人姓名模糊查询
        }
        else {
            return this.repairrecordService.getPageInfo(pageNum, pageSize);//全部分页
        }
    }
    @RequestMapping("/addRepair")
    public ServerResponse<Repairrecord> addRepair(@RequestParam("sid") Integer sid, @RequestParam("title") String title) {
            return this.repairrecordService.addRepair(sid,title);
    }

    @RequestMapping("/updateRepair")
    public ServerResponse<Repairrecord> updateRepair(@RequestParam("did") Integer did,@RequestParam("id") Integer id) {
        return this.repairrecordService.updateRepair(did,id);
    }

    @RequestMapping("/deleteRepair")
    public ServerResponse<Repairrecord> deleteRepair(@RequestParam("id") Integer id) {
        return this.repairrecordService.deleteRepair(id);
    }
}

