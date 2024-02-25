# 数据库设计文档

**数据库名：** building

**文档版本：** 1.0.0

**文档描述：** 数据库表结构文档生成

| 表名                  | 说明       |
| :---: | :---: |
| [admin](#admin) | 超管 |
| [building](#building) | 楼宇 |
| [dormitory](#dormitory) | 宿舍 |
| [dormitory_manager](#dormitory_manager) | 宿管 |
| [liverecord](#liverecord) | 入住记录 |
| [repairrecord](#repairrecord) | 报修记录 |
| [scorerecord](#scorerecord) | 打分记录 |
| [student](#student) | 学生 |

**表名：** <a id="admin">admin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 管理员主键自增  |
|  2   | account |   varchar   | 255 |   0    |    N     |  N   |       | 管理员账户名  |
|  3   | password |   varchar   | 255 |   0    |    N     |  N   |       | 管理员密码  |
|  4   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 创建时间  |
|  5   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 更新时间  |
|  6   | version |   int   | 10 |   0    |    N     |  N   |       | 更新次数  |
|  7   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码是否已经删除  |

**表名：** <a id="building">building</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | bu_id |   int   | 10 |   0    |    N     |  Y   |       | 楼宇id  |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 楼宇名称  |
|  3   | location |   varchar   | 255 |   0    |    N     |  N   |       | 楼宇位置  |
|  4   | d_m_id |   int   | 10 |   0    |    Y     |  N   |       | 宿管id  |
|  5   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 生成时间  |
|  6   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 更新时间  |
|  7   | version |   int   | 10 |   0    |    N     |  N   |       | 更新次数  |
|  8   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码是否删除  |

**表名：** <a id="dormitory">dormitory</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | d_id |   int   | 10 |   0    |    N     |  Y   |       | 宿舍id  |
|  2   | bu_id |   int   | 10 |   0    |    N     |  N   |       | 楼宇id  |
|  3   | name |   varchar   | 255 |   0    |    N     |  N   |       | 宿舍编号或者名称  |
|  4   | floor |   int   | 10 |   0    |    N     |  N   |       | 所在楼层  |
|  5   | lived_number |   int   | 10 |   0    |    N     |  N   |       | 入住人数  |
|  6   | max_number |   int   | 10 |   0    |    N     |  N   |       | 最大人数  |
|  7   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 创建时间  |
|  8   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 修改时间  |
|  9   | version |   int   | 10 |   0    |    N     |  N   |       | 修改次数  |
|  10   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码控制删除  |

**表名：** <a id="dormitory_manager">dormitory_manager</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 宿管id  |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 宿管真实姓名  |
|  3   | account |   varchar   | 255 |   0    |    N     |  N   |       | 登录账号  |
|  4   | password |   varchar   | 255 |   0    |    N     |  N   |       | 宿管登录密码  |
|  5   | sex |   tinyint   | 4 |   0    |    N     |  N   |       | 1男2女  |
|  6   | score |   int   | 10 |   0    |    N     |  N   |       | 宿管评分，按照每一个学生打分去除最高最低取平均分，最高十分，初始为0  |
|  7   | d_manager_num |   varchar   | 255 |   0    |    N     |  N   |       | 宿管编号  |
|  8   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 创建时间  |
|  9   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 更新时间  |
|  10   | version |   int   | 10 |   0    |    N     |  N   |       | 更新次数  |
|  11   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码  |

**表名：** <a id="liverecord">liverecord</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | l_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | live_date |   datetime   | 19 |   0    |    N     |  N   |       | 入住日期  |
|  3   | d_id |   int   | 10 |   0    |    N     |  N   |       | 对应宿舍  |
|  4   | s_id |   int   | 10 |   0    |    N     |  N   |       | 对应学生  |
|  5   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 创建时间  |
|  6   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 更新时间  |
|  7   | version |   int   | 10 |   0    |    N     |  N   |       | 修改次数  |
|  8   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码  |

**表名：** <a id="repairrecord">repairrecord</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | r_id |   int   | 10 |   0    |    N     |  Y   |       | 报修id  |
|  2   | s_id |   int   | 10 |   0    |    N     |  N   |       | 谁报修的根据学生id去查学生所在宿舍  |
|  3   | date |   datetime   | 19 |   0    |    N     |  N   |       | 报修日期  |
|  4   | title |   varchar   | 255 |   0    |    N     |  N   |       | 报修内容  |
|  5   | d_m_id |   int   | 10 |   0    |    Y     |  N   |       | 处理人  |
|  6   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 创建时间  |
|  7   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 修改时间  |
|  8   | version |   int   | 10 |   0    |    N     |  N   |       | 修改次数  |
|  9   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码是否删除  |
|  10   | handle_time |   datetime   | 19 |   0    |    Y     |  N   |       | 处理时间  |

**表名：** <a id="scorerecord">scorerecord</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | score_id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | s_id |   int   | 10 |   0    |    N     |  N   |       | 谁打的分  |
|  3   | d_m_id |   int   | 10 |   0    |    N     |  N   |       | 给谁打的分  |
|  4   | createTime |   datetime   | 19 |   0    |    N     |  N   |       | 打分时间  |
|  5   | number |   int   | 10 |   0    |    N     |  N   |       | 打了多少分  |

**表名：** <a id="student">student</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | s_id |   int   | 10 |   0    |    N     |  Y   |       | 学生id  |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 真实姓名  |
|  3   | account |   varchar   | 255 |   0    |    N     |  N   |       | 账户名  |
|  4   | password |   varchar   | 255 |   0    |    N     |  N   |       | 密码  |
|  5   | s_number |   varchar   | 255 |   0    |    N     |  N   |       | 学号  |
|  6   | sex |   tinyint   | 4 |   0    |    N     |  N   |       | 1表示男，2表示女  |
|  7   | create_time |   datetime   | 19 |   0    |    N     |  N   |       | 创建时间  |
|  8   | update_time |   datetime   | 19 |   0    |    N     |  N   |       | 更新时间  |
|  9   | version |   int   | 10 |   0    |    N     |  N   |       | 更新次数  |
|  10   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 状态码  |
