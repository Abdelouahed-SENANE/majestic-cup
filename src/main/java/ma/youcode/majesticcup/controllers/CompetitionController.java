package ma.youcode.majesticcup.controllers;

import jakarta.validation.Valid;
import org.starter.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.dtos.request.CompetitionRequestDTO;
import ma.youcode.majesticcup.dtos.response.CompetitionResponseDTO;
import ma.youcode.majesticcup.entities.Competition;
import ma.youcode.majesticcup.services.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.starter.utilities.response.Response.success;

@RestController
@RequestMapping("api/admin/competition")
public class CompetitionController extends GenericController<Competition, CompetitionResponseDTO, CompetitionRequestDTO> {
    private final CompetitionService competitionService;
    public CompetitionController(CompetitionService competitionService) {
        super(competitionService , Competition.class);
        this.competitionService = competitionService;
    }

    @PostMapping("{id}/teams")
    public ResponseEntity<SuccessDTO> handleAddTeamsToCompetition(@PathVariable String id, @Valid @RequestBody CompetitionRequestDTO dto) {
        CompetitionResponseDTO resDTO = competitionService.addTeamsToCompetition(id, dto);
        return success(200 , "Teams added successfully" , "competition", resDTO);
    }

}
