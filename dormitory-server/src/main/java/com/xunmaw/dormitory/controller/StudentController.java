package com.xunmaw.dormitory.controller;

import com.xunmaw.dormitory.entity.Student;
import com.xunmaw.dormitory.response.ServerResponse;
import com.xunmaw.dormitory.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表控制层
 *
 * 
 * @since 2023-01-15 18:36:28
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询
     *
     * @param student 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Student>> queryByPage(Student student, PageRequest pageRequest) {
        return ResponseEntity.ok(this.studentService.queryByPage(student, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Student> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.studentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param student 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Student> add(Student student) {
        return ResponseEntity.ok(this.studentService.insert(student));
    }

    /**
     * 编辑数据
     *
     * @param student 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Student> edit(Student student) {
        return ResponseEntity.ok(this.studentService.update(student));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.studentService.deleteById(id));
    }

    @GetMapping("/GetPageAll")
    public ServerResponse<PageInfo<Student>> GetPageAll(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(name = "account", defaultValue = "") String account,
            @RequestParam(name = "name",defaultValue = "") String name) {
        if (!"".equals(account)){
            return this.studentService.getPageInfoByAccount(pageNum,pageSize,account);//模糊查询账户名
        }
        if (!"".equals(name)){
            return this.studentService.getPageInfoByName(pageNum,pageSize,name);//姓名模糊查询
        }
        else {
            return this.studentService.getPageInfo(pageNum, pageSize);
        }
    }

    @RequestMapping("/updateStudent")
    public ServerResponse<Student> updateStudent(@RequestParam("id") Integer id,
                                                             @RequestParam("name") String name,
                                                             @RequestParam("number") String number,
                                                             @RequestParam("account") String account,
                                                             @RequestParam("password") String password,
                                                             @RequestParam("sex") Integer sex
    ) {
        return this.studentService.updateStudent(id,name,number,account,password,sex);
    }

    @RequestMapping("/addStudent")
    public ServerResponse<Student> addStudent(@RequestParam("name") String name,
                                                          @RequestParam("number") String number,
                                                          @RequestParam("account") String account,
                                                          @RequestParam("password") String password,
                                                          @RequestParam("sex") Integer sex
    ) {
        return this.studentService.addStudent(name,number,account,password,sex);
    }

    @RequestMapping("/deleteStudent")
    public ServerResponse<Student> deleteStudent(@RequestParam("id") Integer id) {
        return this.studentService.deleteStudent(id);
    }
    @RequestMapping("/getstudentList")
    public ServerResponse<List<Student>> getstudnetList() {
        return this.studentService.getstudnetList();
    }

    @RequestMapping("/getoldstudentList")
    public ServerResponse<List<Student>> getoldstudentList() {
        return this.studentService.getoldstudentList();
    }

    @RequestMapping("/count")
    public ServerResponse<Integer> studentListCount() {
        return this.studentService.studentListCount();
    }

}

