package com.gonzaloquiroga.app.libreria.libreriaapp.service.interfaces;


import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.user.SaveUserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.user.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();

    UserDto deleteById(Long id);

    UserDto findById(Long id);

    UserDto updateById(SaveUserDto saveUserDto, Long id);
}
