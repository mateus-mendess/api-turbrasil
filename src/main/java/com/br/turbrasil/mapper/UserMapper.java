package com.br.turbrasil.mapper;

import com.br.turbrasil.dto.request.UserRequest;
import com.br.turbrasil.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser (UserRequest request);
}
