package ma.youcode.majesticcup.services.implementations;

import ma.youcode.majesticcup.dtos.request.ResultRequestDTO;
import ma.youcode.majesticcup.dtos.request.StatisticRequestDTO;
import ma.youcode.majesticcup.entities.*;
import ma.youcode.majesticcup.repositories.ResultRepository;
import ma.youcode.majesticcup.repositories.StatisticRepository;
import ma.youcode.majesticcup.services.PlayerService;
import ma.youcode.majesticcup.services.ResultService;
import ma.youcode.majesticcup.utils.mappers.ResultMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional

public class ResultServiceImpl implements ResultService {
    private static final Logger log = LogManager.getLogger(ResultServiceImpl.class);
    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;
    private final StatisticRepository statisticRepository;

    public ResultServiceImpl(ResultRepository teamRepository, ResultMapper resultMapper, StatisticRepository statisticRepository) {
        this.resultRepository = teamRepository;
        this.resultMapper = resultMapper;
        this.statisticRepository = statisticRepository;
    }

    @Override
    @Transactional
    public Result createResult(ResultRequestDTO resultRequestDTO, Match match) {
        Result result = Result.builder()
                .match(match)
                .homeTeamGoals(resultRequestDTO.homeTeamGoals())
                .awayTeamGoals(resultRequestDTO.awayTeamGoals())
                .build();
        result.setWinnerTeam(getWinner(result));
        Result saved = resultRepository.save(result);
        saved.setStatistics(addStatistics(resultRequestDTO.statistics(), saved));
        return saved;
    }

    private Team getWinner(Result result) {
        if (result.getHomeTeamGoals() > result.getAwayTeamGoals()) {
            return result.getMatch().getHomeTeam();
        }
        return result.getMatch().getAwayTeam();

    }

    private List<Statistic> addStatistics(List<StatisticRequestDTO> dtoList, Result result) {

        if (!playerExistsOnMatch(dtoList, result)) {
            throw new IllegalArgumentException("The Player doesn't exist in the match");
        }


        Set<Statistic> statistics = dtoList.stream()
                .map(dto ->
                        Statistic.builder()
                            .player(getCurrentPlayer(dto.playerId() , result))
                            .goals(dto.goals())
                            .assists(dto.assists())
                            .resultId(result.getId())
                            .yellowCards(dto.yellowCards())
                            .build()
                )
                .collect(Collectors.toSet());


        return statisticRepository.saveAll(statistics);


    }

    private Player getCurrentPlayer(String playerId , Result result) {
         return result.getMatch().getHomeTeam().getPlayers().stream()
                .filter(p -> p.getId().equals(playerId))
                .findFirst()
                .orElseGet(() -> result.getMatch().getAwayTeam().getPlayers().stream()
                        .filter(p -> p.getId().equals(playerId))
                        .findFirst()
                        .orElse(null));


    }

    private boolean playerExistsOnMatch(List<StatisticRequestDTO> dtoList, Result result) {

        Set<String> playerIdSet = new HashSet<>();
        for (StatisticRequestDTO statistic : dtoList) {
            playerIdSet.add(statistic.playerId());
        }

        return result.getMatch().getHomeTeam().getPlayers().stream()
                .anyMatch(player -> playerIdSet.contains(player.getId())) ||
                result.getMatch().getAwayTeam().getPlayers().stream()
                        .anyMatch(player -> playerIdSet.contains(player.getId()));

    }
}

