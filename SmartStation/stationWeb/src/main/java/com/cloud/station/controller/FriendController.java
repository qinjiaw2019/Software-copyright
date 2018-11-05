package com.cloud.station.controller;

import com.cloud.station.constant.Code;
import com.cloud.station.constant.HttpCode;
import com.cloud.station.pojo.Friend;
import com.cloud.station.service.FriendService;
import com.cloud.station.utils.BeanUtils;
import com.cloud.station.utils.ParamValidUtils;
import com.cloud.station.utils.result.JSONReturn;
import com.cloud.station.utils.result.JSONType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/friend")
public class FriendController {

    @Autowired
    FriendService friendService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONType addFriend(HttpServletRequest request){
        try{
            Friend friend = BeanUtils.toObject(request,Friend.class);
            if(friend.getFrendId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"friend id required");
            if(friend.getMyId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"my id required");
            if(friend.getRelative()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"relative required");

            if(friend.getMyId()==friend.getFrendId())
                return JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"parameter invalied");

            friend.setId(null);
            friend.setCreateTime(new Date().getTime());

            List<Friend> friendList = friendService.find(friend);

            int rst = 0;
            if(friendList==null || friendList.isEmpty()){
                rst = friendService.save(friend);
            }else{
                Friend friend_ = friendList.get(0);
                friend_.setCreateTime(new Date().getTime());
                friend_.setRelative(friend.getRelative());

                rst = friendService.update(friend_);
            }

            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(Code.ERROR,"failed");

        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public JSONType delFriend(HttpServletRequest request){
        try{
            Friend friend = BeanUtils.toObject(request,Friend.class);

            if(friend==null)
                return JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"invalied");
            if(friend.getMyId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"user id required");
            if(friend.getFrendId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"friend id required");

            List<Friend> friendList = friendService.find(friend);

            if(friendList==null || friendList.isEmpty()){
                return JSONReturn.error(HttpCode.RESULT_EMPTY,"not exsist");
            }

            int rst = friendService.deleteByPrimaryKey(friendList.get(0).getId());

            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONType update(HttpServletRequest request){
        try{
            Friend friend = BeanUtils.toObject(request,Friend.class);
            if(friend.getFrendId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"friend id required");
            if(friend.getMyId()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"my id required");
            if(friend.getRelative()==null)
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"relative required");

            if(friend.getMyId()==friend.getFrendId())
                return JSONReturn.error(HttpCode.INVALIED_AUTHORITY,"parameter invalied");

            List<Friend> friendList = friendService.find(friend);

            if(friendList==null || friendList.isEmpty()){
                return JSONReturn.error(HttpCode.NOT_EXSITS,"empty");
            }

            friend.setId(friendList.get(0).getId());

            int rst = friendService.update(friend);

            return rst>0 ? JSONReturn.success(rst) :
                    JSONReturn.error(Code.ERROR,"failed");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONType getFriendList(HttpServletRequest request){
        try{
            String page_ = request.getParameter("page");
            String limit_ = request.getParameter("limit");
            String myId_ = request.getParameter("myId");
            String relative_ = request.getParameter("relative");
            String unrelative_ = request.getParameter("unrelative");
            if(ParamValidUtils.isEmpty(page_))page_="1";
            if(ParamValidUtils.isEmpty(limit_))limit_ = "20";

            if(ParamValidUtils.isEmpty(myId_))
                return JSONReturn.error(HttpCode.PARAMETER_MISSING,"user id requied");


            Integer page = Integer.valueOf(page_);
            Integer limit = Integer.valueOf(limit_);
            Long myId = Long.valueOf(myId_);
            Integer relative = null;
            Integer unrelative = null;

            if(ParamValidUtils.isNotEmpty(relative_))relative = Integer.valueOf(relative_);
            if(ParamValidUtils.isNotEmpty(unrelative_))unrelative = Integer.valueOf(unrelative_);


            List list = friendService.getFriendList(myId,relative,unrelative,page,limit);
            Long total = friendService.countByFilter(myId,relative,unrelative);
            Map map = new HashMap();
            map.put("data",list);
            map.put("total",total);
            return (list!=null && list.size()>0) ? JSONReturn.success(map) :
                    JSONReturn.error(HttpCode.RESULT_EMPTY,"empty");
        }catch (Exception e){
            return JSONReturn.error(HttpCode.UNEXPETED_ERROR,"unexpeted error");
        }
    }
}
