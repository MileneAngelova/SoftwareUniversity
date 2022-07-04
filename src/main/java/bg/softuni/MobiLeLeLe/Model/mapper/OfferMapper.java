package bg.softuni.MobiLeLeLe.Model.mapper;

import bg.softuni.MobiLeLeLe.Model.DTO.AddOfferDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.OfferEntity;
import org.mapstruct.Mapper;


    @Mapper(componentModel = "spring")
    public interface OfferMapper {

        OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
    }
