package com.shimengjie.wpm.user.port.adapter.persistence.repository.mapper;

import com.shimengjie.wpm.common.port.adapter.persistence.repository.mapper.WpmMapper;
import com.shimengjie.wpm.user.domain.model.user.User;
import org.springframework.stereotype.Component;

/**
 * @author shimengjie
 * @date 2021/9/22 17:21
 **/
@Component
public interface UserMapper extends WpmMapper<User> {
}
