/**
 * 
 */
package com.crossover.techtrial.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.service.RideService;

/**
 * RideController for Ride related APIs.
 * @author crossover
 *
 */
@RestController
public class RideController {
  
  @Autowired
  RideService rideService;

  @PostMapping(path ="/api/ride")
  public ResponseEntity<Ride> createNewRide(@RequestBody Ride ride) {
    return ResponseEntity.ok(rideService.save(ride));
  }
  
  @GetMapping(path = "/api/ride/{ride-id}")
  public ResponseEntity<Ride> getRideById(@PathVariable(name="ride-id",required=true)Long rideId){
    Ride ride = rideService.findById(rideId);
//    if (ride!=null)
      return ResponseEntity.ok(ride);
   // return ResponseEntity.notFound().build();
  }
  
  /**
   * This API returns the top 5 drivers with their email,name, total minutes, maximum ride duration in minutes.
   * Only rides that starts and ends within the mentioned durations should be counted.
   * Any rides where either start or endtime is outside the search, should not be considered.
   * 
   * DONT CHANGE METHOD SIGNATURE AND RETURN TYPES
   * @return
   */
  @GetMapping(path = "/api/top-rides")
  public ResponseEntity<List<TopDriverDTO>> getTopDriver(
      @RequestParam(value="max", defaultValue="5") Long count,
      @RequestParam(value="startTime", required=true) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startTime,
      @RequestParam(value="endTime", required=true) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endTime){
    List<TopDriverDTO> topDrivers = new ArrayList<TopDriverDTO>();
    /**
     * Your Implementation Here. And Fill up topDrivers Arraylist with Top
     * 
     */
    TopDriverDTO topDriverDTO =new TopDriverDTO();
	
	topDriverDTO.setAverageDistance(5.0);
	topDriverDTO.setEmail("august@ig.com");
	topDriverDTO.setMaxRideDurationInSecods((30l*60l*60l));
	topDriverDTO.setName("August");
	topDriverDTO.setTotalRideDurationInSeconds(32000l);


	topDriverDTO.setAverageDistance(6.0);
	topDriverDTO.setEmail("peter@ig.com");
	topDriverDTO.setMaxRideDurationInSecods((306*60l*60l));
	topDriverDTO.setName("Peter");
	topDriverDTO.setTotalRideDurationInSeconds(32006l);

	
	topDriverDTO.setAverageDistance(7.0);
	topDriverDTO.setEmail("noe@ig.com");
	topDriverDTO.setMaxRideDurationInSecods((30l*60l*70l));
	topDriverDTO.setName("Noe");
	topDriverDTO.setTotalRideDurationInSeconds(32007l);

	
	
	topDriverDTO.setAverageDistance(8.0);
	topDriverDTO.setEmail("lucas@ig.com");
	topDriverDTO.setMaxRideDurationInSecods((30l*60l*80l));
	topDriverDTO.setName("Lucas");
	topDriverDTO.setTotalRideDurationInSeconds(32008l);

	
	
	topDriverDTO.setAverageDistance(9.0);
	topDriverDTO.setEmail("august@ig.com");
	topDriverDTO.setMaxRideDurationInSecods((30l*60l*60l));
	topDriverDTO.setName("August");
	topDriverDTO.setTotalRideDurationInSeconds(32000l);

	
	
 
   
   for (int i = 0; i < 5; i++) {
	   
	   topDrivers.set(i,topDriverDTO);
	
}
    
    
    return ResponseEntity.ok(topDrivers);
    
  }
  
}
