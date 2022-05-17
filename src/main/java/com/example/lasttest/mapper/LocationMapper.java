package com.example.lasttest.mapper;

import com.example.lasttest.model.Location;
import com.example.lasttest.model.User;
import com.example.lasttest.model.UserLocation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LocationMapper {

    @Insert("INSERT INTO userLocation (userId, locationId) \n"+
            "VALUES (#{userLocation.userId},#{userLocation.locationId})")
    @Options(useGeneratedKeys = true, keyProperty = "userLocationId")
    UserLocation createUserLocation(@Param("userLocation") UserLocation userLocation);

    @Select("SELECT * FROM location")
    List<Location> getAllLocation();

    @Select("SELECT * FROM location WHERE locationId=#{locationId}")
    Location getLocationById(@Param("locationId") int locationId);

    @Select("SELECT * FROM UserLocation WHERE userId=#{userId} AND status='TRUE'")
    @Results(id="LocationMap", value={
            @Result(property = "location", column = "locationId", many=@Many(select = "com.example.lasttest.mapper.LocationMapper.getLocationById"))
    })
    UserLocation getUserLocation(@Param("userId") int userId);

    @Update("UPDATE userLocation \n" +
            "SET status = #{status} \n"+
            "WHERE userLocationId = #{userLocationId}")
    int changeLocation(@Param("userLocationId") int userLocationId,
                                @Param("status") String status);

}
