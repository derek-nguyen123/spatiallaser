package com.centroid.slassessment.service;

import com.centroid.slassessment.entity.CensusPolygon;

import java.util.List;

/**
 * Defines functions required for calculations.
 */
public interface CensusPolygonService {
    List<Float> pipAvgInc(Double latitude, Double longitude, Double distance);
    List<Float> pipSumInc(Double latitude, Double longitude, Double distance);
    List<Float> pipAvgPop(Double latitude, Double longitude, Double distance);
    List<Float> pipSumPop(Double latitude, Double longitude, Double distance);
    List<Float> propAreaAvgInc(Double latitude, Double longitude, Double distance);
    List<Float> propAreaSumInc(Double latitude, Double longitude, Double distance);
    List<Float> propAreaAvgPop(Double latitude, Double longitude, Double distance);
    List<Float> propAreaSumPop(Double latitude, Double longitude, Double distance);
}
