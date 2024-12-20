package ma.youcode.majesticcup.controllers;


import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.Match;
import ma.youcode.majesticcup.services.MatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/match")
public class MatchController extends GenericController<Match, MatchResponseDTO, MatchRequestDTO> {
    private final MatchService matchService;
    public MatchController(MatchService matchService) {
        super(matchService , Match.class);
        this.matchService = matchService;
    }



}
