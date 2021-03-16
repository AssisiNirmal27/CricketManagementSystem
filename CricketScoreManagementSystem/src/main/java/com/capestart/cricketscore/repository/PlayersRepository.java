/**
 * 
 */
package com.capestart.cricketscore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capestart.cricketscore.model.Player;
import com.capestart.cricketscore.model.Team;

/**
 * @author Nirmal
 *
 */
@Repository
public interface PlayersRepository extends JpaRepository<Player, Long> {

	@Query(value = "select p from Player p where p.id= :id")
	public Player findByIdValue(@Param("id") Long id);

		
    @Query(value = "select * from Player p where p.name like '%'||:name||'%' ", nativeQuery = true)
	public Player findByName(@Param("name") String name);

   // @Query("FROM Player ORDER BY average DESC")
    @Query(value = "SELECT * FROM Player p ORDER BY p.runs, p.average DESC",nativeQuery = true)
     List<Player> findAllOrderByAverage();
    
	
    // @Query(value = "SELECT AVG(p.run) FROM Player p WHERE p.id = ?1" , nativeQuery = true)
     
	
	  @Query(value = " select * from Player p where p.team_id='p.teamName' ",nativeQuery = true)
	  public List<Player> getAllTeamPlayers();
	 
}
