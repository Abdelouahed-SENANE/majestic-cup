package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.TeamRequestDTO;
import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;

public interface TeamService {

    TeamResponseDTO create(TeamRequestDTO teamRequestDTO);



}
