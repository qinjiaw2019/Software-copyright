package service;

import com.cloud.station.WebappApplication;
import com.cloud.station.fare.api.ChargeApi;
import com.cloud.station.fare.entity.Rule;
import com.cloud.station.pojo.FareRule;
import com.cloud.station.service.FareService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestFareService {

    @Autowired
    FareService fareService;

    @Test
    public void calc(){
        FareRule fareRule = fareService.getUsedByStationId(20L);

        Rule rule = new Rule();
        rule.setRule(fareRule.getRule());
        rule.setTotalTime(8);
        rule.setMode(fareRule.getMode());

        ChargeApi chargeApi = new ChargeApi(rule);

        float money = chargeApi.calc();
        System.out.println(money);
    }

}
