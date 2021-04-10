package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {

    private static int CARS_COUNT = 0;
    private List<Car> car;

    {

        car = new ArrayList<>();

        car.add(new Car(++CARS_COUNT, "Lamborghini", "т777тн78"));
        car.add(new Car(++CARS_COUNT, "Lada Vesta", "н278нн78"));
        car.add(new Car(++CARS_COUNT, "УАЗ Патриот", "о111ок78"));
        car.add(new Car(++CARS_COUNT, "BMW", "a111aa78"));
        car.add(new Car(++CARS_COUNT, "Mercedes-Benz", "a999aa78"));
    }

    public List<Car> index() {
        return car;
    }

    public List<Car> index(int count) {
        return car.stream().limit(count).collect(Collectors.toList());
    }

    public int carsAmount() {
        return car.size();
    }
}


