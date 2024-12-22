package ma.youcode.majesticcup.utils.mappers;

import org.starter.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.TeamRequestDTO;
import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;
import ma.youcode.majesticcup.entities.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper extends GenericMapper<Team, TeamResponseDTO, TeamRequestDTO> {
}
