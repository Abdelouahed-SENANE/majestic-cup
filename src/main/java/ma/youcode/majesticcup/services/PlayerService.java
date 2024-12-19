package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface PlayerService extends GenericService<Player , PlayerResponseDTO , PlayerRequestDTO>{

    List<PlayerResponseDTO> createAll(List<PlayerRequestDTO> dto);
    List<Player> findAll(List<String> dto);
}
