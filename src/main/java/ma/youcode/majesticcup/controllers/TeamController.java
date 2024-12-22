package ma.youcode.majesticcup.controllers;

import ma.youcode.majesticcup.dtos.request.TeamRequestDTO;
import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.services.TeamService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/admin/team")
public class TeamController extends GenericController<Team, TeamResponseDTO, TeamRequestDTO> {

    private final TeamService teamService;
    public TeamController(TeamService teamService) {
        super(teamService, Team.class);
        this.teamService = teamService;
    }



}
