package com.centroid.slassessment.service.impl;

import com.centroid.slassessment.entity.CensusPolygon;
import com.centroid.slassessment.repository.CensusPolygonRepository;
import com.centroid.slassessment.service.CensusPolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements functions by calling the queries found in CensusPolygonRepository.
 */
@Service
public class CensusPolygonServiceImpl implements CensusPolygonService {

    @Autowired
    private CensusPolygonRepository censusPolygonRepository;

    /**
     * Calls query on database to find point-in-poly average income
     * of a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly average income
     */
    @Override
    public List<Float> pipAvgInc(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.pipAvgInc(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find point-in-poly summed income
     * of a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly summed income
     */
    @Override
    public List<Float> pipSumInc(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.pipSumInc(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find point-in-poly average population
     * of a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly average population
     */
    @Override
    public List<Float> pipAvgPop(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.pipAvgPop(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find point-in-poly summed population
     * of a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly summed population
     */
    @Override
    public List<Float> pipSumPop(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.pipSumPop(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find average income proportionate to area
     * in a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return average income proportionate to area
     */
    @Override
    public List<Float> propAreaAvgInc(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaAvgInc(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find summed income proportionate to area
     * in a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return summed income proportionate to area
     */
    @Override
    public List<Float> propAreaSumInc(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaSumInc(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find average population proportionate to area
     * in a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return average population proportionate to area
     */
    @Override
    public List<Float> propAreaAvgPop(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaAvgPop(latitude, longitude, distance);
    }

    /**
     * Calls query on database to find summed population proportionate to area
     * in a circular buffer around point (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return summed population proportionate to area
     */
    @Override
    public List<Float> propAreaSumPop(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaSumPop(latitude, longitude, distance);
    }
}
