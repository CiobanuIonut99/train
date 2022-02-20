package com.train.train.service;

import com.train.train.entity.Train;
import com.train.train.exception.EntityNotFoundException;
import com.train.train.repository.TrainRepository;
import liquibase.pro.packaged.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainService {

    TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train findTrainById(Long id) throws EntityNotFoundException {
        Optional<Train> optionalTrain = trainRepository.findById(id);
        if (optionalTrain.isPresent()) {
            return optionalTrain.get();
        } else {
            throw new EntityNotFoundException("Entity not found!");
        }
    }

    public List<Train> checkIfTrainHasDepartureAndArrivalAvailable(String departure, String arrival) throws EntityNotFoundException {

        List<Train> trainList = trainRepository.findAll();
        List<Train> trainListFilteredByDepartureAndArrival = trainList
                .stream()
                .filter(each -> each.getDeparture().equalsIgnoreCase(departure) &&
                        each.getArrival().equalsIgnoreCase(arrival))
                .collect(Collectors.toList());

        if (!trainListFilteredByDepartureAndArrival.isEmpty()) {
            return trainListFilteredByDepartureAndArrival;
        } else {
            throw new EntityNotFoundException("No train available with that route!");
        }
    }

    public List<Train> checkIfTrainHasStartDateAvailable(String departure, String arrival, String startDate) throws EntityNotFoundException {
        LocalDate localDate = LocalDate.parse(startDate);
        List<Train> trainListFilteredByStartDate = checkIfTrainHasDepartureAndArrivalAvailable(departure, arrival)
                .stream()
                .filter(each -> each.getStartDate().equals(localDate))
                .collect(Collectors.toList());
        if (!trainListFilteredByStartDate.isEmpty()) {
            return trainListFilteredByStartDate;
        } else {
            throw new EntityNotFoundException("No train available for this date.\nPlease choose another date");
        }
    }
}
