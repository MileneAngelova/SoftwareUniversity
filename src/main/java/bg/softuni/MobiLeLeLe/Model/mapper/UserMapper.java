package bg.softuni.MobiLeLeLe.Model.mapper;

import bg.softuni.MobiLeLeLe.Model.Entity.DTO.UserRegisterDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);
}
