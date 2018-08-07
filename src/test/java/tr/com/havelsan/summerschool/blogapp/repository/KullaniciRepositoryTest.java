package tr.com.havelsan.summerschool.blogapp.repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.havelsan.summerschool.blogapp.domain.Kullanici;

import java.util.List;

/**
 * Created by tkiziloren on 7.08.2018.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class KullaniciRepositoryTest {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Test
    public void testSaveKullanici(){
        Kullanici kullanici = new Kullanici();
        kullanici.setKullaniciAdSoyad("Ahmet Can");
        kullanici.setKullaniciEmail("ahmetcan@gmail.com");
        kullanici.setKullaniciSifre("deneme");

        kullaniciRepository.save(kullanici);

        List<Kullanici> kullanicilar = kullaniciRepository.findAll();
        assertEquals(1, kullanicilar.size());

    }

}
