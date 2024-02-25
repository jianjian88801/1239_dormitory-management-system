package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Building;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.BuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Building)表控制层
 *
 *
 * @since 2023-01-14 15:07:08
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingService buildingService;

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Building>> queryByPage(Building building, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingService.queryByPage(building, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Building> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param building 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Building> add(Building building) {
        return ResponseEntity.ok(this.buildingService.insert(building));
    }

    /**
     * 编辑数据
     *
     * @param building 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Building> edit(Building building) {
        return ResponseEntity.ok(this.buildingService.update(building));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildingService.deleteById(id));
    }

    @GetMapping("/GetPageAll")
    public ServerResponse<Map<String,Object>> GetPageAll(@RequestParam("pageNum") Integer pageNum,
														 @RequestParam("pageSize") Integer pageSize,
														 @RequestParam(name = "name",defaultValue = "") String name) {
        if (!"".equals(name)){
            return this.buildingService.getPageInfoByName(pageNum,pageSize,name);//楼宇名称模糊查询
        }
        else {
            return this.buildingService.getPageInfo(pageNum, pageSize);//全部分页
        }
    }

    @RequestMapping("/addBuilding")
    public ServerResponse<Building> addBuilding(@RequestParam("name") String name,
                                          @RequestParam("location") String location) {
        return this.buildingService.addBuilding(name,location);
    }
    @RequestMapping("/updateBuilding")
    public ServerResponse<Building> updateBuilding(@RequestParam("id") Integer id,@RequestParam("name") String name,
                                                @RequestParam("location") String location) {
        return this.buildingService.updateBuilding(id,name,location);
    }

    @RequestMapping("/deleteBuilding")
    public ServerResponse<Building> deleteBuilding(@RequestParam("id") Integer id) {
        return this.buildingService.deleteBuilding(id);
    }

    @RequestMapping("/BuildingList")
    public ServerResponse<List<Building>> BuildingList() {
        return this.buildingService.BuildingList();
    }
}

