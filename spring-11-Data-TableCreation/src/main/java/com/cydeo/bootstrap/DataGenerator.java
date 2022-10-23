package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repostory.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {



        Car s1 = new Car("BMW","M3");
        Car s2 = new Car("HONDA","Civic");
        Car s3 = new Car("TOYOTA","Prius");

        // I want to save the data to DB

        carRepository.save(s1);
        carRepository.save(s2);
        carRepository.save(s3);






    }
}
