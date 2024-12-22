package ma.youcode.majesticcup.controllers;


import ma.youcode.majesticcup.dtos.request.RoundRequestDTO;
import ma.youcode.majesticcup.dtos.response.RoundResponseDTO;
import ma.youcode.majesticcup.entities.Round;
import ma.youcode.majesticcup.services.RoundService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/admin/round")
public class RoundController extends GenericController<Round, RoundResponseDTO, RoundRequestDTO> {
    private final RoundService roundService;
    public RoundController(RoundService roundService) {
        super(roundService , Round.class);
        this.roundService = roundService;
    }



}
