package com.yl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 常用注解
 *
 * @TableName("mpdemo"): 表名和实体类不一致时使用该注解, 指定实体对应的表名
 * @TableId: 默认会将实体的id作为主键, 使用这个注解可以指定其他字段作为主键
 * @TableField("name") 当实体字段名与列名不一致时, 可以通过这个注解修改对应的数据库字段
 * <p>
 * 排除非表字段的三种方式
 * 1.private transient String remark:  transient 关键字修饰的不会参与序列化中
 * 2.private static String remark: static修饰的不会被mp对应为表的字段
 * 3.@TableField(exist = false): 增加注解,默认为true
 */

@Data
@TableName("mpdemo")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
}
