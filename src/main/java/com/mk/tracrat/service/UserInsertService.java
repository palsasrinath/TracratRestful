package com.mk.tracrat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.tracrat.dao.UserInsertDao;
import com.mk.tracrat.dto.User;
import com.mk.tracrat.dto.UserAddress;
import com.mk.tracrat.dto.UserOrganization;
import com.mk.tracrat.dto.UserPermission;
import com.mk.tracrat.dto.UserRole;

/**
 * @author Srinath
 *
 */
@Service
public class UserInsertService {
	@Autowired
	private UserInsertDao dao;

	public String userPermission(UserPermission userPermission) {
		int count = dao.userPermission(userPermission);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	public String userOrganization(UserOrganization userOrganization) {
		int count = dao.userOrganization(userOrganization);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	public String userAddress(UserAddress userAddress) {
		int count = dao.userAddress(userAddress);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";

	}

	public String userRole(UserRole userRole) {
		int count = dao.userRole(userRole);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";

	}

	public String user(User user) {
		int count = dao.user(user);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";

	}

	public List<User> getUserDetails() {
		List<User> dto = dao.getUserDetails();
		return dto;
	}

	public User getUserById(Integer user_id) {
		return dao.getUserById(user_id);
	}

	public List<UserOrganization> getOrganizations() {
		List<UserOrganization> dto = dao.getOrganizations();
		return dto;
	}

	public List<UserPermission> getPermissions() {
		List<UserPermission> dto = dao.getPermissions();
		return dto;
	}

	public List<UserRole> getRoles() {
		List<UserRole> dto = dao.getRoles();
		return dto;
	}

	public List<UserAddress> getAddresses() {
		List<UserAddress> dto = dao.getAddresses();
		return dto;
	}

	public List<UserAddress> getAddressById(Integer address_id) {
		List<UserAddress> dto = dao.getAddressById(address_id);
		return dto;
	}

	public List<User> getUsersById(Integer user_id) {
		List<User> dto = dao.getUsersById(user_id);
		return dto;
	}

	public List<UserRole> getRoleById(Integer role_id) {
		List<UserRole> dto = dao.getRoleById(role_id);
		return dto;
	}

	public List<UserPermission> getPermissionById(Integer permission_id) {
		List<UserPermission> dto = dao.getPermissionById(permission_id);
		return dto;
	}

	public List<UserOrganization> getOrganizationById(Integer org_id) {
		List<UserOrganization> dto = dao.getOrganizationById(org_id);
		return dto;
	}

	public String updateOrganization(UserOrganization userOrganization) {
		int count = dao.updateOrganization(userOrganization);
		if (count == 0)
			return "updation failed";
		else
			return "updation is success";
	}

	public String updateAddress(UserAddress userAddress) {
		int count = dao.updateAddress(userAddress);
		if (count == 0)
			return "updation failed";
		else
			return "updation is success";
		
	}

	public String updatePermission(UserPermission userPermission) {
		int count = dao.updatePermission(userPermission);
		if (count == 0)
			return "updation failed";
		else
			return "updation is success";
		
	}

	public String updateRole(UserRole userRole) {
		int count = dao.updateRole(userRole);
		if (count == 0)
			return "updation failed";
		else
			return "updation is success";
		
	}

	public String updateUser(User user) {
		int count = dao.updateRole(user);
		if (count == 0)
			return "updation failed";
		else
			return "updation is success";
		
		
	}

}
