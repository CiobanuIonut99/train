package com.train.train.repository;

import com.train.train.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

}
