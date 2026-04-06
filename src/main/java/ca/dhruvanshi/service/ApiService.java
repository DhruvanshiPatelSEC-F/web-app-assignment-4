package ca.dhruvanshi.service;

import ca.dhruvanshi.model.AllModels.Post;
import ca.dhruvanshi.model.AllModels.User;
import ca.dhruvanshi.model.AllModels.Comment;
import ca.dhruvanshi.model.AllModels.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    // ADD THIS LINE - This injects the value from application.properties
    @Value("${external.api.baseurl}")
    private String baseUrl;
    
    // GET: Fetch all posts
    public List<Post> getAllPosts() {
        String url = baseUrl + "/posts";
        logger.info("GET request to: {}", url);
        
        ResponseEntity<Post[]> response = restTemplate.getForEntity(url, Post[].class);
        List<Post> posts = Arrays.asList(response.getBody());
        
        logger.info("Fetched {} posts", posts.size());
        return posts;
    }
    
    // GET: Fetch single post by ID
    public Post getPostById(Long id) {
        String url = baseUrl + "/posts/" + id;
        logger.info("GET request to: {}", url);
        
        Post post = restTemplate.getForObject(url, Post.class);
        logger.info("Fetched post: {}", post != null ? post.getTitle() : "Not found");
        return post;
    }
    
    // GET: Fetch all users
    public List<User> getAllUsers() {
        String url = baseUrl + "/users";
        logger.info("GET request to: {}", url);
        
        ResponseEntity<List<User>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<User>>() {}
        );
        
        logger.info("Fetched {} users", response.getBody().size());
        return response.getBody();
    }
    
    // GET: Fetch comments for a post
    public List<Comment> getCommentsByPostId(Long postId) {
        String url = baseUrl + "/posts/" + postId + "/comments";
        logger.info("GET request to: {}", url);
        
        ResponseEntity<Comment[]> response = restTemplate.getForEntity(url, Comment[].class);
        List<Comment> comments = Arrays.asList(response.getBody());
        
        logger.info("Fetched {} comments for post {}", comments.size(), postId);
        return comments;
    }
    
    // GET: Fetch all todos
    public List<Todo> getAllTodos() {
        String url = baseUrl + "/todos";
        logger.info("GET request to: {}", url);
        
        ResponseEntity<Todo[]> response = restTemplate.getForEntity(url, Todo[].class);
        List<Todo> todos = Arrays.asList(response.getBody());
        
        logger.info("Fetched {} todos", todos.size());
        return todos;
    }
    
    // POST: Create a new post
    public Post createPost(Post post) {
        String url = baseUrl + "/posts";
        logger.info("POST request to: {}", url);
        logger.info("Request Body: {}", post);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<Post> requestEntity = new HttpEntity<>(post, headers);
        ResponseEntity<Post> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            requestEntity,
            Post.class
        );
        
        logger.info("POST Response Status: {}", response.getStatusCode());
        if (response.getBody() != null) {
            logger.info("Created post with ID: {}", response.getBody().getId());
        }
        
        return response.getBody();
    }
    
    // PUT: Update an existing post
    public Post updatePost(Long id, Post post) {
        String url = baseUrl + "/posts/" + id;
        logger.info("PUT request to: {}", url);
        logger.info("Request Body: {}", post);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<Post> requestEntity = new HttpEntity<>(post, headers);
        ResponseEntity<Post> response = restTemplate.exchange(
            url,
            HttpMethod.PUT,
            requestEntity,
            Post.class
        );
        
        logger.info("PUT Response Status: {}", response.getStatusCode());
        logger.info("Updated post with ID: {}", id);
        
        return response.getBody();
    }
    
    // DELETE: Delete a post
    public String deletePost(Long id) {
        String url = baseUrl + "/posts/" + id;
        logger.info("DELETE request to: {}", url);
        
        restTemplate.delete(url);
        
        logger.info("Deleted post with ID: {}", id);
        return "Post with ID " + id + " deleted successfully";
    }
}