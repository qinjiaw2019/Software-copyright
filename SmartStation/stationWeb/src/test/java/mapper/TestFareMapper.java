package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.FareRuleMapper;
import com.cloud.station.pojo.FareRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestFareMapper {

    @Autowired
    FareRuleMapper fareRuleMapper;

    @Test
    public void testInsert(){
        FareRule fareRule = new FareRule();
        fareRule.setRule("{\"discount\":0.8,\"dismoney\":5.0,\"distime\":8.0,\"price\":5.0,\"t0\":5.0,\"unit\":1.0}");
        fareRule.setCreateTime(new Date().getTime());
        fareRule.setStationId(18L);
        fareRule.setMode(1);
        fareRule.setDesc("");
        fareRule.setUsed(1);
        fareRule.setTitle("规则1");
        fareRule.setUserId(1L);

        //在Service中要判断used 属性为1的只能有1个
        try {
            fareRuleMapper.insert(fareRule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try {
            FareRule fareRule = (FareRule) fareRuleMapper.findByPrimaryKey(3L);
            fareRule.setTitle("规则2");
            fareRule.setMode(0);

            fareRuleMapper.update(fareRule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByPrimaryKey(){
        try {
            FareRule fareRule = (FareRule) fareRuleMapper.findByPrimaryKey(3L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAll(){
        try {
            List list = fareRuleMapper.getAll(18L);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByPrimaryKey(){
        try {
            fareRuleMapper.deleteByPrimaryKey(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
