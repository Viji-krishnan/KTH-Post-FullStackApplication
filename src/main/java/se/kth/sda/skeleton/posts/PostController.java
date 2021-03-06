package se.kth.sda.skeleton.posts;

import javafx.geometry.Pos;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/posts/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post newPost) {

        return postService.create(newPost);
    }

    @PutMapping("/posts/{id}")
    public Post update(@PathVariable Long id,@RequestBody Post updatePost) throws Exception {

        return postService.update(id,updatePost);
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id) {
        postService.deleteById(id);
    }



}
