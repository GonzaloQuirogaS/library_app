package com.gonzaloquiroga.app.libreria.libreriaapp.service.servicesImpl;

import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.user.SaveUserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.user.UserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.utils.mapper.UserMapper;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.User;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository.UserRepository;
import com.gonzaloquiroga.app.libreria.libreriaapp.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Clase de servicio para el usuario
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map((mapper::mapToUserDto)).collect(Collectors.toList());
    }



    @Override
    public UserDto deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return mapper.mapToUserDto(user);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateById(SaveUserDto saveUserDto, Long id) {
        User userBd = userRepository.findById(id).orElseThrow();
        userBd.setUsername(saveUserDto.getUsername());
        userBd.setUsersurname(saveUserDto.getUsersurname());
        userBd.setEmail(saveUserDto.getEmail());
        userBd.setPassword(saveUserDto.getPassword());
        userBd.setCountry(saveUserDto.getCountry());
        userBd.setDistrict(saveUserDto.getDistrict());
        userBd.setAdress(saveUserDto.getAdress());
        userBd.setPhone(saveUserDto.getPhone());
        userBd.setPcode(saveUserDto.getPcode());
        userRepository.save(userBd);
        return mapper.mapToUserDto(userBd);
    }

}
