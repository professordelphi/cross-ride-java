/**
 * 
 */
package com.crossover.techtrial.repositories;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crossover.techtrial.dto.TopDriverDTO;

/**
 * @author hp
 *
 */
@NamedQueries({
	@NamedQuery ( name="TopDriverRepository.findTopDrivers",
    query="select p.name, p.email, AVG(r.distance) as average_distance, MAX(r.end_time-r.start_time) as maxduration, sum(r.end_time-r.start_time) as total_duration from person p inner join ride r\r\n" + 
		" on p.id=r.driver_id " + 
		" group by " + 
		" p.name,p.email " + 
		" order by average_distance desc limit 5; ") }  )  
		public interface TopDriverRepository extends JpaRepository<TopDriverDTO,String> {
	
	

}
