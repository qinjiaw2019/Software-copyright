package mapper;

import com.cloud.station.WebappApplication;
import com.cloud.station.mapper.FriendMapper;
import com.cloud.station.pojo.Friend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestFriendMapper {

    @Autowired
    FriendMapper friendMapper;

    @Test
    public void testInsert(){
        Friend friend = new Friend();
        friend.setMyId(1L);
        friend.setFrendId(3L);
        friend.setCreateTime(new Date().getTime());
        friend.setRelative(Friend.FAMILY);

        //Service要注意自己不能加自己
        try {
            friendMapper.insert(friend);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDeleteByPrimaryKey(){
        try {
            friendMapper.deleteByPrimaryKey(2L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try {
            Friend friend = (Friend) friendMapper.findByPrimaryKey(1L);
            friend.setRelative(Friend.STRANGER);
            friendMapper.update(friend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFriendList(){
        try {
            friendMapper.getFriendList(1L,null,1,0,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
