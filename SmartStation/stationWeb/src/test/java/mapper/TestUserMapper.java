package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.UserInfoMapper;
import com.cloud.station.pojo.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserMapper {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void testInsert() throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount("13507278024");
        userInfo.setTel("13507278024");
        userInfo.setMoney(55.2f);
        userInfo.setFace("m/2.png");
        userInfo.setRankPoints(10);
        userInfo.setIdCard("422802199512027419");
        userInfo.setReputationPoints(20);
        userInfo.setPwd("abc123");
        userInfo.setCreateTime(new Date().getTime());
        int rst = userInfoMapper.insert(userInfo);

        Assert.assertTrue(rst==1);
    }

    @Test
    public void testDelete() throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfoMapper.delete(userInfo);
    }

    @Test
    public void testCount() throws Exception{
        long rst = userInfoMapper.count();
        System.out.println(rst);
    }

    @Test
    public void testFindPasswordByAccount() throws Exception{
       String password = userInfoMapper.findPasswordByAccount("4123434");
        System.out.println(password);
    }
}
