package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.StationOrderMapper;
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
public class TestStationOrder {

    @Autowired
    StationOrderMapper stationOrderMapper;

    @Autowired
    StationOrderService stationOrderService;

    @Test
    public void testInsert(){
        StationOrder stationOrder = new StationOrder();

        stationOrder.setStationId(20L);
        stationOrder.setCarNum("冀Jqjw123");

        try {
            stationOrderService.addByCarNum(20L,"冀Jqjw123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            stationOrderMapper.delete(2L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        StationOrder stationOrder = new StationOrder();
        stationOrder.setId(4L);
        stationOrder.setUserId(4L);
        stationOrder.setStationId(25L);
        stationOrder.setCreateTime(new Date().getTime());
        stationOrder.setState(1);

        try {
            stationOrderMapper.update(stationOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind(){
        StationOrder stationOrder = new StationOrder();
//        stationOrder.setId(4L);
          stationOrder.setStationId(25L);
        try {
            stationOrderMapper.find(stationOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByTime(){
        StationOrder stationOrder = new StationOrder();
        stationOrder.setStationId(25L);
        try {
            stationOrderMapper.findByTime(stationOrder,0L,10L,0,20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindUserByEntity(){
        StationOrder stationOrder = new StationOrder();
        stationOrder.setStationId(25L);
        try {
            stationOrderMapper.findUserByEntity(stationOrder,0,20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByStationIdAndCarnum(){
        try {
            StationOrder stationOrder = stationOrderMapper.findByStationIdAndCarNuber(20L,"冀Jqjw123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
