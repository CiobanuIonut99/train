package com.train.train.controller;

import com.train.train.entity.Train;
import com.train.train.exception.EntityNotFoundException;
import com.train.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/train")
    public ResponseEntity<Train> findTrainById(@RequestParam(value = "id") Long id) throws EntityNotFoundException {
        return new ResponseEntity<>(trainService.findTrainById(id), HttpStatus.OK);
    }

    @GetMapping("/route/available")
    public ResponseEntity<List<Train>> checkIfTrainHasDepartureAndArrivalAvailable(@RequestParam(value = "departure") String departure,
                                                                                   @RequestParam(value = "arrival") String arrival) throws EntityNotFoundException {
        return new ResponseEntity<>(trainService.checkIfTrainHasDepartureAndArrivalAvailable(departure, arrival), HttpStatus.OK);
    }

    @GetMapping("/departure-date/available")
    public ResponseEntity<List<Train>> checkIfTrainHasStartDateAvailable(@RequestParam(value = "departure") String departure,
                                                                         @RequestParam(value = "arrival") String arrival,
                                                                         @RequestParam(value = "startDate") String startDate) throws EntityNotFoundException {
        return new ResponseEntity<>(trainService.checkIfTrainHasStartDateAvailable(departure, arrival, startDate), HttpStatus.OK);
    }

}
