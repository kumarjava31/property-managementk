package com.mycompany.propertymanagement.Service;

import com.mycompany.propertymanagement.DTO.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
// Factory design pattern singleton - One Interface and multiple implement class
// Singleton Bean- @Service annotation applied to single instance object created one time runs

// Beans is called another java class another fancy name has instance objects

// IOC - Inverson of control, - @Autowired create object, that object injected  as required

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
   PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyId);
   PropertyDTO deleteProperty(Long propertyId);
 //  PropertyDTO deletePropertyDescription(Long propertyId);
}