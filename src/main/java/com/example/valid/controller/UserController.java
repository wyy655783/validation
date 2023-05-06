package com.example.valid.controller;

import com.example.valid.entity.UserAddDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @program: valid
 * @description:
 * @author: wyh
 * @create: 2023-05-05 15:41
 **/
@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/get")
    public UserAddDTO get(@RequestParam("id") @Min(value = 1L, message = "编号必须大于 0") Integer id) {
        logger.info("[get][id: {}]", id);
        UserAddDTO userAddDTO = new UserAddDTO();
        userAddDTO.setUsername("张三");
        userAddDTO.setPassword("123456");
        return userAddDTO;
    }

    @PostMapping("/add")
    public void add(@Valid @RequestBody UserAddDTO addDTO) {
        logger.info("[add][addDTO: {}]", addDTO);
    }
}
