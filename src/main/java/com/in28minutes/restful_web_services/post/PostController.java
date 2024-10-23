package com.in28minutes.restful_web_services.post;

import com.in28minutes.restful_web_services.user.User;
import com.in28minutes.restful_web_services.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("users/{id}/posts")
    public List<Post> getPostsByUser(@PathVariable long id) {
        Optional<User> userOp = userRepository.findById(id);

        return new ArrayList<Post>(userOp.get().getPosts());
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable long id, @Valid @RequestBody Post post) {
        Optional<User> userOp = userRepository.findById(id);

        post.setUser(userOp.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
