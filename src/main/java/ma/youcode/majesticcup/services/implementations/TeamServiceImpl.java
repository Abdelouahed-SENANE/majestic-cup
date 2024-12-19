package ma.youcode.majesticcup.services.implementations;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import ma.youcode.majesticcup.dtos.request.TeamRequestDTO;
import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.exceptions.custom.TeamExistsException;
import ma.youcode.majesticcup.exceptions.custom.TeamSizePlayersException;
import ma.youcode.majesticcup.services.GenericService;
import ma.youcode.majesticcup.utils.mappers.TeamMapper;
import ma.youcode.majesticcup.repositories.TeamRepository;
import ma.youcode.majesticcup.services.PlayerService;
import ma.youcode.majesticcup.services.TeamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl extends GenericServiceImpl<Team, TeamResponseDTO, TeamRequestDTO> implements TeamService {
    private static final Logger log = LogManager.getLogger(TeamServiceImpl.class);
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final PlayerService playerService;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper, PlayerService playerService) {
        super(teamRepository, teamMapper, Team.class);
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.playerService = playerService;
    }

    @Override
    public TeamResponseDTO create(TeamRequestDTO dto) {
        if (isExists(dto.name())) {
            throw new TeamExistsException("Team with name " + dto.name() + " already exists.");
        }

        List<Player> players = playerService.findAll(dto.playerIds());
        Team team = Team.builder()
                .name(dto.name())
                .city(dto.city())
                .players(players)
                .build();

        Team savedTeam = teamRepository.save(team);
        return teamMapper.toResponseDTO(savedTeam);
    }

    @Override
    public TeamResponseDTO update(String id, TeamRequestDTO dto) {

        Team existTeam = getEntity(id);

        if (dto.city() != null && !dto.city().isBlank()) {
            existTeam.setCity(dto.city());
        }
        if (dto.city() != null && !dto.name().isBlank()) {
            existTeam.setName(dto.name());
        }

        if (dto.playerIds() != null && dto.playerIds().size() >= 12) {
            existTeam.getPlayers().clear();
            existTeam.getPlayers().addAll(getPlayers(dto.playerIds()));
        }

        return teamMapper.toResponseDTO(teamRepository.save(existTeam));
    }


    private List<Player> getPlayers(List<String> dto) {
        return playerService.findAll(dto);
    }

    private boolean isExists(String name) {
        return teamRepository.findByName(name).isPresent();
    }
}
