package com.lostfinder.tipboard.repository;

import com.lostfinder.tipboard.entity.Tip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long> {
}
