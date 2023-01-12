package es.codeurjc.booksmanagementspring.service;

import org.springframework.stereotype.Service;

import es.codeurjc.booksmanagementspring.dto.RoleCreateDTO;
import es.codeurjc.booksmanagementspring.dto.RoleDTO;
import es.codeurjc.booksmanagementspring.mapper.RoleMapper;
import es.codeurjc.booksmanagementspring.repository.RoleRepository;

@Service
public class RoleService {
    // private final RoleMapper roleMapper;
    // private final RoleRepository roleRepository;

    // public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
    //     this.roleRepository = roleRepository;
    //     this.roleMapper = roleMapper;
    // }

    // public RoleDTO save(RoleCreateDTO roleCreateDTO) {
    //     return roleMapper.toDTO(roleRepository.save(roleMapper.toDomain(roleCreateDTO)));
    // }
}