package controller;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.UserInfoMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserInfo {

    @Autowired
    UserInfoMapper userInfoMapper;


}
