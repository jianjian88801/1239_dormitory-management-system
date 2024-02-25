package com.xunmaw.dormitory.service;

import com.xunmaw.dormitory.entity.Student;
import com.xunmaw.dormitory.response.ServerResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * 
 * @since 2023-01-15 18:36:31
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Student queryById(Integer sId);

    /**
     * 分页查询
     *
     * @param student 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Student> queryByPage(Student student, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sId);

    ServerResponse<PageInfo<Student>> getPageInfoByAccount(Integer pageNum, Integer pageSize, String account);

    ServerResponse<PageInfo<Student>> getPageInfoByName(Integer pageNum, Integer pageSize, String name);

    ServerResponse<PageInfo<Student>> getPageInfo(Integer pageNum, Integer pageSize);

    ServerResponse<Student> updateStudent(Integer id, String name, String number, String account, String password, Integer sex);

    ServerResponse<Student> addStudent(String name, String number, String account, String password, Integer sex);

    ServerResponse<Student> deleteStudent(Integer id);

    ServerResponse<List<Student>> getstudnetList();

    ServerResponse<List<Student>> getoldstudentList();

    ServerResponse<Integer> studentListCount();
}
