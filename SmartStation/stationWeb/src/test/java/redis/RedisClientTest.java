package redis;

import com.cloud.station.WebappApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisClientTest {

    private Jedis getJedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        return jedis;
    }

    /**
     * 设置字符串值
     */
    @Test
    public void test_string_set() {
        Jedis jedis = getJedis();
        jedis.set("age", "1000");
        System.out.println(jedis.get("age"));
    }

    /**
     * 设置key的过期时间: setex(key,expire,value)
     */
    @Test
    public void test_strign_setex() {
        Jedis j = getJedis();
        j.setex("customer", 2, "张铭");
        System.out.println("customer:" + j.get("customer"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("customer sleep 3 second =" + j.get("customer"));
    }

    /**
     * 对已有key的值追加字符串
     */
    @Test
    public void test_string_append() {
        Jedis jedis = getJedis();
        jedis.append("age", "append");
        System.out.println(jedis.get("age"));
    }

    /**
     * 是否存在某个key：exists(String key)
     */
    @Test
    public void test_exists_key() {
        Jedis j = getJedis();
        boolean exists = j.exists("age");
        System.out.println("age exists:" + exists);

        exists = j.exists("name");
        System.out.println("name exists:" + exists);
    }

    /**
     * 获取所有的key
     */
    @Test
    public void test_get_all_keys() {
        Jedis j = getJedis();
        Set<String> keys = j.keys("*");
        for (String key : keys) {
            System.out.println("key=" + key);
        }
    }

    /**
     * 过期测试
     */
    @Test
    public void test_expire() {
        Jedis j = getJedis();
        String key = "username";
        j.set(key, "张三");

        System.out.println(key + " exists=" + j.exists(key));

        // 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
        System.out.println(key + " ttl=" + j.ttl(key));

        // 设置过期时间，单位秒
        j.expire(key, 5);

        // 休眠2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 查看key过期时间
        System.out.println(key + " sleep 2 second ttl=" + j.ttl(key));

        // 移除key的生存时间
        j.persist(key);

        // 查看key过期时间
        System.out.println(key + " persist ttl=" + j.ttl(key));
    }

    /**
     * map类型操作 hmset(key,map)
     */
    @Test
    public void test_map_set() {
        Map<String, String> map = new HashMap<String, String>();
        String key = "user score";
        map.put("username", "zhansan");
        map.put("age", "20");
        map.put("address", "北京");

        Jedis j = getJedis();
        j.hmset("user score", map);

        List<String> values = j.hmget(key, "age", "username", "address");
        System.out.println("users list = " + values);

        j.hdel(key, "age");
        System.out.println("hdel users list = " + values);
        System.out.println("map len = " + j.hlen(key));
        System.out.println("all keys = " + j.hkeys(key));
        System.out.println("all values = " + j.hvals(key));

        System.out.println("*** iterate all keys ***");
        Set<String> mapKeys = j.hkeys(key);
        for (String mapKey : mapKeys) {
            // String val = j.hget(key, mapKey); // 返回String
            List<String> val = j.hmget(key, mapKey); // 返回List<String>
            System.out.println(mapKey + " = " + val);
        }

    }

    /**
     * List类型操作：lpush,rpush,lset,rset,lrange,lrem
     */
    @Test
    public void test_list_set() {
        Jedis j = getJedis();

        String key = "java collection";
        j.del(key);
        j.lpush(key, "Collection");
        j.lpush(key, "List");
        j.lpush(key, "Vector");
        j.lpush(key, "Map");

        System.out.println("list len = " + j.llen(key));

        System.out.println("lpush lrange(0,-1) = " + j.lrange(key, 0, -1));
        System.out.println("lpush lrange(0,2) = " + j.lrange(key, 0, 1));

        j.del(key);
        j.lpush(key, "Collection");
        j.lpush(key, "List");
        j.rpush(key, "Vector");
        j.rpush(key, "Map");
        j.rpush(key, "List");
        System.out.println("rpush lrange(0,-1) = " + j.lrange(key, 0, -1));
        System.out.println(key + " ttl=" + j.ttl(key));

        j.lrem(key,1,"List"); // lrem(key,count,value) count表示有重复的值时，删除几次
        System.out.println("lrem lrange(0,-1) = " + j.lrange(key, 0, -1)); //[Collection, Vector, Map, List]

        j.lset(key, 1, "NewList");
        System.out.println("lrem lrange(0,-1) = " + j.lrange(key, 0, -1));


    }
}
