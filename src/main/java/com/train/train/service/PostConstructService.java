package com.train.train.service;

import com.train.train.entity.Seat;
import com.train.train.entity.Train;
import com.train.train.repository.SeatRepository;
import com.train.train.repository.TrainRepository;
import liquibase.pro.packaged.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostConstructService {

    SeatRepository seatRepository;
    TrainRepository trainRepository;

    @Autowired
    public PostConstructService(TrainRepository trainRepository, SeatRepository seatRepository) {

        this.trainRepository = trainRepository;
        this.seatRepository = seatRepository;
    }

    @PostConstruct
    public void addASeatInDataBase() {

        List<Seat> seats = seatRepository.findAll();
        List<Train> trains = trainRepository.findAll();

        if (seats.isEmpty()) {
            for (Train train : trains) {

                for (int j = 1; j <= train.getTotalSeatNumber(); j++) {

                    seats.add(Seat.builder()
                            .train(train)
                            .seatNumber(j)
                            .isReserved(false)
                            .build());
                }
            }
            seatRepository.saveAll(seats);
        }
    }
}
