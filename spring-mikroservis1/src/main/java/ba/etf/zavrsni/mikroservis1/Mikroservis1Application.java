package ba.etf.zavrsni.mikroservis1;

import ba.etf.zavrsni.mikroservis1.controllers.SkillsReciever;
import ba.etf.zavrsni.mikroservis1.domain.Project;
import ba.etf.zavrsni.mikroservis1.domain.RegisteredUser;
import ba.etf.zavrsni.mikroservis1.domain.Skill;
import ba.etf.zavrsni.mikroservis1.repositories.ProjectRepository;
import ba.etf.zavrsni.mikroservis1.repositories.SkillRepository;
import ba.etf.zavrsni.mikroservis1.repositories.UserRepository;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableRabbit
public class Mikroservis1Application {



    public static void main(String[] args) {
        SpringApplication.run(Mikroservis1Application.class, args);
    }

    @Component
    public static class DummySetupRunner implements ApplicationRunner{

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private SkillRepository skillRepository;

        @Autowired
        private ProjectRepository projectRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            RegisteredUser user1 = new RegisteredUser();
            user1.setUsername("klijent");
            user1.setEmail("klijent@gmail.com");
            user1.setPassword("password");

            user1 = userRepository.save(user1);

            Skill skill1 = new Skill();
            skill1.setName("ReactJS");

            Skill skill2 = new Skill();
            skill2.setName("AngularJS");

            Skill skill3 = new Skill();
            skill3.setName("NodeJS");

            skill1 = skillRepository.save(skill1);
            skill2 = skillRepository.save(skill2);
            skill3 = skillRepository.save(skill3);


            Project project1 = new Project();
            project1.setCreator(user1);
            project1.setDescription("Frontend developers needed");
            project1.addSkills(skill1,skill2);

            Project project2 = new Project();
            project2.setCreator(user1);
            project2.setDescription("Backend developers needed");
            project2.addSkills(skill3);

            Project project3 = new Project();
            project3.setCreator(user1);
            project3.setDescription("Everything needed!");
            project3.addSkills(skill1,skill2,skill3);



            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);


        }
    }
}
