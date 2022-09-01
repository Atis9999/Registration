package com.example.demo.appuser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class AppUserRepositoryTest {


    @Autowired
    private AppUserRepository underTest;


    @Test
    void itSouldCheckenableAppUser() {
        // given
        String email = "atis1821@freemail.hu";
        AppUser appUser = new AppUser(
                "Attila",
                "Puskás",
                email,
                "password",
                AppUserRole.USER
        );
        underTest.save(appUser);
        //when
       int exists = underTest.enableAppUser(email);
        //then
        Assertions.assertEquals(1,exists);
    }
}