package tr.com.havelsan.summerschool.blogapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.havelsan.summerschool.blogapp.domain.Comment;
import tr.com.havelsan.summerschool.blogapp.domain.Post;
import tr.com.havelsan.summerschool.blogapp.repository.CommentRepository;
import tr.com.havelsan.summerschool.blogapp.repository.PostRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 7.8.2018.
 */

@RestController
public class PostResource {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    @PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable int id){
        return postRepository.findById(id);
    }

    @GetMapping("/posts/{id}/comments")
    public List<Comment> getComments(@PathVariable int id){
        return commentRepository.findAllByPostId(id);
    }

}
