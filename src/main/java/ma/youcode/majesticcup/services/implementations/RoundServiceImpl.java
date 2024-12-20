package ma.youcode.majesticcup.services.implementations;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import ma.youcode.majesticcup.dtos.request.RoundRequestDTO;
import ma.youcode.majesticcup.dtos.response.RoundResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import ma.youcode.majesticcup.entities.Round;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.repositories.CompetitionRepository;
import ma.youcode.majesticcup.repositories.RoundRepository;
import ma.youcode.majesticcup.repositories.TeamRepository;
import ma.youcode.majesticcup.services.CompetitionService;
import ma.youcode.majesticcup.services.RoundService;
import ma.youcode.majesticcup.utils.mappers.RoundMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoundServiceImpl extends GenericServiceImpl<Round, RoundResponseDTO, RoundRequestDTO> implements RoundService {

    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;
    private final CompetitionService competitionService;

    public RoundServiceImpl(RoundRepository roundRepository, RoundMapper roundMapper, CompetitionService competitionService) {
        super(roundRepository, roundMapper, Round.class);
        this.roundRepository = roundRepository;
        this.roundMapper = roundMapper;
        this.competitionService = competitionService;
    }

    @Override
    public RoundResponseDTO create(RoundRequestDTO dto) {

        Competition competition = getCompetition(dto.competitionId());
        Round round = roundMapper.fromRequestDTO(dto);
        round.setCompetition(competition);
        round.setMatches(new ArrayList<>());
        Round savedRound = roundRepository.save(round);
        competitionService.addRoundToCompetition(competition, savedRound);
        return roundMapper.toResponseDTO(savedRound);

    }

    @Override
    public RoundResponseDTO update(String id, RoundRequestDTO dto) {

        Round round = roundRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Round not found."));

        if (!dto.competitionId().isBlank() && !dto.competitionId().equals(round.getCompetition().getId())) {
            Competition competition = getCompetition(dto.competitionId());
            round.setCompetition(competition);
        }

        if (dto.roundNumber() != null) {
            round.setRoundNumber(dto.roundNumber());
        }

        return roundMapper.toResponseDTO(roundRepository.save(round));
    }


    private Competition getCompetition(String id) {
        return competitionService.getById(id);
    };



}
