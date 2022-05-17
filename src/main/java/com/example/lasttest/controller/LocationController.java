package com.example.lasttest.controller;

import com.example.lasttest.model.Location;
import com.example.lasttest.model.UserLocation;
import com.example.lasttest.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/location")
    public UserLocation createUserLocation(@RequestBody UserLocation userLocation){
        locationService.createUserLocation(userLocation);
        return userLocation;
    }

    @GetMapping("/location")
    public List<Location> getAllLocation(){
        return locationService.getAllLocation();
    }

    @GetMapping("/location/{locationId}")
    public Location getLocationById(@PathVariable("locationId") int locationId){
        return locationService.getLocationById(locationId);
    }

    @GetMapping("/location/user/{userId}")
    public UserLocation getUserLocation(@PathVariable("userId") int userId){
        return locationService.getUserLocation(userId);
    }

    @PatchMapping("/location/{userLocationId}")
    public int changeLocation(@PathVariable("userLocationId") int userLocationId,
                                       @RequestParam("status") String status){
        locationService.changeLocation(userLocationId, status);
        return userLocationId;
    }

}
