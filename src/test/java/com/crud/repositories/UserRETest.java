package com.crud.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.crud.CrudBasicoApplication;
import com.crud.configs.H2TestProfileJPAConfig;
import com.crud.models.UserMO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CrudBasicoApplication.class, H2TestProfileJPAConfig.class})
public class UserRETest {
	
	@Autowired
	private UserRE userRE;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	@Rollback(true)
	public void createShouldPersistData(){
		UserMO userMO = new UserMO("Jackson", "Rua Jupiter 1000", "jackson", "123");
		userMO = this.userRE.saveAndFlush(userMO);
		System.out.println(userMO.getId());
		Assertions.assertThat(userMO.getId()).isNotNull();
		Assertions.assertThat(userMO.getEndereco()).isNotNull();
		Assertions.assertThat(userMO.getUsuario()).isNotNull();
		Assertions.assertThat(userMO.getSenha()).isNotNull();
	}
	
}
