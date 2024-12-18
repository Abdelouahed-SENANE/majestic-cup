package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;

import java.util.List;

public interface PlayerService {

    PlayerResponseDTO edit(PlayerRequestDTO dto);
    void delete(PlayerRequestDTO dto);
    PlayerResponseDTO create(PlayerRequestDTO dto);
    List<Player> createAll(List<PlayerRequestDTO> dto);
}
