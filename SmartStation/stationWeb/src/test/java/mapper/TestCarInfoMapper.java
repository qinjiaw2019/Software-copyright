package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.CarInfoMapper;
import com.cloud.station.pojo.CarInfo;
import com.cloud.station.pojo.CarNumberUsed;
import com.cloud.station.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCarInfoMapper {

    @Autowired
    CarInfoMapper carInfoMapper;

    @Test
    public void testInsert(){
        CarInfo carInfo = new CarInfo();
        carInfo.setCarNumber("辽FQJW");
        carInfo.setCurrentUsed(1L);
        carInfo.setCarNumberType("奥迪");
        carInfo.setPhoto("aodi.png");
        carInfo.setCarType("别克");
        carInfo.setCarXH("Roadmaster");
        carInfo.setCarYear(2015);
        carInfo.setCarColor("黑色");
        carInfo.setCode("23213");
        carInfo.setUserId(2L);


        try {
            Integer rst = carInfoMapper.insert(carInfo);
            System.out.println(rst);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){

        try {
            CarInfo carInfo = (CarInfo) carInfoMapper.findByPrimaryKey(7);
            carInfo.setCarNumber("冀J2342");
            carInfoMapper.update(carInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindByPrimaryKey(){
        try {
            CarInfo carInfo = (CarInfo) carInfoMapper.findByPrimaryKey(7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUser(){
        CarInfo carInfo = new CarInfo();
//        carInfo.setCarNumber("冀J2342");
//          carInfo.setUserId(123982L);
        carInfo.setCurrentUsed(1L);
        try {
           UserInfo userInfo = carInfoMapper.getUser(carInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAll(){
        try {
            List list = carInfoMapper.getAll(1L);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetByCarNumber(){
        try {
            carInfoMapper.getByCarNumber("冀J2342");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind(){
        CarInfo carInfo = new CarInfo();
//        carInfo.setId(7L);
//        carInfo.setCarNumber("冀J2342");
        try {
            List list = carInfoMapper.find(carInfo,0,20);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
