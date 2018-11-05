package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.CarNumberUsedMapper;
import com.cloud.station.pojo.CarNumberUsed;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCarNumberUsed {

    @Autowired
    CarNumberUsedMapper carNumberUsedMapper;

    @Test
    public void testInsert(){
        CarNumberUsed carNumberUsed = new CarNumberUsed();
        carNumberUsed.setCarNumberId(1L);
        carNumberUsed.setUserId(1L);
        carNumberUsed.setCreateTime(new Date().getTime());

        try {
            Integer rst = carNumberUsedMapper.insert(carNumberUsed);
            Assert.assertTrue(rst==1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
