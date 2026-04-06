package ca.dhruvanshi.model;

// No Lombok imports - manual getters and setters

public class AllModels {
    
    // Post Model
    public static class Post {
        private Long userId;
        private Long id;
        private String title;
        private String body;
        
        // Constructors
        public Post() {}
        
        public Post(Long userId, Long id, String title, String body) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.body = body;
        }
        
        // Getters and Setters
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        
        public String getBody() { return body; }
        public void setBody(String body) { this.body = body; }
        
        @Override
        public String toString() {
            return "Post{userId=" + userId + ", id=" + id + ", title='" + title + "', body='" + body + "'}";
        }
    }
    
    // User Model
    public static class User {
        private Long id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;
        
        public User() {}
        
        public User(Long id, String name, String username, String email, Address address, String phone, String website, Company company) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.address = address;
            this.phone = phone;
            this.website = website;
            this.company = company;
        }
        
        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public Address getAddress() { return address; }
        public void setAddress(Address address) { this.address = address; }
        
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        
        public String getWebsite() { return website; }
        public void setWebsite(String website) { this.website = website; }
        
        public Company getCompany() { return company; }
        public void setCompany(Company company) { this.company = company; }
        
        // Address inner class
        public static class Address {
            private String street;
            private String suite;
            private String city;
            private String zipcode;
            private Geo geo;
            
            public Address() {}
            
            public Address(String street, String suite, String city, String zipcode, Geo geo) {
                this.street = street;
                this.suite = suite;
                this.city = city;
                this.zipcode = zipcode;
                this.geo = geo;
            }
            
            public String getStreet() { return street; }
            public void setStreet(String street) { this.street = street; }
            
            public String getSuite() { return suite; }
            public void setSuite(String suite) { this.suite = suite; }
            
            public String getCity() { return city; }
            public void setCity(String city) { this.city = city; }
            
            public String getZipcode() { return zipcode; }
            public void setZipcode(String zipcode) { this.zipcode = zipcode; }
            
            public Geo getGeo() { return geo; }
            public void setGeo(Geo geo) { this.geo = geo; }
            
            // Geo inner class
            public static class Geo {
                private String lat;
                private String lng;
                
                public Geo() {}
                
                public Geo(String lat, String lng) {
                    this.lat = lat;
                    this.lng = lng;
                }
                
                public String getLat() { return lat; }
                public void setLat(String lat) { this.lat = lat; }
                
                public String getLng() { return lng; }
                public void setLng(String lng) { this.lng = lng; }
            }
        }
        
        // Company inner class
        public static class Company {
            private String name;
            private String catchPhrase;
            private String bs;
            
            public Company() {}
            
            public Company(String name, String catchPhrase, String bs) {
                this.name = name;
                this.catchPhrase = catchPhrase;
                this.bs = bs;
            }
            
            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
            
            public String getCatchPhrase() { return catchPhrase; }
            public void setCatchPhrase(String catchPhrase) { this.catchPhrase = catchPhrase; }
            
            public String getBs() { return bs; }
            public void setBs(String bs) { this.bs = bs; }
        }
    }
    
    // Comment Model
    public static class Comment {
        private Long postId;
        private Long id;
        private String name;
        private String email;
        private String body;
        
        public Comment() {}
        
        public Comment(Long postId, Long id, String name, String email, String body) {
            this.postId = postId;
            this.id = id;
            this.name = name;
            this.email = email;
            this.body = body;
        }
        
        public Long getPostId() { return postId; }
        public void setPostId(Long postId) { this.postId = postId; }
        
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public String getBody() { return body; }
        public void setBody(String body) { this.body = body; }
    }
    
    // Todo Model
    public static class Todo {
        private Long userId;
        private Long id;
        private String title;
        private Boolean completed;
        
        public Todo() {}
        
        public Todo(Long userId, Long id, String title, Boolean completed) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.completed = completed;
        }
        
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        
        public Boolean getCompleted() { return completed; }
        public void setCompleted(Boolean completed) { this.completed = completed; }
    }
}