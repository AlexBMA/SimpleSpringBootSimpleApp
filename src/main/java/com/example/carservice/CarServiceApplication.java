package com.example.carservice;

import com.example.carservice.domain.Car;
import com.example.carservice.domain.Owner;
import com.example.carservice.domain.User;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.repository.OwnerRepository;
import com.example.carservice.repository.UserRepository;
import com.example.carservice.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarServiceApplication {

    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository urepository;

    public static void main(String[] args) {
        //Logger log = LoggerFactory.getLogger(CarServiceApplication.class);
        //log.debug("First log");
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            // Place your code here
            repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
            repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
            repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));


            // username: user password: user
            urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
            // username: admin password: admin
            urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));

            System.out.println("\n ");
            System.out.println(AuthenticationService.createToken("admin"));

            //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifD.ipevRNuRP6HflG8cFKnmUPtypruRC4fc1DWtoLL62SY
            //AuthenticationService.

            //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiJhZG1pbiIsImp0aSI6IjEwZTdjNzM5LWM0ODgtNGZkMS1iM2FhLTdhNGY4YzBkNzQwOSIsImlhdCI6MTU1MTQ3NzUxNCwiZXhwIjoxNTUxNDgxMTE0fQ.HPCsi76sQpywyVUOV6nu4rusVXWgIMD9sH21Dw7DgWo
        };
    }

}
