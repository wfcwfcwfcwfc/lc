package io.fengchao.corejava.jackson;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Intro {
    private static ObjectMapper om = new ObjectMapper();
    public static void main(String[] args) throws IOException {
       Car car = new Car();
       car.color = "red";
       car.type = "Sedan";

       om.writeValue(new File("target/car1.txt"), car);
       String str = om.writeValueAsString(car);
//     byte[] bytes = om.writeValueAsBytes(new File("target/car.txt"), car);
       byte[] bytes = om.writeValueAsBytes(car);

       Car car1 = om.readValue(new File("target/car.txt"), Car.class);
       JsonNode jsonNode = om.readTree(new File("target/car.txt"));

       String strList = "[" + str + "]";

       List<Car> carList = om.readValue(strList, new TypeReference<List<Car>>(){});




    }

    static class Car {
        public String color;
        public String type;
    }

}

