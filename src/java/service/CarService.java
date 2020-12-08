/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import basic.Car;
import basic.CarList;
import basic.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author elkat
 */
@Path("/")
public class CarService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarService
     */
    public CarService() {
    }

    /**
     * Retrieves representation of an instance of service.CarService
     * @return an instance of CarList
     */
    @GET
    @Path("/cars/")
    @Produces(MediaType.APPLICATION_JSON)
    public CarList getAll(){
        try {
            return Controller.findAll();
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @GET
    @Path("/cars/{idx}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getOne(@PathParam("idx") int idx){
        try {
            return Controller.findAll().get(idx);
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    @GET
//    @Path("/cars2/")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getAll2() {
//        try {
//            return new ObjectMapper().writeValueAsString(Controller.findAll());
//        } catch (IOException ex) {
//            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    /**
     * PUT method for updating or creating an instance of CarService
     * @param content representation for the resource
     */
    
    @PUT
    @Path("/cars/")
    @Consumes(MediaType.APPLICATION_JSON)
    public String save(Car car) {
        try {
            return Controller.saveOrUpdate(car);
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
            return "There is error, please reload! / contact support";
        }
    }
    
//    @PUT
//    @Path("/cars2/")
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String save2(String carString) {
//        try {
//            return Controller.saveOrUpdate(new ObjectMapper().readValue(carString, Car.class));
//        } catch (IOException ex) {
//            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
//            return "There is error :"+ex.getMessage();
//        }
//    }
    
    @DELETE
    @Path("/cars/{index}")
    @Consumes(MediaType.TEXT_PLAIN)
    public String delete(@PathParam("index")int index) {
        try {
            Controller.delete(index);
            return "delete successful";
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
            return "There is error, please reload! / contact support";
        }
    }
    
    @DELETE
    @Path("/cars/")
    @Consumes(MediaType.TEXT_PLAIN)
    public String deleteAll() {
        try {
            Controller.deleteAll();
            return "delete successful";
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
            return "There is error :"+ex.getMessage();
        }
    }
    
    
    @GET
    @Path("/cars/calc")
    @Consumes(MediaType.TEXT_PLAIN)
    public String calculate(@QueryParam("index") int index, @QueryParam("days")int days) {
        String res="";
        try {
            res=Controller.calculate(index, days);
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
            res="There is error :"+ex.getMessage();
        }
        return res;
    }
    
    ///there is error to convert object to json becouse glich in glassfish 4.1.1 server
    
}
