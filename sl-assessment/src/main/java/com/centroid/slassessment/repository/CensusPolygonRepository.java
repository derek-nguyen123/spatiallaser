package com.centroid.slassessment.repository;

import com.centroid.slassessment.entity.CensusPolygon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CensusPolygonRepository extends JpaRepository<CensusPolygon, Long> {
    @Query(value = "SELECT AVG(\"income\") "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_WITHIN(ST_CENTROID(\"SpatialObj\"), "
                 + "CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY));"
                 , nativeQuery = true)
    List<Float> pipAvgInc(@Param("longitude") Double latitude, @Param("latitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT SUM(\"income\") "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_WITHIN(ST_CENTROID(\"SpatialObj\"), "
                 + "CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY));"
                 , nativeQuery = true)
    List<Float> pipSumInc(@Param("longitude") Double latitude, @Param("latitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT AVG(\"population\") "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_WITHIN(ST_CENTROID(\"SpatialObj\"), "
                 + "CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY));"
                 , nativeQuery = true)
    List<Float> pipAvgPop(@Param("longitude") Double latitude, @Param("latitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT SUM(\"population\") "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_WITHIN(ST_CENTROID(\"SpatialObj\"), "
                 + "CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY));"
                 , nativeQuery = true)
    List<Float> pipSumPop(@Param("longitude") Double latitude, @Param("latitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT AVG(\"income\" * "
                 + "(ST_AREA(ST_INTERSECTION(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY)))/"
                 + "ST_AREA(\"SpatialObj\"))) "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_INTERSECTS(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY))"
                 , nativeQuery = true)
    List<Float> propAreaAvgInc(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT SUM(\"income\" * "
                 + "(ST_AREA(ST_INTERSECTION(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY)))/"
                 + "ST_AREA(\"SpatialObj\"))) "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_INTERSECTS(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY))"
                 , nativeQuery = true)
    List<Float> propAreaSumInc(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT AVG(\"population\" * "
                 + "(ST_AREA(ST_INTERSECTION(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY)))/"
                 + "ST_AREA(\"SpatialObj\"))) "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_INTERSECTS(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY))"
                 , nativeQuery = true)
    List<Float> propAreaAvgPop(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT SUM(\"population\" * "
                 + "(ST_AREA(ST_INTERSECTION(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY)))/"
                 + "ST_AREA(\"SpatialObj\"))) "
                 + "FROM public.dfw_demo "
                 + "WHERE ST_INTERSECTS(\"SpatialObj\", CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY))"
                 , nativeQuery = true)
    List<Float> propAreaSumPop(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

}
