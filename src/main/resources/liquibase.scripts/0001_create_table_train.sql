DROP TABLE IF EXISTS train.train cascade;
CREATE TABLE IF NOT EXISTS train.train (

    ID SERIAL unique,
    TRAIN_NAME character  varying (255),
    TRAIN_TYPE character varying (255),
    PRICE int,
    DISTANCE double precision ,
    DEPARTURE character varying (255),
    ARRIVAL character varying (255),
    START_DATE date,
    END_DATE date,
    START_TIME time,
    END_TIME time,
    HAS_DELAY boolean,
    LATE time,
    TOTAL_SEAT_NUMBER int,
    AVAILABLE_SEAT_NUMBER int

);