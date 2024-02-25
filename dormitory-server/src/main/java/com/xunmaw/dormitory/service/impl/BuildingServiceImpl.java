package com.xunmaw.dormitory.service.impl;

import com.xunmaw.dormitory.dao.DormitoryManagerDao;
import com.xunmaw.dormitory.entity.Building;
import com.xunmaw.dormitory.dao.BuildingDao;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.BuildingService;
import com.xunmaw.dormitory.util.DateFormatUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Building)表服务实现类
 *
 * 
 * @since 2023-01-14 15:07:08
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
    @Resource
    private BuildingDao buildingDao;
    @Resource
    private DormitoryManagerDao dormitoryManagerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param buId 主键
     * @return 实例对象
     */
    @Override
    public Building queryById(Integer buId) {
        return this.buildingDao.queryById(buId);
    }

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Building> queryByPage(Building building, PageRequest pageRequest) {
        long total = this.buildingDao.count(building);
        return new PageImpl<>(this.buildingDao.queryAllByLimit(building, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building insert(Building building) {
        this.buildingDao.insert(building);
        return building;
    }

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building update(Building building) {
        this.buildingDao.update(building);
        return this.queryById(building.getBuId());
    }

    /**
     * 通过主键删除数据
     *
     * @param buId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buId) {
        return this.buildingDao.deleteById(buId) > 0;
    }

    @Override
    public ServerResponse<Map<String,Object>> getPageInfoByName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Building> buildings = this.buildingDao.queryAllByName(name);
        PageInfo<Building> buildingPageInfo = new PageInfo<>(buildings);
        int size = buildingPageInfo.getList().size();
        if (size==0) return ServerResponse.createByErrorMessage("暂无数据!换个关键词试试吧!");
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> mapList = new ArrayList<>();
        setBuildingInfo(mapList,buildingPageInfo.getList());
        map.put("list",mapList);
        map.put("total",buildingPageInfo.getTotal());//总数
        map.put("pageNum",buildingPageInfo.getPageNum());//第几页
        map.put("pageSize",buildingPageInfo.getPageSize());//几条数据
        return ServerResponse.createBySuccess("查询成功,共"+size+"条数据",map);
    }

     public void setBuildingInfo(List<Map<String,Object>> mapList,List<Building> buildings){
         for (Building building :buildings){
             Map<String,Object> map = new HashMap<>();//这样做的目的是为了给 楼宇对象新增一个字段, 这样做比较麻烦 可以用 俩边联查的方式实现但是在这里就不试了
             map.put("id",building.getBuId());
             map.put("name",building.getName());
             map.put("location",building.getLocation());
             map.put("dormitoryManager",dormitoryManagerDao.queryById(building.getDMId()));
             map.put("createTime", DateFormatUtil.DataFormat(building.getCreateTime()));//记得转换格式哦
             map.put("updateTime",DateFormatUtil.DataFormat(building.getUpdateTime()));//记得转换格式哦
             map.put("version",building.getVersion());
             map.put("status",building.getStatus());
             mapList.add(map);
         }
    }

    @Override
    public ServerResponse<Map<String,Object>> getPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Building> buildings = this.buildingDao.queryAll();
        PageInfo<Building> buildingPageInfo = new PageInfo<>(buildings);
        Map<String,Object> map = new HashMap<>();//最大的
        List<Map<String,Object>> mapList = new ArrayList<>();//往map里边放的对象
        setBuildingInfo(mapList,buildingPageInfo.getList());
        map.put("list",mapList);
        map.put("total",buildingPageInfo.getTotal());//总数
        map.put("pageNum",buildingPageInfo.getPageNum());//第几页
        map.put("pageSize",buildingPageInfo.getPageSize());//几条数据
        return ServerResponse.createBySuccess("获取分页数据成功!", map);
    }

    @Override
    public ServerResponse<Building> addBuilding(String name, String location) {
        Building building = this.buildingDao.queryByName(name);
        if (building!=null) return ServerResponse.createByErrorMessage("楼宇名称已被他人使用!换一个试试吧");
        Building building1 = new Building(null,name,location,null,new Date(),new Date(),1,true);
        int insert = this.buildingDao.insert(building1);
        if (insert!=1) return   ServerResponse.createByErrorMessage("添加失败,请检查服务器!");
        return ServerResponse.createBySuccess("新增楼宇成功!", building1);
    }

    @Override
    public ServerResponse<Building> updateBuilding(Integer id, String name, String location) {
        Building building = this.buildingDao.queryById(id);
        if (building==null) return  ServerResponse.createByErrorMessage("此数据不存在");
        List<Building> buildings = buildingDao.queryAll();
        int i = buildings.indexOf(building);
        for (int count = 0;count<buildings.size();count++){
            if (count==i) continue;
            if (buildings.get(count).getName().equals(name)) return  ServerResponse.createByErrorMessage("楼宇名称已被他人使用!换一个试试吧");
        }
        building.setName(name);
        building.setLocation(location);
        building.setUpdateTime(new Date());
        building.setVersion(building.getVersion()+1);
        int update = this.buildingDao.update(building);
        if (update!=1) return  ServerResponse.createByErrorMessage("修改失败,请检查服务器!");
        return ServerResponse.createBySuccess("修改楼宇信息成功!", building);
    }

    @Override
    public ServerResponse<Building> deleteBuilding(Integer id) {
        Building building = this.buildingDao.queryById(id);
        if (building==null) return ServerResponse.createByErrorMessage("此数据不存在");
        building.setStatus(false);
        building.setUpdateTime(new Date());
        building.setVersion(building.getVersion()+1);
        int update = this.buildingDao.update(building);
        if (update!=1) return  ServerResponse.createByErrorMessage("删除失败,请检查服务器!");
        return ServerResponse.createBySuccess("已经停用该楼宇!", building);
    }

    @Override
    public ServerResponse<List<Building>> BuildingList() {
        List<Building> buildings = this.buildingDao.queryAll();
        if (buildings.size()==0) return ServerResponse.createByErrorMessage("当前没有楼宇信息!");
        return ServerResponse.createBySuccess("获取全部楼宇信息!",buildings);
    }

}
