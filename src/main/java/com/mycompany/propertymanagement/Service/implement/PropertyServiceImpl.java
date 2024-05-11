package com.mycompany.propertymanagement.Service.implement;

import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.Repository.PropertyRepository;
import com.mycompany.propertymanagement.Service.PropertyService;
import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value ("${spring.datasource.url:}")
    private String dburl;
    /**
     * @param propertyDTO
     * @return
     */
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

      PropertyEntity pe =  propertyConverter.convertPropertyDTOToPropertyEntity (propertyDTO);
     pe = propertyRepository.save (pe);
     propertyDTO = propertyConverter.convertPropertyEntityToPropertyDTO (pe);
        return propertyDTO;
    }

    /**
     * @return
     */
    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("getAllProperties incide of services  :" +dummy +"Dummy URL:  " + dburl);
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll ();
        List<PropertyDTO> propertyDTOList = new ArrayList<> ();
       for(PropertyEntity pe : listOfProps){
           PropertyDTO propertyDTO = propertyConverter.convertPropertyEntityToPropertyDTO (pe);
           propertyDTOList.add(propertyDTO);
       }

        return  propertyDTOList;
    }

    /**
     * @param propertyDTO
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity>  optEnt = propertyRepository.findById(propertyId);
      //  PropertyDTO dto= propertyConverter.convertPropertyEntityToPropertyDTO (optEnt.get());
        PropertyDTO dto = null;
        if(optEnt.isPresent ()){

            PropertyEntity pe = optEnt.get ();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription (propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setOwnerEmail (propertyDTO.getOwnerEmail());
            pe.setOwnerName (propertyDTO.getOwnerName ());
            pe.setAddress (propertyDTO.getAddress());
            dto = propertyConverter.convertPropertyEntityToPropertyDTO (pe);
            propertyRepository.save(pe);
        }


        return dto;
    }

    /**
     * @param propertyDTO
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity>  optEnt = propertyRepository.findById(propertyId);
        //  PropertyDTO dto= propertyConverter.convertPropertyEntityToPropertyDTO (optEnt.get());
        PropertyDTO dto = null;
        if(optEnt.isPresent ()){

            PropertyEntity pe = optEnt.get ();
            pe.setDescription (propertyDTO.getDescription());



//            pe.setTitle(propertyDTO.getTitle());
//            pe.setPrice(propertyDTO.getPrice());
//            pe.setDescription (propertyDTO.getDescription());
//            pe.setOwnerEmail (propertyDTO.getOwnerEmail());
//            pe.setOwnerName (propertyDTO.getOwnerName ());
//            pe.setAddress (propertyDTO.getAddress());

            dto = propertyConverter.convertPropertyEntityToPropertyDTO (pe);
            propertyRepository.save(pe);
        }


        return dto;


    }

    /**
     * @param propertyDTO
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity>  optEnt = propertyRepository.findById(propertyId);
        //  PropertyDTO dto= propertyConverter.convertPropertyEntityToPropertyDTO (optEnt.get());
        PropertyDTO dto = null;
        if(optEnt.isPresent ()){

            PropertyEntity pe = optEnt.get ();
            pe.setPrice(propertyDTO.getPrice());


//            pe.setTitle(propertyDTO.getTitle());
//            pe.setDescription (propertyDTO.getDescription());
//            pe.setOwnerEmail (propertyDTO.getOwnerEmail());
//            pe.setOwnerName (propertyDTO.getOwnerName ());
//            pe.setAddress (propertyDTO.getAddress());

            dto = propertyConverter.convertPropertyEntityToPropertyDTO (pe);
            propertyRepository.save(pe);
        }


        return dto;


    }

    /**
     * @param propertyDTO
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity>  optEnt = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEnt.isPresent ()){
            PropertyEntity pe = optEnt.get ();
            pe.setTitle(propertyDTO.getTitle());
            dto = propertyConverter.convertPropertyEntityToPropertyDTO (pe);
            propertyRepository.save(pe);

        }
        return dto;
    }

    /**
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO deleteProperty(Long propertyId) {
        PropertyEntity pe = propertyRepository.findById(propertyId).get ();
        propertyRepository.delete (pe);
        return propertyConverter.convertPropertyEntityToPropertyDTO (pe);


    }
}
