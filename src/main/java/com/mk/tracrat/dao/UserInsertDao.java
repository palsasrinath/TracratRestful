package com.mk.tracrat.dao;

import java.util.List;

import com.mk.tracrat.dto.User;
import com.mk.tracrat.dto.UserAddress;
import com.mk.tracrat.dto.UserOrganization;
import com.mk.tracrat.dto.UserPermission;
import com.mk.tracrat.dto.UserRole;

public interface UserInsertDao {

	public int userOrganization(UserOrganization uo);

	public int userAddress(UserAddress userAddress);

	public int userPermission(UserPermission userPermission);

	public int userRole(UserRole userRole);

	public int user(User user);

	public List<User> getUserDetails();

	public User getUserById(Integer user_id);

	public List<UserOrganization> getOrganizations();

	public List<UserPermission> getPermissions();

	public List<UserRole> getRoles();

	public List<UserAddress> getAddresses();

	public List<UserAddress> getAddressById(Integer address_id);

	public List<User> getUsersById(Integer user_id);

	public List<UserRole> getRoleById(Integer role_id);

	public List<UserPermission> getPermissionById(Integer permission_id);

	public List<UserOrganization> getOrganizationById(Integer org_id);

	public int updateOrganization(UserOrganization userOrganization);

}
