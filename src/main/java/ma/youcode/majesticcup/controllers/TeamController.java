package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.senane.utilities.dtos.SuccessDTO;
import ma.senane.utilities.validation.groups.OnCreate;
import ma.youcode.majesticcup.dtos.request.TeamRequestDTO;
import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;
import ma.youcode.majesticcup.entities.Team;
import ma.youcode.majesticcup.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ma.senane.utilities.response.Response.success;

@RestController
@RequestMapping("api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> handleCreate(@RequestBody @Validated(OnCreate.class) TeamRequestDTO dto){
        TeamResponseDTO responseDTO = teamService.create(dto);
        return success(201 , "Team created successfully." , "team" , responseDTO);
    }

}
