package ma.youcode.majesticcup.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.repositories.PlayerRepository;
import ma.youcode.majesticcup.services.PlayerService;
import ma.youcode.majesticcup.services.TeamService;
import ma.youcode.majesticcup.utils.mappers.PlayerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerServiceImpl extends GenericServiceImpl<Player, PlayerResponseDTO , PlayerRequestDTO> implements PlayerService  {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        super(playerRepository, playerMapper , Player.class);
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;

    }

    @Override
    public PlayerResponseDTO update(String id,PlayerRequestDTO dto) {

        Player existPlayer = getById(id);

        if (dto.name() != null && !dto.name().isBlank()) {
            existPlayer.setName(dto.name());
        }

        if (dto.position() != null && !dto.position().isBlank()) {
            existPlayer.setPosition(dto.name());
        }

        if (dto.surname() != null && !dto.surname().isBlank()) {
            existPlayer.setSurname(dto.name());
        }
        if (dto.number() != null) {
            existPlayer.setNumber(dto.number());
        }

        return playerMapper.toResponseDTO(playerRepository.save(existPlayer));
    }

    @Override
    public PlayerResponseDTO create(PlayerRequestDTO dto) {
        Player player = playerMapper.fromRequestDTO(dto);
        return playerMapper.toResponseDTO(playerRepository.save(player));
    }

    @Override
    public List<PlayerResponseDTO> createAll(List<PlayerRequestDTO> dto) {
        List<Player> players = playerMapper.fromRequestDTOs(dto);
        return playerMapper.toResponseDTOs(playerRepository.saveAll(players));
    }



    @Override
    public List<Player> findAll(List<String> ids) {
        return ids.stream()
                .map(id -> playerRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Player with id " + id + " not found.")))
                .collect(Collectors.toList());
    }
}
