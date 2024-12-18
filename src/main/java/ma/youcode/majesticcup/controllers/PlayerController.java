package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.services.PlayerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;




}
