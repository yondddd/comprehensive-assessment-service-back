package com.lm.assessment.server.mapper;
import org.apache.ibatis.annotations.Param;

import com.lm.assessment.server.model.UserDO;

import java.util.List;

/**
 * @Entity com.lm.assessment.server.model.User
 */
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO getOneByMobile(@Param("mobile") String mobile);

    UserDO getOneByEmail(@Param("email") String email);

    List<UserDO> listById(@Param("ids") List<Long> ids);
}
