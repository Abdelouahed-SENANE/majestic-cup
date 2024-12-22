package ma.youcode.majesticcup.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.request.ResultRequestDTO;
import ma.youcode.majesticcup.dtos.request.StatisticRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.*;
import ma.youcode.majesticcup.repositories.MatchRepository;
import ma.youcode.majesticcup.repositories.ResultRepository;
import ma.youcode.majesticcup.repositories.StatisticRepository;
import ma.youcode.majesticcup.services.MatchService;
import ma.youcode.majesticcup.services.ResultService;
import ma.youcode.majesticcup.services.RoundService;
import ma.youcode.majesticcup.services.TeamService;
import ma.youcode.majesticcup.utils.mappers.MatchMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatchServiceImpl extends GenericServiceImpl<Match, MatchResponseDTO, MatchRequestDTO> implements MatchService {

    private static final Logger log = LogManager.getLogger(MatchServiceImpl.class);
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final TeamService teamService;
    private final RoundService roundService;
    private final ResultService resultService;
    public MatchServiceImpl(MatchRepository matchRepository,
                            MatchMapper matchMapper,
                            TeamService teamService,
                            RoundService roundService,
                            ResultService resultService
    ) {
        super(matchRepository, matchMapper, Match.class);
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
        this.teamService = teamService;
        this.roundService = roundService;
        this.resultService = resultService;
    }

    @Override
    public MatchResponseDTO create(MatchRequestDTO dto) {
        Team homeTeam = teamService.getById(dto.homeTeamId());
        Team awayTeam = teamService.getById(dto.awayTeamId());
        Round round = roundService.getById(dto.roundId());
        verifyMatchConstraints(homeTeam, awayTeam, round);
        return matchMapper.toResponseDTO(matchRepository.save(builder(homeTeam, awayTeam, round)));
    }

    @Override
    public MatchResponseDTO addResult(ResultRequestDTO dto , String id) {
        Match match = getById(id);
        match.setResult(resultService.createResult(dto , match));
        return matchMapper.toResponseDTO(match);

    }

    private Match builder(Team homeTeam, Team awayTeam, Round round) {
        return  Match.builder()
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .round(round)
                .build();
    }

    private void verifyMatchConstraints(Team homeTeam , Team awayTeam, Round round) {
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("you cannot play match with the same team");
        }
        assertTeamInCompetition(homeTeam , round);
        assertTeamInCompetition(awayTeam , round);

    }
    private void assertTeamInCompetition(Team team , Round round) {
        if (isTeamMissingInCompetition(team, round)) {
            throw new IllegalArgumentException(String.format("%s team is not exists in %s competition." , team.getName(), round.getCompetition().getName()) );
        }
    }
    private boolean isTeamMissingInCompetition(Team team, Round round) {
        return !round.getCompetition().getTeams().contains(team);
    }

    @Override
    public MatchResponseDTO update(String id, MatchRequestDTO dto) {

        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found."));

        return matchMapper.toResponseDTO(matchRepository.save(match));
    }


}
