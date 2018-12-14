package ba.etf.zavrsni.mikroservis1.controllers;

import ba.etf.zavrsni.mikroservis1.domain.Skill;
import ba.etf.zavrsni.mikroservis1.repositories.SkillRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class SkillsReciever {

    @Autowired
    SkillRepository skillRepository;

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) throws InterruptedException {
        receive(in, 1);
    }


    public void receive(String in, int receiver) throws InterruptedException {
        String message;
        String[] parts = in.split(",");
        if(parts.length ==1){
            message = parts[0];
        }
        else
        {
            message = Arrays.stream(parts).map( asci -> {return Integer.parseInt(asci);}).map( characater ->{return String.valueOf((char)characater.intValue());}).collect(Collectors.joining(""));
        }


        System.out.println("The recieved skill name is:" + message);



        if(!skillRepository.findById(message).isPresent()){
            Skill s = new Skill();
            s.setName(message);
            skillRepository.save(s);
        }
        else{

            System.out.println("Skill already present");
        }

    }

}
