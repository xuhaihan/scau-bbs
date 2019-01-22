package com.scau.bbs.common.dao;

import com.scau.bbs.common.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelDao extends JpaRepository<Label,Integer> {
}
