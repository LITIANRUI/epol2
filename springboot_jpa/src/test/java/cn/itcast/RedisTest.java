package cn.itcast;

import cn.itcast.domain.User;
import cn.itcast.repository.UserReposity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserReposity userReposity;

    @Test
    public void test() throws JsonProcessingException {
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();

        if(null == userListJson){
            List<User> list = userReposity.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(list);
            redisTemplate.boundValueOps("user.findAll").set(s);

            System.out.println("=======从mysql中获取=======");
            System.out.println(s);
        }else{
            System.out.println("=======从redis中获取=======");
            System.out.println(userListJson);
        }


    }
}
