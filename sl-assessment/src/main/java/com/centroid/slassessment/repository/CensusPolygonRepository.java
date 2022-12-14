package com.centroid.slassessment.repository;

import com.centroid.slassessment.entity.CensusPolygon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository that executes calculation queries on database.
 */
@Repository
public interface CensusPolygonRepository extends JpaRepository<CensusPolygon, Long> {
    String pointInPoly = "FROM public.dfw_demo "
            + "WHERE ST_WITHIN(ST_CENTROID(\"SpatialObj\"), "
            + "CAST(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY))";
    String withClause = "WITH weights AS(SELECT \"Key\", "
            + "ST_AREA(ST_INTERSECTION(\"SpatialObj\", cast(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) "
            + "as GEOMETRY)))/ST_AREA(\"SpatialObj\") as proportion "
            + "from public.dfw_demo "
            + "WHERE ST_INTERSECTS(\"SpatialObj\", cast(ST_BUFFER(ST_GeographyFromText(CONCAT('POINT(', :longitude, ' ', :latitude, ')')), :distance) as GEOMETRY)))";
    String proportionateArea = "FROM public.dfw_demo INNER JOIN weights on weights.\"Key\" = dfw_demo.\"Key\" ";

    @Query(value = "SELECT COALESCE(AVG(\"income\"), 0) "
                 + pointInPoly
                 , nativeQuery = true)
    List<Float> pipAvgInc(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT COALESCE(SUM(\"income\"), 0)"
                 + pointInPoly
                 , nativeQuery = true)
    List<Float> pipSumInc(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT COALESCE(AVG(\"population\"), 0)"
                 + pointInPoly
                 , nativeQuery = true)
    List<Float> pipAvgPop(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = "SELECT COALESCE(SUM(\"population\"), 0)"
                 + pointInPoly
                 , nativeQuery = true)
    List<Float> pipSumPop(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = withClause
                 + "SELECT COALESCE(SUM(\"income\" * \"proportion\")/SUM(\"proportion\"), 0) "
                 + proportionateArea
                 , nativeQuery = true)
    List<Float> propAreaAvgInc(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = withClause
                 + "SELECT COALESCE(SUM(\"income\" * \"proportion\"), 0) "
                 + proportionateArea
                 , nativeQuery = true)
    List<Float> propAreaSumInc(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = withClause
                 + "SELECT COALESCE(SUM(\"population\" * \"proportion\")/SUM(\"proportion\"), 0) "
                 + proportionateArea
                 , nativeQuery = true)
    List<Float> propAreaAvgPop(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

    @Query(value = withClause
                 + "SELECT COALESCE(SUM(\"population\" * \"proportion\"), 0) "
                 + proportionateArea
                 , nativeQuery = true)
    List<Float> propAreaSumPop(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("distance") Double distance);

}
