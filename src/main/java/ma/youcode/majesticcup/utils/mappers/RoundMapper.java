package ma.youcode.majesticcup.utils.mappers;

import org.starter.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.RoundRequestDTO;
import ma.youcode.majesticcup.dtos.response.RoundResponseDTO;
import ma.youcode.majesticcup.entities.Round;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoundMapper extends GenericMapper<Round , RoundResponseDTO , RoundRequestDTO> {
}
