package com.yl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yl.mapper.UserMapper;
import com.yl.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

// https://blog.csdn.net/hxyascx/article/details/95590031
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    private UserMapper userMapper;

    //1.根据主键查找
    @Test
    public void selectById() {

        User user = userMapper.selectById(1);
        System.out.println(user);

    }

    //2.根据主键查询多个
    @Test
    public void selectBatchIds() {

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2));
        users.forEach(System.out::println);
    }

    /******************************************QueryWrapper******************/

    /**
     * 3.名字中包含oss并且年龄小于40
     * name like '%oss%' and age < 40
     */
    @Test
    public void selectByWrapper() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name", "oss")
                .lt("age", 40);
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);

    }

    /**
     * 4.名字中包含oss并且年龄大于等于20且小于等于40并且email不为空
     * name like '%oss%' and age between 20 and 40 and email is not null
     */
    @Test
    public void selectByWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "oss")
                .between("age", 20, 40)
                .isNotNull("email");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 5.创建日期为2019年7月11日并且直属上级为名字以Boss结尾
     * date_format(create_time,'%Y-%m-%d') and manager_id in (select id from mpdemo where name like '%Boss')
     */
    @Test
    public void selectByWrapper3() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}", "2019-07-11")
                .inSql("manager_id", "select id from mpdemo where name like '%Boss'");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * 6.名字以Boss结尾并且（年龄小于40或邮箱不为空）
     * name like '%Boss' and (age < 40 or email is not null)
     */
    @Test
    public void selectByWrapper4() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("name", "Boss")
                .and(wq -> wq.lt("age", 40).or().isNotNull("email"));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 7.名字以Boss结尾或者（年龄小于40并且年龄大于20并且邮箱不为空）
     * name like '%Boss' or (age < 40 and age > 20 and email is not null)
     */
    @Test
    public void selectByWrapper5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("name", "Boss")
                .or(wq -> wq.lt("age", "40").gt("age", 40).isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * 8.（年龄小于40或邮箱不为空）并且 名字以Boss结尾
     * (age < 40 or email is not null) and name like '%Boss'
     */
    @Test
    public void selectByWrapper6() {

       /* QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.or(wq -> wq.lt("age", "40").isNotNull("email"));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);*/

    }


    /**
     * 9.年龄为30 31 34 35
     * age in (30,31,34,35)
     */
    @Test
    public void selectByWrapper7() {

    }

    /**
     * 10.年龄为30 31 34 35 只返回一条
     * age in (30,31,34,35) limit 1
     */
    @Test
    public void selectByWrapper8() {

    }

    /**
     * 11. 只查出固定字段 只查询id name
     */
    @Test
    public void selectByWrapper9() {

    }

    /**
     * 12.查询过滤固定字段 不查询 manager_id create_time
     */
    @Test
    public void selectByWrapper10() {

    }

    /**
     * 13.重载方法第一个参数 condition true的时候才会加入到sql中
     */
    @Test
    public void condition() {

    }

    /**
     * 14.lambda表达式 名字中包含oss并且年龄小于40
     * name like '%oss%' and age < 40
     */
    @Test
    public void selectLambda() {

    }

    /**
     * 15.也提供了lambda链式调用的方法
     */
    @Test
    public void selectLambda2() {

    }

    /**
     * 16.分页查询
     */
    @Test
    public void selectPage() {

    }

    /****************************************update**********************/

    /**
     * 17.根据id更新用户信息
     */
    @Test
    public void updateById() {

    }

    /**
     * 18.需要传入两个参数 第一个是要修改的实体 第二个是查询的条件
     */
    @Test
    public void updateByWrapper() {

    }

    /**
     * 19.也可以使用userUpdateWrapper都set方法设置要改变都值
     */
    @Test
    public void updateByWrapper1() {

    }

    /**
     * 20.删除
     */
    @Test
    public void deleteById() {
    }

    /**
     * 21.查询或更新
     * 有id且根据id没有查到则进行更新 没有则进行新增
     */
    @Test
    public void insertOrUpdate() {
    }

}
