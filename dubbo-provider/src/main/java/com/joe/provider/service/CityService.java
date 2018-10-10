package com.joe.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.joe.api.ICityService;
import com.joe.api.model.City;
import org.springframework.stereotype.Component;

@Component
@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        interfaceClass = ICityService.class
)
public class CityService implements ICityService {
    @Override
    public City findCityByName(String cityName) {
        City city = new City();
        city.setCityName(cityName + " from vultr");
        return city;
    }
}
