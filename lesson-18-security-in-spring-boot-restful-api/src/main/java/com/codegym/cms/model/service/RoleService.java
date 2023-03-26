package com.codegym.cms.model.service;

import com.codegym.cms.model.dto.RoleDto;

import java.util.Optional;

public interface RoleService {

    Iterable<RoleDto> findAll();
    Optional<RoleDto> findById(Long id);
    void save(RoleDto roleDto);
    void remove(Long id);
}
