//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;


package com.sportsbook.backend;

public class BetRequest {
    private Long bettorId;
    private String betType;
    private float stake;

    public BetRequest() {} // Required for JSON serialization

    public Long getBettorId() {
        return bettorId;
    }

    public void setBettorId(Long bettorId) {
        this.bettorId = bettorId;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public float getStake() {
        return stake;
    }

    public void setStake(float stake) {
        this.stake = stake;
    }
}
