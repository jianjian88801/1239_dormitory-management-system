package com.xunmaw.dormitory;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import com.xunmaw.dormitory.dao.*;
import com.xunmaw.dormitory.service.DormitoryService;
import com.xunmaw.dormitory.service.StudentService;
import com.xunmaw.dormitory.util.RedisUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;

@SpringBootTest
class DormitoryApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private DormitoryManagerDao dormitoryManagerDao;
    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private LiverecordDao liverecordDao;
    @Autowired
    private RepairrecordDao repairrecordDao;

    @Test
    void set() {
//        redisUtil.set("code","1233");
//       System.out.println(redisUtil.get("code"));
//       System.out.println(redisUtil.detele("code"));
//       System.out.println(dormitoryManagerDao.queryById(1));
//       System.out.println(dormitoryManagerDao.queryAllByAccount("z"));
//       System.out.println(dormitoryManagerDao.queryAllByName("张"));
//       Dormitory dormitory = dormitoryDao.queryById(3);
//       System.out.println(dormitory);
//       dormitory.setStatus(false);
//       System.out.println(dormitoryDao.update(dormitory));
//       System.out.println(dormitoryService.deleteDormitory(3));
//       System.out.println(studentDao.queryAll());

    }

    @Test
    void contextLoads() {

//        boolean init = redisDBHelper.init("localhost",6379);
//        System.out.println(init);
//        redisDBHelper.set("code","123123");

//        System.out.println(redisDBHelper.get("code"));
//        List<RepairrecordSql> repairrecordSqls = repairrecordDao.queryAll();
//        List<RepairrecordSql> repairrecordSqls1 = repairrecordDao.queryAllByName("小");
//        System.out.println(repairrecordSqls);
//        System.out.println(repairrecordSqls1);
    }

    @Test
    void abc(){
//        List<String> list = new ArrayList<>();
//        list.add("你好");
//        list.add("我好");
//        list.add("大家好");
//        list.add("才是真的好");
//
//        String keyword = "好";
//
//        List<String> answer1 = new ArrayList<>();
//
//        answer1.addAll(list.stream().filter(one -> one.contains(keyword)).collect(Collectors.toList()));
//
//        System.out.println("1. String的contains方法");
//        answer2.forEach(System.out::println);
//        List<String> answer3 = new ArrayList<>();
//        answer3.addAll(list.stream().filter(one -> one.indexOf(keyword) > -1).collect(Collectors.toList()));
//        System.out.println("3. String的indexOf方法,大于-1说明找得到");
//        answer3.forEach(System.out::println);
    }
    @Test
    void test123(){
        System.out.println(studentDao.queryAllCount());
//        Optional<Pig> pig MaxAgeOptional = pigs.stream().collect(Collectors.maxBy(comparing(Pig::getAge)));
//        if (pigMaxAgeOptional.isPresent()){
//            System.out.println("age最大的猪 = " + pigMaxAgeOptional.get());
//        }
//
//        Optional<Pig> pigMinAgeOptional = pigs.stream().collect(Collectors.minBy(comparing(Pig::getAge)));
//        if (pigMinAgeOptional.isPresent()){
//            System.out.println("age最小的猪 = " + pigMinAgeOptional.get());
//        }

    }

   @Test
   void tablecreate(){
       // 配置数据源
       HikariConfig hikariConfig = new HikariConfig();
       hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
       hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/building");
       hikariConfig.setUsername("root");
       hikariConfig.setPassword("root");

       // 配置获取数据库表的备注信息
       hikariConfig.addDataSourceProperty("building", "true");

       DataSource dataSource = new HikariDataSource(hikariConfig);

       // 配置生成方式
       EngineConfig engineConfig = EngineConfig.builder()
               // 生成文件路径
               .fileOutputDir("D:\\Desktop")
               // 打开目录
               .openOutputDir(true)
               // 文件类型
               .fileType(EngineFileType.WORD)
               // 生成使用的模板
               .produceType(EngineTemplateType.freemarker)
               // 自定义文件名称
               .fileName("DataBaseDocument")
               .build();

       // 配置忽略的表
       ArrayList<String> ignoreTableName = new ArrayList<>();
       ignoreTableName.add("test_user");
       ignoreTableName.add("test_group");
       // 配置忽略指定前缀的表
       ArrayList<String> ignoreTablePrefix = new ArrayList<>();
       ignoreTablePrefix.add("test_");
       // 配置忽略指定后缀的表
       ArrayList<String> ignoreTableSuffix = new ArrayList<>();
       ignoreTableSuffix.add("_test");

       // 配置数据库表结构文档生成过程
//       ProcessConfig processConfig = ProcessConfig.build();
               /*
                * 指定生成逻辑:
                * 	- 如果存在指定的表,指定的表前缀,指定的表后缀时.会生成指定的表,其余表不会生成并且跳过忽略表配置
                * 	- 如果未指定,会生成忽略表配置的其余所有的表
                */
               // 生成指定名称的表
//               .designatedTableName(new ArrayList<>())
               // 生成指定前缀的表
//               .designatedTablePrefix(new ArrayList<>())
               // 生成指定后缀的表
//               .designatedTableSuffix(new ArrayList<>())
               // 忽略指定名称的表
//               .ignoreTableName(ignoreTableName)
               // 忽略指定前缀的表
//               .ignoreTablePrefix(ignoreTablePrefix)
               // 忽略指定后缀的表
//               .ignoreTableSuffix(ignoreTableSuffix)
//               .build();

       // 文档生成信息配置
       Configuration config = Configuration.builder()
               // 文档版本
               .version("1.0.0")
               // 文档描述
               .description("数据库表结构文档生成")
               // 数据源
               .dataSource(dataSource)
               // 生成配置
               .engineConfig(engineConfig)
               // 执行配置
//               .produceConfig(processConfig)
               .build();
       // 执行
       new DocumentationExecute(config).execute();
   }
}
