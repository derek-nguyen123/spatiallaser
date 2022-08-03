package com.centroid.slassessment.service.impl;

import com.centroid.slassessment.entity.CensusPolygon;
import com.centroid.slassessment.repository.CensusPolygonRepository;
import com.centroid.slassessment.service.CensusPolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CensusPolygonServiceImpl implements CensusPolygonService {

    @Autowired
    private CensusPolygonRepository censusPolygonRepository;

    public List<CensusPolygon> findAll() {
        return censusPolygonRepository.findAll();
    }

    @Override
    public List<Float> pipAvgInc(Double longitude, Double latitude, Double distance) {
        return censusPolygonRepository.pipAvgInc(latitude, longitude, distance);
    }

    @Override
    public List<Float> pipSumInc(Double longitude, Double latitude, Double distance) {
        return censusPolygonRepository.pipSumInc(latitude, longitude, distance);
    }

    @Override
    public List<Float> pipAvgPop(Double longitude, Double latitude, Double distance) {
        return censusPolygonRepository.pipAvgPop(latitude, longitude, distance);
    }

    @Override
    public List<Float> pipSumPop(Double longitude, Double latitude, Double distance) {
        return censusPolygonRepository.pipSumPop(latitude, longitude, distance);
    }

    @Override
    public List<Float> propAreaAvgInc(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaAvgInc(latitude, longitude, distance);
    }

    @Override
    public List<Float> propAreaSumInc(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaSumInc(latitude, longitude, distance);
    }

    @Override
    public List<Float> propAreaAvgPop(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaAvgPop(latitude, longitude, distance);
    }

    @Override
    public List<Float> propAreaSumPop(Double latitude, Double longitude, Double distance) {
        return censusPolygonRepository.propAreaSumPop(latitude, longitude, distance);
    }
}
