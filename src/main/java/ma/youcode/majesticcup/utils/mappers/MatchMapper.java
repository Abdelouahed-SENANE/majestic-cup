package ma.youcode.majesticcup.utils.mappers;

import ma.senane.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper extends GenericMapper<Match , MatchResponseDTO , MatchRequestDTO> {
}
