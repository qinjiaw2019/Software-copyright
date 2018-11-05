package redis;

import com.cloud.station.WebappApplication;
import com.cloud.station.algorithm.Distance;
import com.cloud.station.pojo.dto.Position;
import com.cloud.station.service.redis.StationStateRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStationStateRedis {

    @Autowired
    StationStateRedis stationStateRedis;
    @Test
    public void testGetByLatAndLon(){
//        Position position = Distance.calcPosition(lat,lng,distance);

    }
}
