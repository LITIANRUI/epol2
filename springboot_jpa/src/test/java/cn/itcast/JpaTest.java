package cn.itcast;

import cn.itcast.domain.User;
import cn.itcast.repository.UserReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class JpaTest {
    @Autowired
    private UserReposity userReposity;

    @Test
    public void test(){
        List<User> list = userReposity.findAll();
        System.out.println(list);
    }
}
