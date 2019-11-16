package id.pahang.backend4.controller;


import id.pahang.backend4.model.Post;
import id.pahang.backend4.repository.PostRepository;
import id.pahang.backend4.repository.TagRepository;
import id.pahang.backend4.repository.UserRepository;
import id.pahang.backend4.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import id.pahang.backend4.constant.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/")
    public PostRes create(@RequestBody Post post){
        return new PostRes(postRepository.save(post));
    }

    @GetMapping("/problems")
    public List<PostRes> getAllProblem(){
        return postRepository.findByType(1).stream().map(item -> {
            return new PostRes(item);
        }).collect(Collectors.toList());
    }

    @GetMapping()
    public List getAllPost(){
        return postRepository.findAll();
    }

    @DeleteMapping("/{postId}")
    public PostRes deletePost(@PathVariable Long postId){
        Post post = postRepository.findById(postId).get();
        postRepository.deleteById(postId);
        return new PostRes(post);
    }

    @PutMapping("/{postId}")
    public PostRes updatePost(@PathVariable Long postId, @RequestBody Post updatedPost){
        Post post = postRepository.findById(postId).get();
        if(updatedPost.getText()!=null){
            post.setText(updatedPost.getText());
        }
        if(updatedPost.getType()!=0){
            post.setType(updatedPost.getType());
        }
        if(updatedPost.getUserId()!=null){
            post.setUserId(updatedPost.getUserId());
        }
        if(updatedPost.getPostParentId()!=0){
            post.setPostParentId(updatedPost.getPostParentId());
        }
        return new PostRes(post);
    }

    @GetMapping("/{postId}")
    public PostRes getPost(@PathVariable Long postId){
        return new PostRes(postRepository.findById(postId).get());
    }

    class PostRes {
        private Long id;

        private String text;

        private int type;

        private Long userId;

        private String userName;

        private String userImageUrl;

        private Long postParentId;

        private String createdAt;

        private String updatedAt;

        private int voteCount;

        private String tagName;

        private String imgDownloadUrl;

        private PostRes solution;

        private List<PostRes> comments;


        public PostRes(Post post) {
            this.id = post.getId();
            this.postParentId = post.getPostParentId();
            this.text = post.getText();
            this.type = post.getType();
            this.userId = post.getUserId();
            this.createdAt = Constant.MONTH_NAME[post.getCreatedAt().getMonth()] + " " + post.getCreatedAt().getDate() + ", " + (post.getCreatedAt().getYear()+1900);
            this.updatedAt = Constant.MONTH_NAME[post.getUpdatedAt().getMonth()] + " " + post.getUpdatedAt().getDate() + ", " + (post.getUpdatedAt().getYear()+1900);
            this.voteCount = voteRepository.findByPostId(post.getId()).size();
            try{
                this.solution = new PostRes(postRepository.findByTypeAndPostParentId(2, post.getId()).get(0));
            }catch (IndexOutOfBoundsException e){
                this.solution = null;
            }
            this.comments = postRepository.findByTypeAndPostParentId(3, post.getId()).stream().map(item->{
                return new PostRes(item);
            }).collect(Collectors.toList());
            this.tagName =  tagRepository.findById(post.getTagId()).get().getName();
            this.imgDownloadUrl = post.getImgDownloadUrl();
            this.userName = userRepository.findById(post.getUserId()).get().getName();
            this.userImageUrl = userRepository.findById(post.getUserId()).get().getImgDownloadUrl();
        }

        public String getUserImageUrl() {
            return userImageUrl;
        }

        public void setUserImageUrl(String userImageUrl) {
            this.userImageUrl = userImageUrl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getPostParentId() {
            return postParentId;
        }

        public void setPostParentId(Long postParentId) {
            this.postParentId = postParentId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public String getImgDownloadUrl() {
            return imgDownloadUrl;
        }

        public void setImgDownloadUrl(String imgDownloadUrl) {
            this.imgDownloadUrl = imgDownloadUrl;
        }

        public PostRes getSolution() {
            return solution;
        }

        public void setSolution(PostRes solution) {
            this.solution = solution;
        }

        public List<PostRes> getComments() {
            return comments;
        }

        public void setComments(List<PostRes> comments) {
            this.comments = comments;
        }
    }
}



