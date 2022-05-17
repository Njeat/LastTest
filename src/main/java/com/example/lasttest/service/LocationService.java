package com.example.lasttest.service;

import com.example.lasttest.model.Location;
import com.example.lasttest.mapper.LocationMapper;
import com.example.lasttest.model.UserLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class LocationService {
    private final LocationMapper locationMapper;

    public UserLocation createUserLocation(UserLocation userLocation){
        return locationMapper.createUserLocation(userLocation);
    }

    public List<Location> getAllLocation(){
        return locationMapper.getAllLocation();
    }

    public Location getLocationById(int locationId){
        return locationMapper.getLocationById(locationId);
    }

    public UserLocation getUserLocation(int userId){
        return locationMapper.getUserLocation(userId);
    }

    public int changeLocation(int userLocationId, String status){
        return locationMapper.changeLocation(userLocationId, status);
    }
}
