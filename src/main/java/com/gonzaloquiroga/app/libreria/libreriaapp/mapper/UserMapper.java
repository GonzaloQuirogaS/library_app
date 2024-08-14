package com.gonzaloquiroga.app.libreria.libreriaapp.mapper;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.user.UserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.User;
import org.springframework.stereotype.Service;


@Service
public class UserMapper {
    public UserDto mapToUserDto(User user) {
        if (user == null) return null;
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setUsersurname(user.getUsersurname());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setCountry(user.getCountry());
        userDto.setRegisteredAt(user.getRegisteredAt());
        userDto.setDistrict(user.getDistrict());
        userDto.setAdress(user.getAdress());
        userDto.setPhone(user.getPhone());
        userDto.setPcode(user.getPcode());
        userDto.setOrders(user.getOrders());
        return userDto;
    }
}