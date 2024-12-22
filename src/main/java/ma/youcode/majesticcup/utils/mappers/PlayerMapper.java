package ma.youcode.majesticcup.utils.mappers;

import org.starter.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends GenericMapper<Player , PlayerResponseDTO , PlayerRequestDTO> {
}
