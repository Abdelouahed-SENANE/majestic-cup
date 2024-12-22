package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.request.ResultRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.Match;
import ma.youcode.majesticcup.entities.Result;


public interface ResultService {

    Result createResult(ResultRequestDTO resultRequestDTO , Match match);
}
