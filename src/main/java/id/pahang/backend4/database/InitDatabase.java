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
            System.out.println("Init User  " + userRepository.save(new User("worker2@gmail.com",2,"Nama Worker 2", "https://assets-a2.kompasiana.com/items/album/2018/11/21/foto-pria-ganteng-indonesia-21-5bf5756faeebe169634adeb4.jpg?t=o&v=350")));
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
            System.out.println("Init Post " + postRepository.save(new Post("Personal Safety","Construction workers need to wear work shoes or shoes that are slip-resistant and puncture-resistant. Safety-tipped footwear is used to prevent crushed toes when working around heavy equipment or falling objects.", 1, new Long(3), null, new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //solution
            System.out.println("Init Post " + postRepository.save(new Post(null,"Wear protective equipment. Do not drink or take drugs while working. Pay attention to personal hygiene. Do not play in the workplace. Report to your supervisor immediately if you notice any unsafe condition", 2, new Long(1), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg" )));

            //comment
            System.out.println("Init Post " + postRepository.save(new Post(null,"Yes that right, but ..", 3, new Long(2), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
            System.out.println("Init Post " + postRepository.save(new Post(null,"Thanks! I have looking for this solution for a year!", 3, new Long(4), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));


            //problem
            System.out.println("Init Post " + postRepository.save(new Post("Head Protection","Workers must wear hard hats where there is potential for objects falling from above, bumps on their heads from fixed objects, or intentional heads in contact with electrical hazards. Hard hats are routinely checked for dents, cracks or damage. The hard hat is replaced after a heavy blow or electric shock. Hard hat is maintained in good condition.", 1, new Long(4), null, new Long(2), "https://www.premiersafety.com/cmsstatic/img/marketing/Cat_Head_Protection.jpg")));

            //solution
            System.out.println("Init Post " + postRepository.save(new Post(null, "Workers must wear hard hats where there is potential for objects falling from above, bumps on their heads from fixed objects, or intentional heads in contact with electrical hazards. Hard hats are routinely checked for dents, cracks or damage. The hard hat is replaced after a heavy blow or electric shock. Hard hat is maintained in good condition.", 2, new Long(1), new Long(5),new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //comment
            System.out.println("Init Post " + postRepository.save(new Post(null,"I Think so", 3, new Long(2), new Long(5), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
            System.out.println("Init Post " + postRepository.save(new Post(null,"Sorry, is the hat must SNI signed?", 3, new Long(3), new Long(5), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
        };
    }
}

