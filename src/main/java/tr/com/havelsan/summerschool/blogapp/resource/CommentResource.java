package tr.com.havelsan.summerschool.blogapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.havelsan.summerschool.blogapp.domain.Comment;
import tr.com.havelsan.summerschool.blogapp.domain.Post;
import tr.com.havelsan.summerschool.blogapp.repository.CommentRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by tkiziloren on 8.08.2018.
 */

@RestController
public class CommentResource {

    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/commments")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedComment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Optional<Comment> getComment(@PathVariable int id){
        return commentRepository.findById(id);
    }
}
