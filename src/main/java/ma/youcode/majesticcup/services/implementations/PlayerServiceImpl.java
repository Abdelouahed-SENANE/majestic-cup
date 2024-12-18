package ma.youcode.majesticcup.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import ma.youcode.majesticcup.repositories.PlayerRepository;
import ma.youcode.majesticcup.services.PlayerService;
import ma.youcode.majesticcup.utils.mappers.PlayerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerResponseDTO edit(PlayerRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(PlayerRequestDTO dto) {

    }

    @Override
    public PlayerResponseDTO create(PlayerRequestDTO dto) {
        Player player = playerMapper.fromRequestDTO(dto);
        return playerMapper.toResponseDTO(playerRepository.save(player));
    }

    @Override
    public List<Player> createAll(List<PlayerRequestDTO> dto) {
        List<Player> players = playerMapper.fromRequestDTOs(dto);
        return playerRepository.saveAll(players);
    }
}
