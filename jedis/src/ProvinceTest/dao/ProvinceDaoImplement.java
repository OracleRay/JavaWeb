package ProvinceTest.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ProvinceTest.domain.Province;
import ProvinceTest.utils.JDBCUtils;

import java.util.List;

public class ProvinceDaoImplement implements ProvinceDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "select * from day23.province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
        return list;
    }
}
