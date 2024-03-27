package com.application.itime.service;

import com.application.itime.persistance.dto.PunchTransactionDto;

import java.util.List;

public interface PunchTransactionService {
    List<PunchTransactionDto> punchDetails();

}
