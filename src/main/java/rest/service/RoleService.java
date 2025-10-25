package rest.service;

import rest.dto.RoleDto;
import rest.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAllRoles();
}
