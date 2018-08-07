package tr.com.havelsan.summerschool.blogapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.havelsan.summerschool.blogapp.domain.Kullanici;
import tr.com.havelsan.summerschool.blogapp.repository.KullaniciRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by tkiziloren on 7.08.2018.
 */

@RestController
public class KullaniciResource {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @GetMapping("/users")
    public List<Kullanici> getAllUsers(){
        return kullaniciRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createStudent(@RequestBody Kullanici user) {
        Kullanici savedUser = kullaniciRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getKullaniciID()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteStudent(@PathVariable int id) {
        kullaniciRepository.deleteById(id);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Kullanici kullanici, @PathVariable int id) {

        Optional<Kullanici> kullaniciOptional = kullaniciRepository.findById(id);

        if (!kullaniciOptional.isPresent())
            return ResponseEntity.notFound().build();

        kullanici.setKullaniciID(id);

        kullaniciRepository.save(kullanici);
        return ResponseEntity.noContent().build();
    }


}
