package com.banana.mapper;

import com.banana.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by TJ on 18/3/8.
 */
@Mapper
public interface UserMapper {

    @Select("select * from t_user where id = #{id}")
    User getUserById(@Param("id") Long id);

}
