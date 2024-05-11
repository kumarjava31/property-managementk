package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi")
public class PropertyController {

    @Value ("${pms.dummy:}")
    private String dummy;

    @Value ("${spring.datasource.url:}")
    private String dburl;

    @Autowired
    private PropertyService propertyService;

    //Restfull Api is just mapping of a url to a java class function
    //http://localhost:8080/api/vi/properties/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("/properties")

     public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<> (propertyDTO, HttpStatus.CREATED);
        return responseEntity;


    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        System.out.println(dummy);
        System.out.println(dburl);
        List<PropertyDTO> propertyDTOList = propertyService.getAllProperties();

        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyDTOList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public  ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<> (propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@PathVariable Long propertyId, @RequestBody PropertyDTO propertyDTO){

        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<> (propertyDTO, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@PathVariable Long propertyId, @RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<> (propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-title/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyTitle(@PathVariable Long propertyId, @RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.updatePropertyTitle(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<> (propertyDTO, HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/properties/{propertyId}")

    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<> (null, HttpStatus.OK);
        return  responseEntity;

    }


}
