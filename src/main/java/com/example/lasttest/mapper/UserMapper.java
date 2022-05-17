package com.example.lasttest.mapper;

import com.example.lasttest.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(userName, phoneNum, profileImgUrl)\n" +
            "        VALUES (#{user.userName}, #{user.phoneNum}, #{user.profileImgUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void createUser(@Param("user") User user);

    @Select("SELECT * FROM user")
    @Results(id="UserLocationMap", value={
            @Result(property = "userLocation", column = "userId", many=@Many(select = "com.example.lasttest.mapper.LocationMapper.getUserLocation"))
    })
    List<User> allUser();

    @Select("SELECT * FROM user WHERE userId=#{userId}")
    @ResultMap("UserLocationMap")
    User getUserById(@Param("userId") int userId);

    @Update("UPDATE user \n" +
            "SET manner=#{manner}\n" +
            "WHERE userId=#{userId}")
    void updateUser(@Param("userId") int userId,
                    @Param("manner") int manner);

    @Delete("DELETE FROM user WHERE userId=#{userId}")
    void deleteUser(@Param("userId") int userId);

//    @Select("SELECT * FROM user \n" +
//            "LEFT JOIN userlocation ON user.userId = userlocation.userId \n" +
//            "LEFT JOIN location ON userlocation.locationId = location.locationId \n" +
//            "WHERE user.userId=#{userId} AND userlocation.status='TRUE'")
//    List<User> getUserByIdLocation(@Param("userId") int userId);

}
