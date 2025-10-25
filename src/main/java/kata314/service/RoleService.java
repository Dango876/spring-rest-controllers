package kata314.service;

import kata314.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleByEmail(String name);

    void saveRole(Role role);
}
