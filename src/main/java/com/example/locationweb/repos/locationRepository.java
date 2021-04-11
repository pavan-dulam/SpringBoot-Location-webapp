/**
 * 
 */
package com.example.locationweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.example.locationweb.entities.location;

/**
 * @author pavan
 *
 */
public interface locationRepository extends JpaRepository<location, Integer> {

    @Query("select type,count(type) from location group by type")
    public List<Object[]> findTypeAndTypeCount();
}
