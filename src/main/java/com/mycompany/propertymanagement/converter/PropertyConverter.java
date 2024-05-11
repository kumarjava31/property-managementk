package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertPropertyDTOToPropertyEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();

        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription (propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        pe.setOwnerEmail (propertyDTO.getOwnerEmail());
        pe.setOwnerName (propertyDTO.getOwnerName ());
        pe.setAddress (propertyDTO.getAddress());

        return pe;
    }

    public PropertyDTO convertPropertyEntityToPropertyDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId ());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setAddress(propertyEntity.getAddress());
        return propertyDTO;

    }
}
