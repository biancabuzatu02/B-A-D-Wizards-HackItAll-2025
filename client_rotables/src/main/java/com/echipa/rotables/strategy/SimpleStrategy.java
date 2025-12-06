package com.echipa.rotables.strategy;

import com.echipa.rotables.dto.HourResponseDto;
import com.echipa.rotables.dto.PlayRoundRequestDto;

public class SimpleStrategy implements Strategy {

    @Override
    public PlayRoundRequestDto makeDecision(HourResponseDto state) {
        // momentan decizie goală (sigură, fără penalizări)
        return new PlayRoundRequestDto();
    }
}
