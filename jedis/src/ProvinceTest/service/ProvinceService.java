package ProvinceTest.service;

import ProvinceTest.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
    public String findJson();
}
