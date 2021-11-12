package edu.cornell.cals.biomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioUser;

@Repository
public interface BioUserRepository extends JpaRepository<BioUser, Integer> {

	@Query(value="SELECT bu FROM BioUser bu where bu.userName = :userName")
    BioUser getBioUserByUserName(@Param("userName") String userName);
	
}
