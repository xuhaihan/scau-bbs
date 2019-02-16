package com.scau.bbs.common;

import com.scau.bbs.common.dao.LabelDao;
import com.scau.bbs.common.dao.NotificationDao;
import com.scau.bbs.common.dao.PostsDao;
import com.scau.bbs.common.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * Created by xhh on 2019/1/09
 */
@RunWith(SpringRunner.class)
@EnableCaching//缓存支持
@SpringBootTest
public class CommonApplicationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDao UserDao;

    @Autowired
    private PostsDao postsDao;

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private NotificationDao notificationDao;

    @Test
    public void TestDataSource(){
//        long count = notificationDao.getNotificationCount(72);
//        System.out.println(count);
//        List<Notification> list = notificationDao.getByTouser(UserDao.findOne(2));
//        System.out.println(list);
//        list.forEach(t->{
//            System.out.println(t.getPosts().getTitle());
//        });
    }
}
