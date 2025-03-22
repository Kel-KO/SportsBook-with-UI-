package com.sportsbook.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class BetController {

    @Autowired
    private SportsBettorRepository repository;

    @PostMapping("/place-bet")
    public BetResult placeBet(@RequestBody BetRequest request) {
        SportsBettor bettor = repository.findById(request.getBettorId()).orElseThrow();

        float stake = request.getStake();
        if (stake > bettor.getBalance()) {
            return new BetResult("L", 0, bettor.getBalance());
        }

        bettor.setBalance(bettor.getBalance() - stake);

        List<String> result = Betting.simulateBet(request.getBetType(), stake);

        char wl = result.get(0).charAt(0);
        float winnings = Float.parseFloat(result.get(1));

        if (wl == 'W') {
            bettor.setBalance(bettor.getBalance() + winnings);
        }

        repository.save(bettor);
        return new BetResult(String.valueOf(wl), winnings, bettor.getBalance());
    }
}
