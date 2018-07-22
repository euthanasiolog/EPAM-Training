package com.epam.training.task1.controller;

/**
 * Starter is the class-tester of business-logic.
 *
 * -version 3.0
 * 22 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task1.exception.NegativeNumberException;
import com.epam.training.task1.exception.WrongRangeOfRandomException;
import com.epam.training.task1.exception.WrongTypeOfComfortException;
import com.epam.training.task1.model.entity.PassengerTrain;
import com.epam.training.task1.logic.TrainCharacteristic;
import com.epam.training.task1.logic.Searcher;
import com.epam.training.task1.logic.Sorter;
import com.epam.training.task1.util.initialization.IntegerInitializer;
import com.epam.training.task1.util.initialization.PassengerTrainInitializer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Starter {

    private static final Logger LOG_INFO = Logger.getLogger(Starter.class);
    private static final Logger LOG_ERROR = Logger.getLogger("logfile");

    public static void main(String[] args) {
        try {
            LOG_INFO.setLevel(Level.DEBUG);
            LOG_INFO.log(Level.INFO, "Application started...");
            LOG_INFO.log(Level.INFO, "Making passenger train...");

            //making passenger train
            PassengerTrain passengerTrain = new PassengerTrain();

            LOG_INFO.log(Level.INFO, "Passenger train was done...");
            LOG_INFO.log(Level.INFO, "Initialization of passenger train...");

            //initialization passenger train with specific number of carriages
            int numberOfCarriages = 10;
            PassengerTrainInitializer.initPassengerTrain(passengerTrain, numberOfCarriages, LOG_INFO);

            LOG_INFO.log(Level.INFO, "Initialization was successfully made...");
            LOG_INFO.log(Level.INFO, "Printing information about passenger train:");

            //printing information about passenger train
            LOG_INFO.log(Level.INFO, passengerTrain);
            LOG_INFO.log(Level.INFO, "Testing business-logic...");

            if (!passengerTrain.isEmpty()) {
                //total number of passengers in train;
                LOG_INFO.log(Level.INFO, "Total number of passengers = "
                        + TrainCharacteristic.countTotalNumberOfPassengers(passengerTrain));

                //total luggage weight
                LOG_INFO.log(Level.INFO, "Total luggage weight = "
                        + TrainCharacteristic.countTotalLuggageWeight(passengerTrain));

                //sorting
                LOG_INFO.log(Level.INFO, "Passenger train after sorting carriages by type of comfort:");
                Sorter.sortPassengerCarriagesByTypeOfComfort(passengerTrain);
                LOG_INFO.log(Level.INFO, passengerTrain);

                //find carriages with specific range
                int leftBorder = IntegerInitializer.initNumber(0, 100);
                int rightBorder = IntegerInitializer.initNumber(leftBorder, 100);
                LOG_INFO.log(Level.INFO, "Carriages with number of passengers in range: [" + leftBorder + ", "
                        + rightBorder + "]:");
                Searcher.findCarriagesWithSpecificNumberOfPassengers(passengerTrain, leftBorder, rightBorder, LOG_INFO);
            }
        } catch (WrongTypeOfComfortException e) {
            LOG_ERROR.log(Level.ERROR, e.getMessage() + e.getTypeOfComfort());
        } catch (NegativeNumberException e) {
            LOG_ERROR.log(Level.ERROR, e.getMessage() + e.getNumber());
        } catch (WrongRangeOfRandomException e) {
            LOG_ERROR.log(Level.ERROR, e.getMessage());
        } finally {
            LOG_INFO.log(Level.INFO, "The application was stopped! Thank you for working with us:)");
        }
    }
}

