package com.lm.assessment.server.service.impl;

import com.lm.assessment.server.mapper.UserMapper;
import com.lm.assessment.server.model.UserDO;
import com.lm.assessment.server.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author yond
 * @date 2023/10/22
 * @description 用户实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDO getById(Long userId) {
        Assert.notNull(userId, "用户id为空");
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserDO getByMobile(String mobile) {
        Assert.hasText(mobile, "手机号为空");
        return userMapper.getOneByMobile(mobile);
    }

    @Override
    public UserDO getByEmail(String email) {
        Assert.hasText(email, "邮箱为空");
        return userMapper.getOneByEmail(email);
    }

    @Override
    public List<UserDO> listByIds(List<Long> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return Collections.emptyList();
        }
        return userMapper.listByIds(userIds);
    }

    @Override
    public UserDO getByGuid(String guid) {
        Assert.hasText(guid, "guid为空");
        return userMapper.getOneByGuid(guid);
    }
}
