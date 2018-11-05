package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.DepotStationStateMapper;
import com.cloud.station.pojo.DepotStationState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDepotStationStateMapper {

    @Autowired
    DepotStationStateMapper depotStationStateMapper;

    @Test
    public void testFindByPrimaryKey(){
        try {
            DepotStationState depotStationState = (DepotStationState) depotStationStateMapper.findByPrimaryKey(2);
            System.out.println(depotStationState.getDepotInfo().getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
