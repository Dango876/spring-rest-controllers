package kata314.service;

import org.springframework.stereotype.Service;
import kata314.repository.RoleRepository;
import kata314.entity.Role;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByEmail(String name) {
        return roleRepository.findRoleByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " + name));
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
