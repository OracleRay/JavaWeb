package ProvinceTest.service;

import ProvinceTest.dao.ProvinceDao;
import ProvinceTest.dao.ProvinceDaoImplement;
import ProvinceTest.domain.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import ��������.utils.JedisUtils;

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

        if(province == null || province.length() == 0){             //��redis�Ƿ��л���,��û�У�������ݿ��ȡ����
            System.out.println("redis����Ϊ�գ��������ݿ��ѯ����......");
            List<Province> provinceList = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province = mapper.writeValueAsString(provinceList);            //����ѯ��������תΪjson
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province);                 //�������ݿ��ѯ����province����redis
            jedis.close();                 //�黹����
        }else{
            System.out.println("redis�л��棬���ڵ�ȡredis...");
        }
        return province;
    }
}
