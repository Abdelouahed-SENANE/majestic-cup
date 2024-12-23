package ma.youcode.majesticcup.controllers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.starter.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.dtos.request.PlayerRequestDTO;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;
import ma.youcode.majesticcup.entities.Player;
import ma.youcode.majesticcup.services.PlayerService;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.starter.utilities.response.Response.success;

@RestController
@RequestMapping("api/admin/player")
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

    @GetMapping("/list")
    public ResponseEntity<SuccessDTO> handleGetAll(){
        return success(200 , "Get all players successfully" , "players" , playerService.readAll());
    }

}
