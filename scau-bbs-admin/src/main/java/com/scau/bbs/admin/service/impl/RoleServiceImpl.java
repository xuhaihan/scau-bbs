package com.scau.bbs.admin.service.impl;

import com.scau.bbs.admin.service.AdminUserService;
import com.scau.bbs.admin.service.PermissionService;
import com.scau.bbs.admin.service.RoleService;
import com.scau.bbs.common.base.BaseServiceImpl;
import com.scau.bbs.common.dao.RoleDao;
import com.scau.bbs.common.dto.QuarkResult;
import com.scau.bbs.common.entity.Permission;
import com.scau.bbs.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * Created by xhh 2019//1/15
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private AdminUserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public QuarkResult findRolesAndSelected(Integer id) {
        Set<Role> userRole = userService.findOne(id).getRoles();
        List<Role> roles = findAll();
        for (Role r: roles) {
            if (userRole.contains(r)) r.setSelected(1);
        }

        return QuarkResult.ok(roles);
    }

    @Override
    public Page<Role> findByPage(int pageNo, int length) {
        PageRequest pageRequest = new PageRequest(pageNo, length);
        Page<Role> page = repository.findAll(pageRequest);
        return page;
    }

    @Override
    public void saveRolePermission(Integer roleid, Permission[] pers) {
        Role role = findOne(roleid);
        if (pers==null){
            role.setPermissions(new HashSet<>());
        }
        else {
            role.setPermissions(Stream.of(pers).collect(toSet()));
        }
        save(role);
    }
}
