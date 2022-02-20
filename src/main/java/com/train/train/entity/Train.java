package com.train.train.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "train", schema = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "train_type")
    private String trainType;

    @Column(name = "price")
    private Integer price;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "departure")
    private String departure;

    @Column(name = "arrival")
    private String arrival;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "has_delay")
    private Boolean hasDelay;

    @Column(name = "late")
    private LocalTime late;

    @Column(name = "total_seat_number")
    private Integer totalSeatNumber;

    @Column(name = "available_seat_number")
    private Integer availableSeatNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "train")
    private List<Seat> seats;

}
