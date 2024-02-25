package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Liverecord;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.LiverecordService;
import com.xunmaw.dormitory.sql.LiveRecordSql;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Liverecord)表控制层
 *
 * 
 * @since 2023-01-14 15:07:34
 */
@RestController
@RequestMapping("liverecord")
public class LiverecordController {
    /**
     * 服务对象
     */
    @Resource
    private LiverecordService liverecordService;

    /**
     * 分页查询
     *
     * @param liverecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Liverecord>> queryByPage(Liverecord liverecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.liverecordService.queryByPage(liverecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Liverecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.liverecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param liverecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Liverecord> add(Liverecord liverecord) {
        return ResponseEntity.ok(this.liverecordService.insert(liverecord));
    }

    /**
     * 编辑数据
     *
     * @param liverecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Liverecord> edit(Liverecord liverecord) {
        return ResponseEntity.ok(this.liverecordService.update(liverecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.liverecordService.deleteById(id));
    }

    @RequestMapping("/GetPageAll")
    public ServerResponse<PageInfo<LiveRecordSql>> GetPageAll(@RequestParam("pageNum") Integer pageNum,
															  @RequestParam("pageSize") Integer pageSize,
															  @RequestParam(name = "name",defaultValue = "") String name) {
        if (!"".equals(name)){
            return this.liverecordService.getPageInfoByName(pageNum,pageSize,name);//宿舍名称模糊查询
        }
        else {
            return this.liverecordService.getPageInfo(pageNum, pageSize);//全部分页
        }
    }

    @RequestMapping("/addLive")
    public  ServerResponse<Liverecord> addLive(@RequestParam("sid") Integer sid,@RequestParam("did") Integer did){
            return this.liverecordService.addLive(sid, did);
        }

    @RequestMapping("/updateLive")
    public  ServerResponse<Liverecord> updateLive( @RequestParam("id") Integer id, @RequestParam("sid") Integer sid,@RequestParam("did") Integer did){
        return this.liverecordService.updateLive(id,sid, did);
    }

    @RequestMapping("/deleteLive")
    public  ServerResponse<Liverecord> deleteLive( @RequestParam("id") Integer id){
        return this.liverecordService.deleteLive(id);
    }
}

