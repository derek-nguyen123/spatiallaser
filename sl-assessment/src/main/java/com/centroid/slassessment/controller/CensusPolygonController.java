package com.centroid.slassessment.controller;

import com.centroid.slassessment.entity.CensusPolygon;
import com.centroid.slassessment.service.CensusPolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CensusPolygonController {

    @Autowired
    private CensusPolygonService censusPolygonService;

    @GetMapping
    public List<CensusPolygon> findAll() {
        return censusPolygonService.findAll();
    }

    @GetMapping(path="/pipAvgInc")
    public List<Float> pipAvgInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipAvgInc(latitude, longitude, distance);
    }

    @GetMapping(path="/pipSumInc")
    public List<Float> pipSumInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipSumInc(latitude, longitude, distance);
    }

    @GetMapping(path="/pipAvgPop")
    public List<Float> pipAvgPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipAvgPop(latitude, longitude, distance);
    }

    @GetMapping(path="/pipSumPop")
    public List<Float> pipSumPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                 @RequestParam Double distance) {
        return censusPolygonService.pipSumPop(latitude, longitude, distance);
    }

    @GetMapping(path="/propAreaAvgInc")
    public List<Float> propAreaAvgInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaAvgInc(latitude, longitude, distance);
    }

    @GetMapping(path="/propAreaSumInc")
    public List<Float> propAreaSumInc(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaSumInc(latitude, longitude, distance);
    }

    @GetMapping(path="/propAreaAvgPop")
    public List<Float> propAreaAvgPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaAvgPop(latitude, longitude, distance);
    }

    @GetMapping(path="/propAreaSumPop")
    public List<Float> propAreaSumPop(@RequestParam Double latitude, @RequestParam Double longitude,
                                      @RequestParam Double distance) {
        return censusPolygonService.propAreaSumPop(latitude, longitude, distance);
    }

}
