package ma.youcode.majesticcup.services.implementations;

import ma.youcode.majesticcup.dtos.request.ResultRequestDTO;
import ma.youcode.majesticcup.dtos.request.StatisticRequestDTO;
import ma.youcode.majesticcup.entities.Match;
import ma.youcode.majesticcup.entities.Result;
import ma.youcode.majesticcup.entities.Statistic;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.repositories.ResultRepository;
import ma.youcode.majesticcup.repositories.StatisticRepository;
import ma.youcode.majesticcup.services.PlayerService;
import ma.youcode.majesticcup.services.ResultService;
import ma.youcode.majesticcup.utils.mappers.ResultMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;
    private final StatisticRepository statisticRepository;

    public ResultServiceImpl(ResultRepository teamRepository, ResultMapper resultMapper, StatisticRepository statisticRepository) {
        this.resultRepository = teamRepository;
        this.resultMapper = resultMapper;
        this.statisticRepository = statisticRepository;
    }

    @Override
    public Result createResult(ResultRequestDTO resultRequestDTO, Match match) {
        Result result = resultMapper.fromRequestDTO(resultRequestDTO);
        result.setMatch(match);
        result.setWinnerTeam(getWinner(result));
        addStatistics(resultRequestDTO.statistics(), result);
        return resultRepository.save(result);
    }

    private Team getWinner(Result result) {
        if (result.getHomeTeamGoals() > result.getAwayTeamGoals()) {
            return result.getMatch().getHomeTeam();
        }
        return result.getMatch().getAwayTeam();

    }

    private void addStatistics(List<StatisticRequestDTO> dtoList, Result result) {



        dtoList.stream()
                .map(dto -> Statistic.builder()

                        .build());
    }

    private boolean isPlayerPlayedOnTheMatch(List<StatisticRequestDTO> dtoList, Result result) {

        return dtoList.stream()
                .anyMatch(dto -> result.getWinnerTeam().getPlayers()
                        .stream()
                        .noneMatch(player -> player.getId().equals(dto.playerId())));
    }
}

