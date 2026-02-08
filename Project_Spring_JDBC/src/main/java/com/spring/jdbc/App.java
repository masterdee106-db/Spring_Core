package com.spring.jdbc;

import com.spring.jdbc.Entity.Fish;
import com.spring.jdbc.config.FishConfig;
import com.spring.jdbc.dao.FishDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started....." );
        ApplicationContext context = new AnnotationConfigApplicationContext(FishConfig.class);

        FishDao fishDao = context.getBean("fishDao",FishDao.class);

        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }

        Fish fish = new Fish();

//        Insert FIsh
//        fish.setFishId(212);
//        fish.setFishName("Katla");
//        fish.setFishType("Fresh Water");
//        int result =fishDao.addFish(fish);
//        System.out.println("Number of inserted Data: "+result);

// Read Fishses
        fishDao.getAllFish().forEach(System.out::println);

        //    Read fish by Id
        Fish f1 =fishDao.getFishById(206);
        System.out.println("Fetched: "+f1);
    }


}
