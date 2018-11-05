package com.cloud.station.controller;

import com.cloud.station.mapper.AddressMapper;
import com.cloud.station.mapper.DepotStationStateMapper;
import com.cloud.station.pojo.DepotStationState;
import com.cloud.station.pojo.dto.MapAddressDTO;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestController {


    @Autowired
    DepotStationStateMapper depotStationStateMapper;

    @Autowired
    AddressMapper addressMapper;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JSONType login(HttpServletRequest request){
        try {
//            DepotStationState depotStationState = (DepotStationState) depotStationStateMapper.findByPrimaryKey(Integer.valueOf(request.getParameter("id")));

            MapAddressDTO mapAddressDTO = new MapAddressDTO();
            mapAddressDTO.setProvice("上海");
            mapAddressDTO.setCity("上海市");
            mapAddressDTO.setCountry("浦东新区");
            mapAddressDTO.setVillage("滨江大道");
            List list = addressMapper.findByMapAddress(mapAddressDTO);
            return JSONReturn.success(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONReturn.success("test OK!");
    }


    //测试Redis
    @RequestMapping(value = "/fence/query", method = RequestMethod.GET)
    @ResponseBody
    public JSONType queryFence(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
           DepotStationState depotStationState = (DepotStationState) depotStationStateMapper.findByPrimaryKey(id);
//            DepotStationStateMapper depotStationStateMapper2 = (DepotStationStateMapper) BeanTools.getBean(DepotStationStateMapper.class);
//            DepotStationState depotStationState = (DepotStationState) depotStationStateMapper2.findByPrimaryKey(id);
            return JSONReturn.success(depotStationState);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONReturn.error("error");
    }

}
