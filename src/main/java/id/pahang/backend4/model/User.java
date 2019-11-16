package id.pahang.backend4.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private int type;
    private String name;
    private String imgDownloadUrl;

    public User() {

    }

    public User(String email, int type, String name, String imgDownloadUrl) {
        this.email = email;
        this.type = type;
        this.name = name;
        this.imgDownloadUrl = imgDownloadUrl;
    }

    public String getImgDownloadUrl() {
        return imgDownloadUrl;
    }

    public void setImgDownloadUrl(String imgDownloadUrl) {
        this.imgDownloadUrl = imgDownloadUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
