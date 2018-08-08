package tr.com.havelsan.summerschool.blogapp.repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.havelsan.summerschool.blogapp.domain.BlogUser;


import java.util.Date;
import java.util.List;

/**
 * Created by tkiziloren on 7.08.2018.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveKullanici(){
        BlogUser user = new BlogUser();
        user.setName("Ahmet Can");
        user.setEmail("ahmetcan@gmail.com");
        user.setPassword("deneme");
        user.setRegisterDate(new Date());



        BlogUser user1 = new BlogUser();
        user1.setName("Burak Buruk");
        user1.setEmail("burakburuk@gmail.com");
        user1.setPassword("123456");
        user1.setRegisterDate(new Date());


        BlogUser user2 = new BlogUser();
        user2.setName("Tevfik Kiziloren");
        user2.setEmail("tkiziloren@gmail.com");
        user2.setPassword("abcdef");
        user2.setRegisterDate(new Date());

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);

    }

}
