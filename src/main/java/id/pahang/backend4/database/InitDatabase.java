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
            System.out.println("Init Post " + postRepository.save(new Post("Head Protection","Workers must wear hard hats where there is potential for objects falling from above, bumps on their heads from fixed objects, or intentional heads in contact with electrical hazards. Hard hats are routinely checked for dents, cracks or damage. hard hat is replaced after a heavy blow or electric shock. Hard hat is maintained in good condition.", 1, new Long(3), null, new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //solution
            System.out.println("Init Post " + postRepository.save(new Post(null,"Keep clear verses all the time. Sort the ingredients and stack them safely. Stacks cannot be too high. Be careful of the floor openings and ensure that they are fenced or closed Remove reject as soon as possible. Provide sufficient lighting. Familiarize with the location and operation of fire fighting equipment.", 2, new Long(1), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg" )));

            //comment
            System.out.println("Init Post " + postRepository.save(new Post(null,"Iya benar", 3, new Long(2), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
            System.out.println("Init Post " + postRepository.save(new Post(null,"Benar", 3, new Long(4), new Long(1), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));


            //problem
            System.out.println("Init Post " + postRepository.save(new Post("Electrical Safety","Work on new and existing energized (hot) electrical circuits is prohibited until all power is shut off and grounds are attached. An effective Lockout/Tagout system is in place. Frayed, damaged or worn electrical cords or cables are promptly replaced. All extension cords have grounding prongs. Protect flexible cords and cables from damage. Sharp corners and projections should be avoided. Use extension cord sets used with portable electric tools and appliancesthat are the three-wire type and designed for hard or extra-hard service. (Look for some of the following letters imprinted on the casing: S, ST, SO, STO.).  All electrical tools and equipment are maintained in safe condition and checked regularly for defects and taken out of service if a defect is found. Do not bypass any protective system or device designed to protect employees from contact with electrical energy. Overhead electrical power lines are located and identified. Ensure that ladders, scaffolds, equipment or materials never come within 10 feet  f electrical power lines. All electrical tools must be properly grounded unless they are of the double insulated type. Multiple plug adapters are prohibited.", 1, new Long(4), null, new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //solution
            System.out.println("Init Post " + postRepository.save(new Post(null, "Before you operate the machine, make sure that the dangerous part of the engine is installed with a guard. Avoid going to any area with sufficient lighting because there may be several dangerous places that have not been equipped with fences. Stay alert and careful to move cranes, hooks or lifting equipment. Before you use an electrical installation or appliance, check the condition of the electrical cables. Avoid dragging the electric cable above the ground or allowing the cable to come into contact with water. Using electrical equipment installed with earth leakage circuit breaker. Use and handle chemicals carefully.", 2, new Long(1), new Long(5),new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));

            //comment
            System.out.println("Init Post " + postRepository.save(new Post(null,"Saya setuju", 3, new Long(2), new Long(5), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
            System.out.println("Init Post " + postRepository.save(new Post(null,"Saya nggak setuju", 3, new Long(3), new Long(5), new Long(2), "http://www.anekabangunan.com/wp-content/uploads/2018/11/7Cara-Mengatasi-Tembok-Retak-Rambut.jpg")));
        };
    }
}

