package ca.dhruvanshi.controller;
import ca.dhruvanshi.model.AllModels.Post;
import ca.dhruvanshi.model.AllModels.User;
import ca.dhruvanshi.model.AllModels.Comment;
import ca.dhruvanshi.model.AllModels.Todo;
import ca.dhruvanshi.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    
    @Autowired
    private ApiService apiService;
    
    // Endpoint 1: Get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("GET /api/posts called");
        return ResponseEntity.ok(apiService.getAllPosts());
    }
    
    // Endpoint 2: Get single post
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        logger.info("GET /api/posts/{} called", id);
        return ResponseEntity.ok(apiService.getPostById(id));
    }
    
    // Endpoint 3: Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("GET /api/users called");
        return ResponseEntity.ok(apiService.getAllUsers());
    }
    
    // Endpoint 4: Get comments for a post
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        logger.info("GET /api/posts/{}/comments called", postId);
        return ResponseEntity.ok(apiService.getCommentsByPostId(postId));
    }
    
    // Endpoint 5: Get all todos
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        logger.info("GET /api/todos called");
        return ResponseEntity.ok(apiService.getAllTodos());
    }
    
    // POST operation
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        logger.info("POST /api/posts called");
        Post createdPost = apiService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }
    
    // PUT operation
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        logger.info("PUT /api/posts/{} called", id);
        Post updatedPost = apiService.updatePost(id, post);
        return ResponseEntity.ok(updatedPost);
    }
    
    // DELETE operation
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, String>> deletePost(@PathVariable Long id) {
        logger.info("DELETE /api/posts/{} called", id);
        String message = apiService.deletePost(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "REST Template Demo");
        return ResponseEntity.ok(status);
    }
}