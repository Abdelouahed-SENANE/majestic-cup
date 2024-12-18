package ma.youcode.majesticcup.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.dtos.request.TeamRequestDTO;
import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.exceptions.custom.TeamExistsException;
import ma.youcode.majesticcup.exceptions.custom.TeamSizePlayersException;
import ma.youcode.majesticcup.utils.mappers.TeamMapper;
import ma.youcode.majesticcup.repositories.TeamRepository;
import ma.youcode.majesticcup.services.PlayerService;
import ma.youcode.majesticcup.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final PlayerService playerService;

    @Override
    public TeamResponseDTO create(TeamRequestDTO dto) {
        if (isExists(dto.name())) {
            throw new TeamExistsException("Team with name " + dto.name() + " already exists.");
        }

        List<Player> players = playerService.createAll(dto.players());
        Team team = Team.builder()
                        .name(dto.name())
                        .city(dto.city())
                        .players(players)
                        .build();

        Team savedTeam = teamRepository.save(team);
        return teamMapper.toResponseDTO(savedTeam);
    }

    private boolean isExists(String name) {
        return teamRepository.findByName(name).isPresent();
    }
}
