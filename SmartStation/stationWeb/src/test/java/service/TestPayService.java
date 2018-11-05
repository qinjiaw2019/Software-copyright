package service;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.AddressMapper;
import com.cloud.station.pojo.dto.MapAddressDTO;
import com.cloud.station.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPayService {

    @Autowired
    PayService payService;

    @Test
    public void testFind(){
       float left = payService.pay(20L,"冀Jqjw123");

       System.out.println(left);
    }
}
