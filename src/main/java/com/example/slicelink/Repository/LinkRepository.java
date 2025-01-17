package com.example.slicelink.Repository;

import com.example.slicelink.Entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link , Integer> {

    Optional<Link> findByUrlCode(String urlCode);

}
