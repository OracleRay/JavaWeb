package ProvinceTest.service;

import ProvinceTest.dao.ProvinceDao;
import ProvinceTest.dao.ProvinceDaoImplement;
import ProvinceTest.domain.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import 快速入门.utils.JedisUtils;

import java.util.List;

public class ProvinceServiceImplement implements ProvinceService{
    private ProvinceDao dao = new ProvinceDaoImplement();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findJson() {
        Jedis jedis = JedisUtils.getJedis();
        String province = jedis.get("province");

        if(province == null || province.length() == 0){             //看redis是否有缓存,若没有，则从数据库调取数据
            System.out.println("redis缓存为空，将从数据库查询数据......");
            List<Province> provinceList = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province = mapper.writeValueAsString(provinceList);            //将查询到的数据转为json
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province);                 //将从数据库查询到的province存入redis
            jedis.close();                 //归还连接
        }else{
            System.out.println("redis有缓存，正在调取redis...");
        }
        return province;
    }
}
