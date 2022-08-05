package com.centroid.slassessment.controller;

import com.centroid.slassessment.entity.CensusPolygon;
import com.centroid.slassessment.service.CensusPolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class that specifies public APIs. Use /api/ and build function using
 * pip or propArea for point in poly or proportionate area calculations respectively,
 * Sum or Avg to calculate either the sum or average or the field,
 * Inc or Pop to indicate which field to calculate on.
 */
@RestController
@RequestMapping("/api/")
public class CensusPolygonController {

    @Autowired
    private CensusPolygonService censusPolygonService;

    @GetMapping
    public List<CensusPolygon> findAll() {
        return censusPolygonService.findAll();
    }

    /**
     * Finds the point-in-poly average income of a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly average income
     */
    @GetMapping(path="/pipAvgInc")
    public List<Float> pipAvgInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipAvgInc(latitude, longitude, distance);
    }

    /**
     * Finds the point-in-poly sum of incomes of a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly summed income
     */
    @GetMapping(path="/pipSumInc")
    public List<Float> pipSumInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipSumInc(latitude, longitude, distance);
    }

    /**
     * Finds the point-in-poly average population of a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly average population
     */
    @GetMapping(path="/pipAvgPop")
    public List<Float> pipAvgPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipAvgPop(latitude, longitude, distance);
    }

    /**
     * Finds the point-in-poly sum of populations of a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return point-in-poly summed population
     */
    @GetMapping(path="/pipSumPop")
    public List<Float> pipSumPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipSumPop(latitude, longitude, distance);
    }

    /**
     * Finds the average income proportionate to area in a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return average income proportionate to area in buffer
     */
    @GetMapping(path="/propAreaAvgInc")
    public List<Float> propAreaAvgInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaAvgInc(latitude, longitude, distance);
    }

    /**
     * Finds the summed income proportionate to area in a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return summed income proportionate to area in buffer
     */
    @GetMapping(path="/propAreaSumInc")
    public List<Float> propAreaSumInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaSumInc(latitude, longitude, distance);
    }

    /**
     * Finds the average population proportionate to area in a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return average population proportionate to area in buffer
     */
    @GetMapping(path="/propAreaAvgPop")
    public List<Float> propAreaAvgPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaAvgPop(latitude, longitude, distance);
    }

    /**
     * Finds the summed population proportionate to area in a circular buffer around point
     * (latitude, longitude) with radius distance.
     * @param latitude is latitude find buffer around
     * @param longitude is longitude to find buffer around
     * @param distance distance around point to generate buffer
     * @return summed population proportionate to area in buffer
     */
    @GetMapping(path="/propAreaSumPop")
    public List<Float> propAreaSumPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaSumPop(latitude, longitude, distance);
    }

}
