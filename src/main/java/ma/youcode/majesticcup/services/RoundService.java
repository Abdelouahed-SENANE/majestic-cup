package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.CompetitionRequestDTO;
import ma.youcode.majesticcup.dtos.request.RoundRequestDTO;
import ma.youcode.majesticcup.dtos.response.CompetitionResponseDTO;
import ma.youcode.majesticcup.dtos.response.RoundResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import ma.youcode.majesticcup.entities.Round;

import java.util.List;


public interface RoundService extends GenericService<Round, RoundResponseDTO, RoundRequestDTO>{
    List<Round> createAll(List<Round> rounds);
}
