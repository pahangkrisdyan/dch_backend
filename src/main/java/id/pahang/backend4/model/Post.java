package id.pahang.backend4.model;


import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String text;
    private int type;

    private Long userId;

    private Long postParentId;

    private Long tagId;

    private String imgDownloadUrl;

    private Date createdAt = new Date();
    private Date updatedAt = new Date();

    public Post() {

    }

    public Post(String title, String text, int type, Long userId, Long postParentId, Long tagId, String imgDownloadUrl) {
        this.text = text;
        this.type = type;
        this.userId = userId;
        this.postParentId = postParentId;
        this.tagId = tagId;
        this.imgDownloadUrl = imgDownloadUrl;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgDownloadUrl() {
        return imgDownloadUrl;
    }

    public void setImgDownloadUrl(String imgDownloadUrl) {
        this.imgDownloadUrl = imgDownloadUrl;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @PreUpdate
    public void setLastUpdate() {  this.updatedAt = new Date(); }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
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
}