package basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    public static void writeToFile(CarList cars, String file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
//        Logger.getLogger(Controller.class.getName()).log(Level.INFO, "saving CARS :" + cars);
        objectMapper.writeValue(new File("C:/TM352/"+file+".json"), cars);
    }
    public static CarList readFromFile(String file) throws IOException {
        file="C:/TM352/" + file + ".json";
        File file1 = new File(file);
        if(!file1.exists()){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "Creating file at : "+file);
            file1.createNewFile();
            return new CarList();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        CarList cars=null;
        try{
            cars = objectMapper.readValue(file1, CarList.class);
        }catch (MismatchedInputException e){
            cars= new CarList();
        }
        return cars;
    }

    public static String saveOrUpdate(Car car) throws IOException {
        String res="";
        CarList cars=readFromFile("cars");
        int index = cars.indexOf(car);
        if(index==-1){
            cars.add(car);
            res= "successfully Inserted ";
        }else{
            cars.get(index).setPriceDay(car.getPriceDay());
            res="successfully updated";
        }
        writeToFile(cars,"cars");
        return res;
    }

    public static String delete(int index) throws IOException {
        CarList cars=readFromFile("cars");
        cars.remove(index);
        writeToFile(cars,"cars");
        return "successfully deleted";
    }

    public static String deleteAll() throws IOException {
        writeToFile(new CarList(),"cars");
        return "successfully deleted";
    }

    public static CarList findAll() throws IOException {
        return readFromFile("cars");
    }
    
    public static String calculate(int index, int days) throws IOException {
        double total=readFromFile("cars").get(index).getPriceDay()*days;
        String res=String.format("Total renting price for <b> %d </b> days : <b> %.3f $ </b>",days,total);
        return res;
    }



    public static void main(String[] args) {
    }

}
