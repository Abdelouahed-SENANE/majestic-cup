package ma.youcode.majesticcup.services.implementations;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import ma.youcode.majesticcup.dtos.request.CompetitionRequestDTO;
import ma.youcode.majesticcup.dtos.response.CompetitionResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import ma.youcode.majesticcup.entities.Round;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.repositories.CompetitionRepository;
import ma.youcode.majesticcup.repositories.TeamRepository;
import ma.youcode.majesticcup.services.CompetitionService;
import ma.youcode.majesticcup.utils.mappers.CompetitionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompetitionServiceImpl extends GenericServiceImpl<Competition, CompetitionResponseDTO, CompetitionRequestDTO> implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;
    private final TeamRepository teamRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, CompetitionMapper competitionMapper, TeamRepository teamRepository) {
        super(competitionRepository, competitionMapper, Competition.class);
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
        this.teamRepository = teamRepository;
    }

    @Override
    public CompetitionResponseDTO create(CompetitionRequestDTO competitionRequestDTO) {

        Competition competition = competitionMapper.fromRequestDTO(competitionRequestDTO);
        competition.setTeams(new ArrayList<>());
        competition.setRounds(new ArrayList<>());
        competition.setCurrentRound(1);
        return competitionMapper.toResponseDTO(competitionRepository.save(competition));

    }

    @Override
    public CompetitionResponseDTO update(String id, CompetitionRequestDTO competitionRequestDTO) {
        return null;
    }

    @Override
    public void addRoundToCompetition(Competition competition,Round round) {
        verifyRoundDuplication(competition , round.getRoundNumber());
        competition.getRounds().add(round);
        competitionRepository.save(competition);
    }

    @Override
    public CompetitionResponseDTO addTeamsToCompetition(String id, CompetitionRequestDTO dto) {

        Competition competition = getById(id);
        List<Team> teams = getTeams(dto);
        ensureTeamRulesInCompetition(competition, teams);
        competition.getTeams().addAll(teams);
        return competitionMapper.toResponseDTO(competitionRepository.save(competition));

    }

    private List<Team> getTeams(CompetitionRequestDTO dto) {
        return dto.teamIds().stream()
                .map(teamId -> teamRepository.findById(teamId)
                        .orElseThrow(() -> new EntityNotFoundException("Team not found."))
                )
                .collect(Collectors.toList());
    }

    private int calculateAvailableTeamSlots(Competition competition) {
        return Math.max(0, competition.getNumberOfTeams() - competition.getTeams().size());
    }

    private void ensureTeamRulesInCompetition(Competition competition , List<Team> teams ) {
        int availablePlaceTeam = calculateAvailableTeamSlots(competition);

        if (teams.size() > availablePlaceTeam) {
            throw new IllegalArgumentException(String.format("The number of place exist in this competition is %s place" , availablePlaceTeam));
        }

        teams.stream()
                .filter(team -> competition.getTeams().contains(team))
                .findFirst()
                .ifPresent(team -> {
                    throw new EntityExistsException(String.format(
                            "%s team already exists in %s competition", team.getName(), competition.getName()));
                });

    }

    private void verifyRoundDuplication(Competition competition , int roundNumber) {

        competition.getRounds().stream()
                .filter(round -> round.getRoundNumber() == roundNumber)
                .findFirst()
                .ifPresent(round -> {
                    throw new EntityExistsException(String.format("Round %s already exists in %s competition", roundNumber, competition.getName()));
                });
    }


}
