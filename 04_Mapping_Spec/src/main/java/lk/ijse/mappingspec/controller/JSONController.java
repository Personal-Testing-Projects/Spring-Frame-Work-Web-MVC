package main.java.lk.ijse.mappingspec.controller;

import main.java.lk.ijse.mappingspec.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class JSONController {
   /* @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.getId() + " " + customerDTO.getName() + " " +
                customerDTO.getAddress() + " " + customerDTO.getPhone());
        //null values printing when sending a json in to this.
        //@ModelAttribute annotation removed and testing done. but still nulls are printing.
        //set parameter as String id, but still nulls are printing.
        //JSON are not working for these types
        //Because JSON is special type. It is option type data type.
        //So we want some one to process JSON
        //So how to do?
        //Put @RequestBody annotation in front of parameter. This a required annotation.
        //It will map json to java object.
        //Now I'm gonna comment this for test that.
    }*/

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO.getId() + " " + customerDTO.getName() + " " +
                customerDTO.getAddress() + " " + customerDTO.getPhone());
        //Request still not working. due to unsupported type
        //Reason why there is no vendor support for this type.
        //So we should add JSON vendor
        //There are somany types vendors like jackson, GSON, JProcessing
        //We use Jason library to convert java object to json
        //We have to put jackson to the start of the classpath
        //It will put jackson to child context
        //Add Jackson dependency to the classpath
        //Add dependencies to the web profile
        //And just rerun the project
        //Now it will work values are printed

        //How this work after adding libs to the classpath?

        //Try returning json
        //return customerDTO;
        //A JSON will be returned
        //And it will be printed

        //Try to send dto array
        //And also it will be printed

        //Request catch by dispatcher servlet
        //And then send to controller
        //Jackson converts json to java object vice versa
        //In child context there is a converter, it is a predefined object
        //This converter will check that some one to convert json to java object
        //It will found the Jackson when it is added to the classpath
        //To work this converter parameters should have @RequestBody annotation.
        //Then converter create an object from Jackson and add to the child context
        //Converter is placed before the dispatcher servlet
        //Jackson is a third party library that can work with JSON
        //What converter do ? Data coming from requests and responses body data are converting to different Mime types
    }
}
