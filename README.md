## About The Project

Run calculations on dfw_demo database. Uses SpatialObj census blocks to calculate sums or averages
of either population or income around a (latitude, longitude) pair and given a desired radius in meters.

API Documentation Here: sl-assessment/doc/com/centroid/slassessment/controller/CensusPolygonController.html

API Implementation available at:
sl-assessment/src/main/java/com/centroid/slassessment/controller/CensusPolygonController.java

## Getting Started

To run the project locally, ensure that Maven and Java are up-to-date.

Clone this repo:
```sh  
git clone https://github.com/derek-nguyen123/spatiallaser.git  
```  
Enter sl-assessment and run:
```sh  
mvn clean install
mvn spring-boot:run  
```  
## Usage

With the project running in one terminal, open another terminal to run curl commands.

**Example curl commands**:

Sum of populations point-in-poly 2km radius around (33.045352,  -96.781508):
```sh
curl "localhost:8080/api/pip/sum/pop?latitude=33.045352&longitude=-96.781508&distance=2000"
```
Average incomes point-in-poly 2km radius around (33.045352,  -96.781508):
```sh
curl "localhost:8080/api/pip/avg/inc?latitude=33.045352&longitude=-96.781508&distance=2000"
```
Sum of populations proportionate to area in 2km radius around (33.045352,  -96.781508):
```sh
curl "localhost:8080/api/propArea/sum/pop?latitude=33.045352&longitude=-96.781508&distance=2000"
```
Average incomes proportionate to area in buffer 2km radius around (33.045352,  -96.781508):
```sh
curl "localhost:8080/api/propArea/avg/inc?latitude=33.045352&longitude=-96.781508&distance=2000"
```


