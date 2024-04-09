package com.cele.pinganblue.dao;

import com.cele.pinganblue.pojo.MessagerPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/3/31 15:26
 **/
@Repository("messagerDao")
public interface IMessagerDao extends JpaRepository<MessagerPO, UUID>, JpaSpecificationExecutor<MessagerPO> {

}
