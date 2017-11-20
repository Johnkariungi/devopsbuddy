package com.devopsbuddy.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.devopsbuddy.DevopsbuddyApplication;
import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevopsbuddyApplication.class)
public class RepositoriesIntergrationTest {

	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private static final int BASIC_PLAN_ID = 1;
	private static final int BASIC_ROLE_ID = 1;
	
	/**tests to check that our repositories are not null*/
	@Before
	public void init() {
		Assert.assertNotNull(planRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(userRepository);
	}
	
	@Test
	public void testCreateNewPlan() throws Exception {
		Plan basicPlan = createPlan(PlansEnum.BASIC);
		//Plan basicPlan = createBasicPlan();
		planRepository.save(basicPlan);
		//Plan retrivedPlan = planRepository.findOne(BASIC_PLAN_ID);
		Plan retrivedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
		Assert.assertNotNull(retrivedPlan);
	}
	
	@Test
	public void testCreateNewRole() throws Exception {
		//Role userRole = createBasicRole();
		Role userRole = createRole(RolesEnum.BASIC);
		roleRepository.save(userRole);
		//Role retrivedRole = roleRepository.findOne(BASIC_ROLE_ID);
		Role retrivedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
		Assert.assertNotNull(retrivedRole);
	}

	@Test
	public void createNewUser() throws Exception {
		User basicUser = createUser();//UserUtils.createBasicUser();
		
		/*basicUser = userRepository.save(basicUser);
		User newlyCreatedUser = userRepository.findOne(basicUser.getId());
		Assert.assertNotNull(newlyCreatedUser);
		Assert.assertTrue(newlyCreatedUser.getId() != 0);
		Assert.assertNotNull(newlyCreatedUser.getPlan());
		Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
		
		Set<UserRole> newlyCreatedUserRoles = newlyCreatedUser.getUserRoles();
		
		for (UserRole ur : newlyCreatedUserRoles) {
			Assert.assertNotNull(ur.getRole());
			Assert.assertNotNull(ur.getRole().getId());
		}*/
		
		/** create and save a plan record. */
		//Plan basicPlan = createBasicPlan();
		/*Plan basicPlan = createPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan); 
		
		/** create user instance
		 * set plan saved entity as FK */
		//User basicUser = createBasicUser();
		/*User basicUser = UserUtils.createBasicUser();
		basicUser.setPlan(basicPlan);
		
		/** create an empty userRole set, 
		 * assign role and user to the objects just created
		 *  set it to the user instance. */
		//Role basicRole = createBasicRole();
		/*Role basicRole = createRole(RolesEnum.BASIC);
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setUser(basicUser);
		userRole.setRole(basicRole);
		userRoles.add(userRole);
		
		/** add values to a collection using the JPA entity
		 * 	use the get method first and all the methods follow
		 *  setting first might delete the pre-existing records. */
		/*basicUser.getUserRoles().addAll(userRoles);
		
		/** save user to roles by persisting all roles 
		 * 	in userRoles collection. */
		/*for (UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
		
		/** save the user entity. */
		basicUser = userRepository.save(basicUser);
		User newlyCreatedUser = userRepository.findOne(basicUser.getId()); /** user exists. */
		Assert.assertNotNull(newlyCreatedUser);
		Assert.assertTrue(newlyCreatedUser.getId() != 0);
		Assert.assertNotNull(newlyCreatedUser.getPlan());
		Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
		
		Set<UserRole> newlyCreatedUserUserRoles = new HashSet<>();
		for (UserRole ur : newlyCreatedUserUserRoles) {
			Assert.assertNotNull(ur.getRole());
			Assert.assertNotNull(ur.getRole().getId());
		}
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		/*use userId not entity*/
		User basicUser =  createUser();
		userRepository.delete(basicUser.getId());
	}
	
	//---------------> Private methods
	private Plan createPlan(PlansEnum plansEnum) {
		return new Plan(plansEnum);
	}
	
	private Role createRole(RolesEnum rolesEnum) {
		return new Role(rolesEnum);
	}
	
	private User createUser() {
		Plan basicPlan = createPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);
		
		User basicUser = UserUtils.createBasicUser();
		basicUser.setPlan(basicPlan);
		
		Role basicRole = createRole(RolesEnum.BASIC);
		roleRepository.save(basicRole);
		
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole(basicUser, basicRole);
		userRoles.add(userRole);
		
		basicUser.getUserRoles().addAll(userRoles);
		basicUser = userRepository.save(basicUser);
		
		return basicUser;
		
	}
	/*private Plan createBasicPlan() {
		Plan plan = new Plan();
		plan.setId(BASIC_PLAN_ID);
		plan.setName("Basic");
		return plan;
	}
	
	private Role createBasicRole() {
		Role role = new Role();
		role.setId(BASIC_ROLE_ID);
		role.setName("ROLE_USER");
		return role;
	}
	
	private User createBasicUser() {
		User user = new User();
		user.setUsername("basicUser");
		user.setPassword("secret");
		user.setEmail("123456789123");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setPhoneNumber("");
		user.setCountry("GB");
		user.setEnabled(true);
		user.setDescription("A basic user");
		user.setProfileImageUrl("http://blable.images.com/basicuser");
		
		return user;
	}*/
}