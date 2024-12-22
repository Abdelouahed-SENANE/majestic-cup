package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.CompetitionRequestDTO;
import ma.youcode.majesticcup.dtos.response.CompetitionResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import ma.youcode.majesticcup.entities.Round;

import java.util.List;


public interface CompetitionService extends GenericService<Competition , CompetitionResponseDTO , CompetitionRequestDTO>{

    CompetitionResponseDTO addTeamsToCompetition(String id,CompetitionRequestDTO dto);

}
