/**
 * 
 */
package com.crossover.techtrial.repositories;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.crossover.techtrial.model.Ride;

/**
 * @author crossover
 *
 */
@RestResource(exported = false)
@NamedQueries({
	@NamedQuery ( name="RideRepository.findTopDrivers",
    query="select p.name, p.email, AVG(r.distance) as average_distance, MAX(r.end_time-r.start_time) as maxduration, sum(r.end_time-r.start_time) as total_duration from person p inner join ride r\r\n" + 
		" on p.id=r.driver_id " + 
		" group by " + 
		" p.name,p.email " + 
		" order by average_distance desc limit 5; ") }  )
public interface RideRepository extends CrudRepository<Ride, Long> {
	
	
	
	

}


	//	public interface TopDriverRepository extends JpaRepository<TopDriverDTO,String> {
	
     //   List<TopDriverDTO>	findTopDrivers();




