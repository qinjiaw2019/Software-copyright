package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.CarNumberBlacklistMapper;
import com.cloud.station.pojo.CarNumberBlacklist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserBlackList {
    @Autowired
    CarNumberBlacklistMapper userBlacklistMapper;

    @Test
    public void testInsert(){
        CarNumberBlacklist userBlacklist = new CarNumberBlacklist();
        userBlacklist.setCarNum("辽C210500");


        try {
            userBlacklistMapper.insert(userBlacklist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByPrimaryKey(){
        try {
            userBlacklistMapper.findByPrimaryKey(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        CarNumberBlacklist userBlacklist = null;
        try {
            userBlacklist = (CarNumberBlacklist) userBlacklistMapper.findByPrimaryKey(1L);
            userBlacklist.setCarNum("辽C210500");
            userBlacklist.setUserId(3L);
            userBlacklist.setOweTime(new Date().getTime());
            userBlacklist.setDisposeTime(80L);
            userBlacklist.setOweAmount(39f);
            userBlacklist.setOweMoneyTime(4L);
            userBlacklistMapper.update(userBlacklist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByPrimaryKey(){
        try {
            userBlacklistMapper.deleteByPrimaryKey(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind(){
        CarNumberBlacklist userBlacklist = new CarNumberBlacklist();
        userBlacklist.setCarNum("辽C210500");
        try {
            userBlacklistMapper.find(userBlacklist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
