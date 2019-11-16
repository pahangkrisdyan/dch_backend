package id.pahang.backend4.database;

import id.pahang.backend4.model.Post;
import id.pahang.backend4.model.Tag;
import id.pahang.backend4.model.User;
import id.pahang.backend4.repository.PostRepository;
import id.pahang.backend4.repository.TagRepository;
import id.pahang.backend4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class InitDatabase {
    @Bean
    CommandLineRunner initUser(UserRepository userRepository) {
        return args -> {
            // Expert
            System.out.println("Init User " + userRepository.save(new User("expert1@gmail.com",1,"Nama Expert 1", "https://assets-a2.kompasiana.com/items/album/2018/11/21/foto-pria-ganteng-indonesia-21-5bf5756faeebe169634adeb4.jpg?t=o&v=350")));
            System.out.println("Init User " + userRepository.save(new User("expert1@gmail.com",1,"Nama Expert 2", "https://assets-a2.kompasiana.com/items/album/2018/11/21/foto-pria-ganteng-indonesia-21-5bf5756faeebe169634adeb4.jpg?t=o&v=350")));
            // Worker
            System.out.println("Init User  " + userRepository.save(new User("worker1@gmail.com",2,"Nama Worker 1", "https://assets-a2.kompasiana.com/items/album/2018/11/21/foto-pria-ganteng-indonesia-21-5bf5756faeebe169634adeb4.jpg?t=o&v=350")));
            System.out.println("Init User  " + userRepository.save(new User("worker1@gmail.com",2,"Nama Worker 2", "https://assets-a2.kompasiana.com/items/album/2018/11/21/foto-pria-ganteng-indonesia-21-5bf5756faeebe169634adeb4.jpg?t=o&v=350")));
        };
    }

    @Bean
    CommandLineRunner initTag(TagRepository tagRepository) {
        return args -> {
            System.out.println("Init Tag " + tagRepository.save(new Tag("Select...")));
            System.out.println("Init Tag " + tagRepository.save(new Tag("Quality Construction")));
            System.out.println("Init Tag " + tagRepository.save(new Tag("Construction Equipments")));
            System.out.println("Init Tag " + tagRepository.save(new Tag("Construction Safety")));
            System.out.println("Init Tag " + tagRepository.save(new Tag("Construction Materials")));
            System.out.println("Init Tag " + tagRepository.save(new Tag("Others")));
        };
    }

    @Bean
    CommandLineRunner initPost(PostRepository postRepository) {
        return args -> {
            //String text, int type, Long userId, Long postParentId, Long tagId, String imgDownloadUrl
            //problem
            System.out.println("Init Post " + postRepository.save(new Post("Berapa 1 + 1?", 1, new Long(3), null, new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //solution
            System.out.println("Init Post " + postRepository.save(new Post("Jawabannya 2", 2, new Long(1), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //comment
            System.out.println("Init Post " + postRepository.save(new Post("Iya benar 2", 3, new Long(2), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
            System.out.println("Init Post " + postRepository.save(new Post("WKWKWK masak 2 sih", 3, new Long(4), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));


            //problem
            System.out.println("Init Post " + postRepository.save(new Post("Berapa 5 + 5?", 1, new Long(4), null, new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //solution
            System.out.println("Init Post " + postRepository.save(new Post("Jawabannya adalah 10", 2, new Long(1), new Long(5),new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //comment
            System.out.println("Init Post " + postRepository.save(new Post("Saya setuju 10", 3, new Long(2), new Long(5), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
            System.out.println("Init Post " + postRepository.save(new Post("Saya nggak setuju", 3, new Long(3), new Long(5), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
        };
    }




}

