package com.gonzaloquiroga.app.libreria.libreriaapp.services;


import com.gonzaloquiroga.app.libreria.libreriaapp.dto.user.SaveUserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.user.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();

    UserDto deleteById(Long id);

    UserDto findById(Long id);

    UserDto updateById(SaveUserDto saveUserDto, Long id);
}
