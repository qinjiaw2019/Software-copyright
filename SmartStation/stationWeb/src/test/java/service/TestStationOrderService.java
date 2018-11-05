package service;

import com.cloud.station.WebappApplication;
import com.cloud.station.pojo.StationOrder;
import com.cloud.station.service.StationOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStationOrderService {

    @Autowired
    StationOrderService stationOrderService;

    @Test
    public void testAddByCarNum(){
        stationOrderService.addByCarNum(25L,"冀Jqjw123");

    }

    @Test
    public void testFind(){
        StationOrder stationOrder = stationOrderService.getByStationIdAndCarNuber(25L,"冀Jqjw123");

    }
    @Test
    public void testUpdate(){
        StationOrder stationOrder = stationOrderService.getByStationIdAndCarNuber(25L,"冀Jqjw123");
        stationOrder.setUserId(1L);
        stationOrder.setEndTime(new Date().getTime());
        stationOrder.setState(StationOrder.NORMAL);
        stationOrderService.update(stationOrder);
    }
}
