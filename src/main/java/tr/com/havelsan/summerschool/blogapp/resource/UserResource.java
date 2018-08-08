package tr.com.havelsan.summerschool.blogapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.havelsan.summerschool.blogapp.domain.BlogUser;
import tr.com.havelsan.summerschool.blogapp.repository.UserRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by tkiziloren on 7.08.2018.
 */

@RestController
public class UserResource {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<BlogUser> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody BlogUser user) {

        BlogUser savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody BlogUser kullanici, @PathVariable int id) {

        Optional<BlogUser> kullaniciOptional = userRepository.findById(id);

        if (!kullaniciOptional.isPresent())
            return ResponseEntity.notFound().build();

        kullanici.setId(id);

        userRepository.save(kullanici);
        return ResponseEntity.noContent().build();
    }
}
