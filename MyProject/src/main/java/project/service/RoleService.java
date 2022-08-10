package project.service;

import project.model.service.RoleServiceModel;

public interface RoleService {
    RoleServiceModel findByName(String name);
}
