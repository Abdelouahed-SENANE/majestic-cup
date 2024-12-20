package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.Match;


public interface MatchService extends GenericService<Match, MatchResponseDTO, MatchRequestDTO>{
}
