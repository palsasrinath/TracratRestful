package com.mk.tracrat.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.tracrat.dto.User;
import com.mk.tracrat.dto.UserAddress;
import com.mk.tracrat.dto.UserOrganization;
import com.mk.tracrat.dto.UserPermission;
import com.mk.tracrat.dto.UserRole;
import com.mk.tracrat.service.UserInsertService;

/**
 * @author Srinath
 *
 */
@RestController
@RequestMapping("/tracrat")
public class UserInsertController {

	final static Logger logger = Logger.getLogger(UserInsertController.class);
	@Autowired
	private UserInsertService service;

	// insert User details
	@PostMapping("/createUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		service.user(user);
		logger.debug("Added:: " + user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// insert Organization details
	@PostMapping("/createOrg")
	public ResponseEntity<UserOrganization> addEmployee(@RequestBody UserOrganization userOrganization) {
		service.userOrganization(userOrganization);
		logger.debug("Added:: " + userOrganization);
		return new ResponseEntity<UserOrganization>(userOrganization, HttpStatus.CREATED);
	}

	// insert Address details
	@PostMapping("/createAddress")
	public ResponseEntity<UserAddress> addUserAddress(@RequestBody UserAddress userAddress) {
		service.userAddress(userAddress);
		logger.debug("Added:: " + userAddress);
		return new ResponseEntity<UserAddress>(userAddress, HttpStatus.CREATED);
	}

	// insert Permission details
	@PostMapping("/createPermission")
	public ResponseEntity<UserPermission> addUserPermission(@RequestBody UserPermission userPermission) {
		service.userPermission(userPermission);
		logger.debug("Added:: " + userPermission);
		return new ResponseEntity<UserPermission>(userPermission, HttpStatus.CREATED);
	}

	// insert Role details
	@PostMapping("/createRole")
	public ResponseEntity<UserRole> addUserRole(@RequestBody UserRole userRole) {
		service.userRole(userRole);
		logger.debug("Added:: " + userRole);
		return new ResponseEntity<UserRole>(userRole, HttpStatus.CREATED);
	}

	// get User details
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUserDetails() {
		List<User> users = service.getUserDetails();
		if (users.isEmpty()) {
			logger.debug("Users does not exists");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " users");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// get Organization details
	@GetMapping("/getOrganizations")
	public ResponseEntity<List<UserOrganization>> getOrganizations() {
		List<UserOrganization> organizations = service.getOrganizations();
		if (organizations.isEmpty()) {
			logger.debug("Organizations does not exists");
			return new ResponseEntity<List<UserOrganization>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + organizations.size() + " organizations");
		logger.debug(Arrays.toString(organizations.toArray()));
		return new ResponseEntity<List<UserOrganization>>(organizations, HttpStatus.OK);
	}

	// get Permission details
	@GetMapping("/getPermissions")
	public ResponseEntity<List<UserPermission>> getPermissions() {
		List<UserPermission> permissions = service.getPermissions();
		if (permissions.isEmpty()) {
			logger.debug("Permissions does not exists");
			return new ResponseEntity<List<UserPermission>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + permissions.size() + " permissions");
		logger.debug(Arrays.toString(permissions.toArray()));
		return new ResponseEntity<List<UserPermission>>(permissions, HttpStatus.OK);
	}

	// get Role details
	@GetMapping("/getRoles")
	public ResponseEntity<List<UserRole>> getRoles() {
		List<UserRole> userRoles = service.getRoles();
		if (userRoles.isEmpty()) {
			logger.debug("UserRoles does not exists");
			return new ResponseEntity<List<UserRole>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + userRoles.size() + " UserRoles");
		logger.debug(Arrays.toString(userRoles.toArray()));
		return new ResponseEntity<List<UserRole>>(userRoles, HttpStatus.OK);
	}

	// get Address details
	@GetMapping("/getAddresses")
	public ResponseEntity<List<UserAddress>> getAddresses() {
		List<UserAddress> userAddresses = service.getAddresses();
		if (userAddresses.isEmpty()) {
			logger.debug("UserAddresses does not exists");
			return new ResponseEntity<List<UserAddress>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + userAddresses.size() + " UserAddresses");
		logger.debug(Arrays.toString(userAddresses.toArray()));
		return new ResponseEntity<List<UserAddress>>(userAddresses, HttpStatus.OK);
	}

	// get Addresses by id
	@GetMapping("/getAddressById/{address_id}")
	public ResponseEntity<List<UserAddress>> getAddressById(@PathVariable("address_id") Integer address_id) {
		List<UserAddress> userAddresses = service.getAddressById(address_id);
		if (userAddresses.isEmpty()) {
			logger.debug(address_id + "adress does not exists");
			return new ResponseEntity<List<UserAddress>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + userAddresses.size() + " UserAddresses");
		logger.debug(Arrays.toString(userAddresses.toArray()));
		return new ResponseEntity<List<UserAddress>>(userAddresses, HttpStatus.OK);
	}

	// get Users by id
	@GetMapping("/getUserById/{user_id}")
	public ResponseEntity<List<User>> getUserById(@PathVariable("user_id") Integer user_id) {
		List<User> users = service.getUsersById(user_id);
		if (users.isEmpty()) {
			logger.debug(user_id + "adress does not exists");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " Users");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// get Roles by id
	@GetMapping("/getRoleById/{role_id}")
	public ResponseEntity<List<UserRole>> getRoleById(@PathVariable("role_id") Integer role_id) {
		List<UserRole> roles = service.getRoleById(role_id);
		if (roles.isEmpty()) {
			logger.debug(role_id + "adress does not exists");
			return new ResponseEntity<List<UserRole>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + roles.size() + " UserRoles");
		logger.debug(Arrays.toString(roles.toArray()));
		return new ResponseEntity<List<UserRole>>(roles, HttpStatus.OK);
	}

	// get Permissions by id
	@GetMapping("/getPermissionById/{permission_id}")
	public ResponseEntity<List<UserPermission>> getPermissionById(
			@PathVariable("permission_id") Integer permission_id) {
		List<UserPermission> permissions = service.getPermissionById(permission_id);
		if (permissions.isEmpty()) {
			logger.debug(permission_id + "permissions does not exists");
			return new ResponseEntity<List<UserPermission>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + permissions.size() + " UserPermissions");
		logger.debug(Arrays.toString(permissions.toArray()));
		return new ResponseEntity<List<UserPermission>>(permissions, HttpStatus.OK);
	}

	// get Organizations by id
	@GetMapping("/getOrganizationById/{org_id}")
	public ResponseEntity<List<UserOrganization>> getOrganizationById(@PathVariable("org_id") Integer org_id) {
		List<UserOrganization> organizations = service.getOrganizationById(org_id);
		if (organizations.isEmpty()) {
			logger.debug(org_id + "permissions does not exists");
			return new ResponseEntity<List<UserOrganization>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + organizations.size() + " UserOrganizations");
		logger.debug(Arrays.toString(organizations.toArray()));
		return new ResponseEntity<List<UserOrganization>>(organizations, HttpStatus.OK);
	}

	// update Organization
	@PostMapping("/updateOrganization")
	public ResponseEntity<UserOrganization> updateOrganization(@RequestBody UserOrganization userOrganization) {
		service.updateOrganization(userOrganization);
		logger.debug("Added:: " + userOrganization);
		return new ResponseEntity<UserOrganization>(userOrganization, HttpStatus.CREATED);
	}

	// update Address
	@PostMapping("/updateAddress")
	public ResponseEntity<UserAddress> updateAddress(@RequestBody UserAddress userAddress) {
		service.updateAddress(userAddress);
		logger.debug("Added:: " + userAddress);
		return new ResponseEntity<UserAddress>(userAddress, HttpStatus.CREATED);
	}

	// update Permission
	@PostMapping("/updatePermission")
	public ResponseEntity<UserPermission> updatePermission(@RequestBody UserPermission userPermission) {
		service.updatePermission(userPermission);
		logger.debug("Added:: " + userPermission);
		return new ResponseEntity<UserPermission>(userPermission, HttpStatus.CREATED);
	}

	// update Role
	@PostMapping("/updateRole")
	public ResponseEntity<UserRole> updateRole(@RequestBody UserRole userRole) {
		service.updateRole(userRole);
		logger.debug("Added:: " + userRole);
		return new ResponseEntity<UserRole>(userRole, HttpStatus.CREATED);
	}
	// update User 
			@PostMapping("/updateUser")
			public ResponseEntity<User> updateUser(@RequestBody User user) {
				service.updateUser(user);
				logger.debug("Added:: " + user);
				return new ResponseEntity<User>(user, HttpStatus.CREATED);
			}

}
