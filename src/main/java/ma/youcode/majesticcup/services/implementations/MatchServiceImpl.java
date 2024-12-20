package ma.youcode.majesticcup.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import ma.youcode.majesticcup.entities.Match;
import ma.youcode.majesticcup.repositories.MatchRepository;
import ma.youcode.majesticcup.services.CompetitionService;
import ma.youcode.majesticcup.services.MatchService;
import ma.youcode.majesticcup.utils.mappers.MatchMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class MatchServiceImpl extends GenericServiceImpl<Match, MatchResponseDTO, MatchRequestDTO> implements MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final CompetitionService competitionService;

    public MatchServiceImpl(MatchRepository matchRepository, MatchMapper matchMapper, CompetitionService competitionService) {
        super(matchRepository, matchMapper, Match.class);
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
        this.competitionService = competitionService;
    }

    @Override
    public MatchResponseDTO create(MatchRequestDTO dto) {

        Match match = matchMapper.fromRequestDTO(dto);

        return matchMapper.toResponseDTO(matchRepository.save(match));

    }

    @Override
    public MatchResponseDTO update(String id, MatchRequestDTO dto) {

        Match match = matchRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Match not found."));

        return matchMapper.toResponseDTO(matchRepository.save(match));
    }





}
