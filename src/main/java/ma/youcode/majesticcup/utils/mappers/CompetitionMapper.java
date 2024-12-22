package ma.youcode.majesticcup.utils.mappers;

import org.starter.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.CompetitionRequestDTO;
import ma.youcode.majesticcup.dtos.response.CompetitionResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper extends GenericMapper<Competition , CompetitionResponseDTO , CompetitionRequestDTO> {
}
