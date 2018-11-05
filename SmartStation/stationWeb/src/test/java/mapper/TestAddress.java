package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.AddressMapper;
import com.cloud.station.pojo.dto.MapAddressDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAddress {

    @Autowired
    AddressMapper addressMapper;

    @Test
    public void testFind(){
        MapAddressDTO mapAddressDTO = new MapAddressDTO();
        mapAddressDTO.setCountry("上海");
        try {
            List list = addressMapper.find(mapAddressDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
