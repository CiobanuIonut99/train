ALTER SEQUENCE train.seat_id_seq RESTART WITH 1;

DROP TABLE IF EXISTS train.seat cascade;

CREATE TABLE IF NOT EXISTS train.seat (

    ID SERIAL unique,
    TRAIN_ID int,
    SEAT_NUMBER int,
    IS_RESERVED boolean,

    CONSTRAINT fk_train FOREIGN KEY(train_id) REFERENCES train.train(id)
);



