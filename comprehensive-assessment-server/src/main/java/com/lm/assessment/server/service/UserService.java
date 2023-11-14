package com.lm.assessment.server.service;

import com.lm.assessment.server.model.UserDO;

import java.util.List;

/**
 * @author yond
 * @date 2023/10/22
 * @description 用户
 */
public interface UserService {

    UserDO getById(Long userId);

    UserDO getByMobile(String mobile);

    UserDO getByEmail(String email);

    List<UserDO> listByIds(List<Long> userIds);

}
