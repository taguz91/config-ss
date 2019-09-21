package com.shopshopista.oauthprueba;

import com.shopshopista.oauthprueba.models.UsuarioP;
import com.shopshopista.oauthprueba.repository.UsuarioREPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthpruebaApplicationTests {

    @Autowired
    private UsuarioREPO repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    public void crearUsuarioP() {
        UsuarioP u = new UsuarioP();
        u.setUsername("tag");
        u.setPassword(encoder.encode("123"));
        UsuarioP ur = repo.save(u);
        Assert.assertTrue(ur.getPassword().equals(u.getPassword()));
    }

}
