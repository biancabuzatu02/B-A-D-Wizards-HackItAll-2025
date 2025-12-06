package com.echipa.rotables.strategy;

import com.echipa.rotables.dto.HourResponseDto;
import com.echipa.rotables.dto.PlayRoundRequestDto;

public interface Strategy {

    PlayRoundRequestDto makeDecision(HourResponseDto state);

}
