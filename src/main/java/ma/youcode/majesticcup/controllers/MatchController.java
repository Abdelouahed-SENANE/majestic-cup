package ma.youcode.majesticcup.controllers;


import org.starter.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.dtos.request.MatchRequestDTO;
import ma.youcode.majesticcup.dtos.request.ResultRequestDTO;
import ma.youcode.majesticcup.dtos.response.MatchResponseDTO;
import ma.youcode.majesticcup.entities.Match;
import ma.youcode.majesticcup.services.MatchService;
import ma.youcode.majesticcup.services.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.starter.utilities.response.Response.success;


@RestController
@RequestMapping("api/admin/match")
public class MatchController extends GenericController<Match, MatchResponseDTO, MatchRequestDTO> {
    private final MatchService matchService;

    public MatchController(MatchService matchService , ResultService resultService) {
        super(matchService , Match.class);
        this.matchService = matchService;
    }

    @PostMapping("/{id}/result")
    public ResponseEntity<SuccessDTO> handleAddResult(@PathVariable String id , @RequestBody ResultRequestDTO requestDTO){
        MatchResponseDTO resDTO = matchService.addResult(requestDTO , id);
        return success(201 , "Result added successfully." , "match" , resDTO);
    }

}
