package com.joe.api;

import com.joe.api.model.City;

public interface ICityService {
    City findCityByName(String cityName);
}
