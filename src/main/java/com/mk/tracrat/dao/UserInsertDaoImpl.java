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
	/*
	 * private static final String INSERT_USER_DATA =
	 * "call procedure_insert_user(?,?,?,?,?,?,?,?,?,?,?,?,?)"; private static final
	 * String INSERT_USER_ADDRESS = "call procedure_insert_address(?,?,?,?,?,?,?)";
	 * private static final String INSERT_USER_ROLE =
	 * "call procedure_insert_role(?,?,?,?,?,?,?)"; private static final String
	 * INSERT_USER_PERMISSION = "call procedure_insert_permission(?,?,?,?,?,?,?)";
	 * private static final String INSERT_USER_ORGANIZATION =
	 * "call procedure_insert_Organization(?,?,?,?,?,?)";
	 */
	// UPDATE USER DETAILS INTO DATABASE
	private static final String UPDATE_ORGANIZATION_DATA = "UPDATE t_organization_create SET   status =?,created_date =?, created_by =? , modified_date =?, modified_by =? WHERE  org_id =?" ;
	private static final String UPDATE_USER_DATA = "update t_user_create set org_id=? ,first_name=?,last_name=?,age=?,gender=?,mobile_number=?,superUserFlag=?,status=?,created_date=?,created_by=?,modified_date=?,modified_by=? where user_id=?";
	private static final String UPDATE_ADDRESS_DATA = "UPDATE t_address_create SET user_id =?,address1 =?,address2 =?,state =?,country =?,pin =? WHERE  address_id = ?";
	private static final String UPDATE_PERMISSION_DATA = "UPDATE t_permission_create SET role_id =?,status =?,created_date =?,created_by =? ,modified_date=? ,modified_by =? WHERE  permission_id = ?";
	private static final String UPDATE_USER_ROLE_DATA = "update t_role_create  set user_id=?,status=?,created_date=?,created_by=?,modified_date=?,modified_by=? where role_id=?";
	

	// inserting user details into mssql server
	private static final String INSERT_USER_ORGANIZATION = "call procedure_insert_Organization(?,?,?,?,?)";
	private static final String INSERT_USER_DATA = "call procedure_insert_user(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	//private static final String INSERT_USER_ORGANIZATION = "INSERT INTO t_organization_create values(?,?,?,?,?)";
	//private static final String INSERT_USER_DATA = "INSERT INTO t_user_create VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ADDRESS = "INSERT INTO t_address_create VALUES(?,?,?,?,?,?)";
	private static final String INSERT_USER_ROLE = "INSERT INTO t_role_create VALUES(?,?,?,?,?,?)";
	private static final String INSERT_USER_PERMISSION = "INSERT INTO t_permission_create VALUES(?,?,?,?,?,?)";

	// GET USER DETAILS INTO MSSQL DATABASE
	private static final String GET_ORGANIZATION_DETAILS = "SELECT * FROM T_ORGANIZATION_CREATE";
	private static final String GET_USER_DETAILS = "SELECT * FROM T_USER_CREATE";
	private static final String GET_ADDRESS_DETAILS = "SELECT * FROM T_ADDRESS_CREATE";
	private static final String GET_ROLE_DETAILS = "SELECT * FROM T_ROLE_CREATE";
	private static final String GET_PERMISSION_DETAILS = "SELECT * FROM T_PERMISSION_CREATE";

	// GET THE USER DETAILS BASED ON ID INTO THE DATABASE
	private static final String GETBYID_ORGANIZATION_DETAILS = "SELECT * FROM T_ORGANIZATION_CREATE WHERE ORG_ID=?";
	private static final String GETBYID_USER_DETAILS = "SELECT * FROM T_USER_CREATE WHERE USER_ID=?";
	private static final String GETBYID_ADDRESS_DETAILS = "SELECT * FROM T_ADDRESS_CREATE WHERE ADDRESS_ID=?";
	private static final String GETBYID_ROLE_DETALS = "SELECT * FROM T_ROLE_CREATE WHERE ROLE_ID=?";
	private static final String GETBYID_PERMISSION_DETAILS = "SELECT * FROM T_PERMISSION_CREATE WHERE PERMISSION_ID=?";

	public int userOrganization(UserOrganization userOrganization) {
		int response = jt.update(INSERT_USER_ORGANIZATION, userOrganization.getStatus(),
				userOrganization.getCreated_date(), userOrganization.getCreated_by(),
				userOrganization.getModified_date(), userOrganization.getModified_by());
		return response;
	}

	public int user(User user) {
		int result = jt.update(INSERT_USER_DATA, user.getOrg_id(), user.getFirst_name(), user.getLast_name(),
				user.getAge(), user.getGender(), user.getMobile_number(), user.getSuperUserFlag(), user.getStatus(),
				user.getCreated_date(), user.getCreated_by(), user.getModified_date(), user.getModified_by());

		return result;
	}

	public int userAddress(UserAddress userAddress) {
		int response = jt.update(INSERT_USER_ADDRESS, userAddress.getUser_id(), userAddress.getAddress1(),
				userAddress.getAddress2(), userAddress.getState(), userAddress.getCountry(), userAddress.getPin());
		return response;
	}

	public int userPermission(UserPermission userPermission) {
		int response = jt.update(INSERT_USER_PERMISSION, userPermission.getRole_id(), userPermission.getStatus(),
				userPermission.getCreated_date(), userPermission.getCreated_by(), userPermission.getModified_date(),
				userPermission.getModified_by());
		return response;
	}

	public int userRole(UserRole userRole) {
		int response = jt.update(INSERT_USER_ROLE, userRole.getUser_id(), userRole.getStatus(),
				userRole.getCreated_date(), userRole.getCreated_by(), userRole.getModified_date(),
				userRole.getModified_by());
		return response;
	}

	public List<UserOrganization> getOrganizations() {
		List<UserOrganization> userList = jt.query(GET_ORGANIZATION_DETAILS,
				new BeanPropertyRowMapper(UserOrganization.class));
		return userList;
	}

	public List<User> getUserDetails() {
		List<User> userList = jt.query(GET_USER_DETAILS, new BeanPropertyRowMapper(User.class));
		return userList;
	}

	public List<UserAddress> getAddresses() {
		List<UserAddress> userList = jt.query(GET_ADDRESS_DETAILS, new BeanPropertyRowMapper(UserAddress.class));
		return userList;
	}

	public List<UserRole> getRoles() {
		List<UserRole> userList = jt.query(GET_ROLE_DETAILS, new BeanPropertyRowMapper(UserRole.class));
		return userList;
	}

	public List<UserPermission> getPermissions() {
		List<UserPermission> userList = jt.query(GET_PERMISSION_DETAILS,
				new BeanPropertyRowMapper(UserPermission.class));
		return userList;
	}

	public List<UserOrganization> getOrganizationById(Integer org_id) {
		List<UserOrganization> userList = jt.query(GETBYID_ORGANIZATION_DETAILS,
				new BeanPropertyRowMapper(UserOrganization.class), org_id);
		return userList;
	}
	public List<User> getUsersById(Integer user_id) {
		List<User> userList = jt.query(GETBYID_USER_DETAILS, new BeanPropertyRowMapper(User.class), user_id);
		return userList;
	}

	public List<UserAddress> getAddressById(Integer address_id) {
		List<UserAddress> userList = jt.query(GETBYID_ADDRESS_DETAILS, new BeanPropertyRowMapper(UserAddress.class),
				address_id);
		return userList;
	}

	public List<UserRole> getRoleById(Integer role_id) {
		List<UserRole> userList = jt.query(GETBYID_ROLE_DETALS, new BeanPropertyRowMapper(User.class), role_id);
		return userList;
	}

	public List<UserPermission> getPermissionById(Integer permission_id) {
		List<UserPermission> userList = jt.query(GETBYID_PERMISSION_DETAILS,
				new BeanPropertyRowMapper(UserPermission.class), permission_id);
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
		int count = jt.update(UPDATE_ADDRESS_DATA, userAddress.getUser_id(), userAddress.getAddress1(),
				userAddress.getAddress2(), userAddress.getState(), userAddress.getCountry(), userAddress.getPin(),
				userAddress.getAddress_id());

		return count;
	}

	public int updatePermission(UserPermission userPermission) {
		System.out.println("dao update controller" + userPermission);
		int count = jt.update(UPDATE_PERMISSION_DATA, userPermission.getRole_id(), userPermission.getStatus(),
				userPermission.getCreated_date(), userPermission.getCreated_by(), userPermission.getModified_date(),
				userPermission.getModified_by(), userPermission.getPermission_id());

		return count;
	}

	public int updateRole(UserRole userRole) {
		int count = jt.update(UPDATE_USER_ROLE_DATA, userRole.getUser_id(), userRole.getStatus(),
				userRole.getCreated_date(), userRole.getCreated_by(), userRole.getModified_date(),
				userRole.getModified_by(), userRole.getRole_id());
		return count;
	}

	public int updateRole(User user) {
		System.out.println("dao update controller" + user);
		int count = jt.update(UPDATE_USER_DATA, user.getOrg_id(), user.getFirst_name(), user.getLast_name(),
				user.getAge(), user.getGender(), user.getMobile_number(), user.getSuperUserFlag(), user.getStatus(),
				user.getCreated_date(), user.getCreated_by(), user.getModified_date(), user.getModified_by(),
				user.getUser_id());

		return count;
	}

	@Override
	public User getUserById(Integer user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
