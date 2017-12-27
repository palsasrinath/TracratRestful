package com.mk.tracrat.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mk.tracrat.dto.User;
import com.mk.tracrat.dto.UserAddress;
import com.mk.tracrat.dto.UserOrganization;
import com.mk.tracrat.dto.UserPermission;
import com.mk.tracrat.dto.UserRole;

/**
 * @author Srinath
 *
 */
@Repository
public class UserInsertDaoImpl implements UserInsertDao {
	@Autowired
	private JdbcTemplate jt;
	private static final String INSERT_USER_DATA = "call procedure_insert_user(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ADDRESS = "call procedure_insert_address(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ROLE = "call procedure_insert_role(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_PERMISSION = "call procedure_insert_permission(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ORGANIZATION = "call procedure_insert_Organization(?,?,?,?,?,?)";

	private static final String UPDATE_ORGANIZATION_DATA = "call procd_organization_update(?,?,?,?,?,?)";
	private static final String UPDATE_ADDRESS_DATA = "call procd_address_update(?,?,?,?,?,?,?)";
	private static final String UPDATE_PERMISSION_DATA = "call procd_permission_update(?,?,?,?,?,?,?)";
	private static final String UPDATE_USER_ROLE_DATA = "call procd_role_update(?,?,?,?,?,?,?)";
	private static final String UPDATE_USER_DATA = "call procd_user_update(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public int userOrganization(UserOrganization userOrganization) {
		int response = jt.update(INSERT_USER_ORGANIZATION, userOrganization.getOrg_id(), userOrganization.getStatus(),
				userOrganization.getCreated_date(), userOrganization.getCreated_by(),
				userOrganization.getModified_date(), userOrganization.getModified_by());
		return response;
	}

	public int userAddress(UserAddress userAddress) {
		int response = jt.update(INSERT_USER_ADDRESS, userAddress.getAddress_id(), userAddress.getUser_id(),
				userAddress.getAddress1(), userAddress.getAddress2(), userAddress.getState(), userAddress.getCountry(),
				userAddress.getPin());
		return response;
	}

	public int userPermission(UserPermission userPermission) {
		int response = jt.update(INSERT_USER_PERMISSION, userPermission.getPermission_id(), userPermission.getRole_id(),
				userPermission.getStatus(), userPermission.getCreated_date(), userPermission.getCreated_by(),
				userPermission.getModified_date(), userPermission.getModified_by());
		return response;
	}

	public int userRole(UserRole userRole) {
		int response = jt.update(INSERT_USER_ROLE, userRole.getRole_id(), userRole.getUser_id(), userRole.getStatus(),
				userRole.getCreated_date(), userRole.getCreated_by(), userRole.getModified_date(),
				userRole.getModified_by());
		return response;
	}

	public int user(User user) {
		int result = jt.update(INSERT_USER_DATA, user.getUser_id(), user.getOrg_id(), user.getFirst_name(),
				user.getLast_name(), user.getAge(), user.getGender(), user.getMobile_number(), user.getSuperUserFlag(),
				user.getStatus(), user.getCreated_date(), user.getCreated_by(), user.getModified_date(),
				user.getModified_by());

		return result;
	}

	public List<User> getUserDetails() {
		String sql = "SELECT * FROM t_user_create";

		List<User> userList = jt.query(sql, new BeanPropertyRowMapper(User.class));

		return userList;
	}

	public User getUserById(Integer user_id) {
		String sql = "SELECT * FROM t_user_create where user_id=?";

		List<User> userList = jt.query(sql, new BeanPropertyRowMapper(User.class), user_id);

		return (User) userList;
	}

	public List<UserOrganization> getOrganizations() {
		String sql = "SELECT * FROM t_organization_create";

		List<UserOrganization> userList = jt.query(sql, new BeanPropertyRowMapper(UserOrganization.class));

		return userList;
	}

	public List<UserPermission> getPermissions() {
		String sql = "SELECT * FROM t_permission_create";

		List<UserPermission> userList = jt.query(sql, new BeanPropertyRowMapper(UserPermission.class));

		return userList;
	}

	public List<UserRole> getRoles() {
		String sql = "SELECT * FROM t_role_create";

		List<UserRole> userList = jt.query(sql, new BeanPropertyRowMapper(UserRole.class));

		return userList;
	}

	public List<UserAddress> getAddresses() {
		String sql = "SELECT * FROM t_address_create";

		List<UserAddress> userList = jt.query(sql, new BeanPropertyRowMapper(UserAddress.class));

		return userList;
	}

	public List<UserAddress> getAddressById() {
		String sql = "SELECT * FROM t_address_create where address_id= ?";

		List<UserAddress> userList = jt.query(sql, new BeanPropertyRowMapper(UserAddress.class));

		return userList;
	}

	public List<UserAddress> getAddressById(Integer address_id) {
		String sql = "SELECT * FROM t_address_create where address_id= ?";

		List<UserAddress> userList = jt.query(sql, new BeanPropertyRowMapper(UserAddress.class), address_id);

		return userList;
	}

	public List<User> getUsersById(Integer user_id) {
		String sql = "SELECT * FROM t_user_create where user_id= ?";

		List<User> userList = jt.query(sql, new BeanPropertyRowMapper(User.class), user_id);

		return userList;
	}

	public List<UserRole> getRoleById(Integer role_id) {
		String sql = "SELECT * FROM t_role_create where role_id= ?";

		List<UserRole> userList = jt.query(sql, new BeanPropertyRowMapper(User.class), role_id);

		return userList;
	}

	public List<UserPermission> getPermissionById(Integer permission_id) {
		String sql = "SELECT * FROM t_permission_create where permission_id= ?";

		List<UserPermission> userList = jt.query(sql, new BeanPropertyRowMapper(UserPermission.class), permission_id);

		return userList;
	}

	public List<UserOrganization> getOrganizationById(Integer org_id) {
		String sql = "SELECT * FROM t_organization_create where org_id= ?";

		List<UserOrganization> userList = jt.query(sql, new BeanPropertyRowMapper(UserOrganization.class), org_id);

		return userList;
	}

	public int updateOrganization(UserOrganization userOrganization) {
		System.out.println("dao update controller" + userOrganization);
		int count = jt.update(UPDATE_ORGANIZATION_DATA, userOrganization.getStatus(),
				userOrganization.getCreated_date(), userOrganization.getCreated_by(),
				userOrganization.getModified_date(), userOrganization.getModified_by(), userOrganization.getOrg_id());

		return count;
	}

	public int updateAddress(UserAddress userAddress) {
		System.out.println("dao update controller" + userAddress);
		int count = jt.update(UPDATE_ADDRESS_DATA,userAddress.getUser_id(), userAddress.getAddress1(), userAddress.getAddress2(),
				userAddress.getState(), userAddress.getCountry(), userAddress.getPin(),userAddress.getAddress_id() );

		return count;
	}

	public int updatePermission(UserPermission userPermission) {
		System.out.println("dao update controller" + userPermission);
		int count = jt.update(UPDATE_PERMISSION_DATA, userPermission.getRole_id(), userPermission.getStatus(), userPermission.getCreated_date(),
				userPermission.getCreated_by(), userPermission.getModified_date(), userPermission.getModified_by(), userPermission.getPermission_id());

		return count;
	}

	public int updateRole(UserRole userRole) {
		int count = jt.update(UPDATE_USER_ROLE_DATA, userRole.getUser_id(), userRole.getStatus(), userRole.getCreated_date(),
				userRole.getCreated_by(), userRole.getModified_date(), userRole.getModified_by(), userRole.getRole_id());
		return count;
	}

	public int updateRole(User user) {
		System.out.println("dao update controller" + user);
		int count = jt.update(UPDATE_USER_DATA, user.getOrg_id(), user.getFirst_name(), user.getLast_name(), user.getAge(),
				user.getGender(), user.getMobile_number(), user.getSuperUserFlag(), user.getStatus(), user.getCreated_date(),
				user.getCreated_by(), user.getModified_date(), user.getModified_by(), user.getUser_id());

		return count;
	}

}
