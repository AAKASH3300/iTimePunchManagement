package com.application.itime.service.implementation;

import com.application.itime.persistance.conversion.PunchTransactionMapper;
import com.application.itime.persistance.dto.PunchTransactionDto;
import com.application.itime.persistance.entity.PunchTransaction;
import com.application.itime.repository.PunchTransactionRepository;
import com.application.itime.service.PunchTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PunchTransactionImpl implements PunchTransactionService {

    @Autowired
    PunchTransactionMapper punchTransactionMapper;

    @Autowired
    PunchTransactionRepository punchTransactionRepository;

    @Override
    public List<PunchTransactionDto> punchDetails() {

        List<PunchTransaction> punchTransaction = punchTransactionRepository.findAll();

        List<PunchTransactionDto> punchModel = new ArrayList<>();


        for (PunchTransaction punchTransactions : punchTransaction)
            punchModel.add(punchTransactionMapper.entityToModel(punchTransactions));


            return punchModel;

        }
    }

