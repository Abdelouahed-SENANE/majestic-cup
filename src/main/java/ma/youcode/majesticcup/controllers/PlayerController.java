package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.senane.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import ma.youcode.majesticcup.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static ma.senane.utilities.response.Response.success;

@RestController
@RequestMapping("api/player")
public class PlayerController extends GenericController<Player, PlayerResponseDTO , PlayerRequestDTO> {

    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        super(playerService , Player.class);
        this.playerService = playerService;
    }

    @PostMapping("/new/all")
    public ResponseEntity<SuccessDTO> handleCreateAll(@RequestBody List<PlayerRequestDTO> dtoList){
        List<PlayerResponseDTO> resDTO = playerService.createAll(dtoList);
        return success(201 , "All players created successfully." , "newPlayers" , resDTO);
    }

}
