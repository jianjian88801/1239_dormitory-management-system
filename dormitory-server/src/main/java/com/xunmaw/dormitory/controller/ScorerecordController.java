package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Scorerecord;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.ScorerecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Scorerecord)表控制层
 *
 * 
 * @since 2023-01-16 04:08:42
 */
@RestController
@RequestMapping("scorerecord")
public class  ScorerecordController {
    /**
     * 服务对象
     */
    @Resource
    private ScorerecordService scorerecordService;

    /**
     * 分页查询
     *
     * @param scorerecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Scorerecord>> queryByPage(Scorerecord scorerecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.scorerecordService.queryByPage(scorerecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Scorerecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.scorerecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param scorerecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Scorerecord> add(Scorerecord scorerecord) {
        return ResponseEntity.ok(this.scorerecordService.insert(scorerecord));
    }

    /**
     * 编辑数据
     *
     * @param scorerecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Scorerecord> edit(Scorerecord scorerecord) {
        return ResponseEntity.ok(this.scorerecordService.update(scorerecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.scorerecordService.deleteById(id));
    }

    @RequestMapping("/ScoreAdd")
    public ServerResponse<Scorerecord> ScoreAdd(@RequestParam("sid") Integer sid, @RequestParam("mid") Integer mid, @RequestParam("score") Integer score) {
        return this.scorerecordService.ScoreAdd(sid,mid,score);
    }

}

