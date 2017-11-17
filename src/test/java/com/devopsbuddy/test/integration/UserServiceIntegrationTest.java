package com.devopsbuddy.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devopsbuddy.DevopsbuddyApplication;
import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.service.UserService;
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;


public class UserServiceIntegrationTest {
	
	@Autowired
	private UserService userService;
	
    @Rule public TestName testName = new TestName();

    @Test
    public void testCreateNewUser() throws Exception {

    		Set<UserRole> userRoles = new HashSet<>();
    		User basicUser = UserUtils.createBasicUser();
    		userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));
    		
    		User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
    		
    		/*User user = createUser(testName);*/
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

    }

}
