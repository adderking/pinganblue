package com.cele.pinganblue.service.impl;

import com.cele.pinganblue.common.Constants;
import com.cele.pinganblue.dao.IStreetDao;
import com.cele.pinganblue.mapper.StreetMapper;
import com.cele.pinganblue.pojo.StreetPO;
import com.cele.pinganblue.service.IStreetService;
import com.cele.pinganblue.vo.StreetVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/4/20 11:12
 **/
@Service("streetService")
@Slf4j
public class StreetService implements IStreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Autowired
    private IStreetDao streetDao;
    @Override
    public void add(StreetVO streetVO) throws Exception {
        StreetPO streetPO = streetMapper.voConvertToPO(streetVO);
        try {
            streetPO.setPrimaryKey(UUID.randomUUID());
            streetDao.save(streetPO);
        } catch (Exception e) {
            log.error("insert street error! {}", streetPO, e);
            throw new RuntimeException(Constants.INSERT_FAILURE_MESSAGE);
        }
    }

    @Override
    public void updateStreet(StreetVO streetVO) throws Exception {
        StreetPO streetPO = streetMapper.voConvertToPO(streetVO);
        try {
            streetDao.save(streetPO);
        } catch (Exception e) {
            log.error("update street error! {}", streetPO, e);
            throw new RuntimeException(Constants.UPDATE_FAILURE_MESSAGE);
        }
    }

    @Override
    public void deleteStreet(StreetVO streetVO) throws Exception {
        StreetPO streetPO = streetMapper.voConvertToPO(streetVO);
        try {
            streetDao.delete(streetPO);
        } catch (Exception e) {
            log.error("delete street error! {}", streetPO, e);
            throw new RuntimeException(Constants.DELETE_FAILURE_MESSAGE);
        }
    }

    @Override
    public void deleteStreet(String primaryKey) throws Exception {
        try {
            streetDao.deleteById(UUID.fromString(primaryKey));
        } catch (Exception e) {
            log.error("delete street by PK error! {}", primaryKey, e);
            throw new RuntimeException(Constants.DELETE_FAILURE_MESSAGE);
        }
    }

    @Override
    public StreetVO findByStreetID(String primaryKey) throws Exception {
        StreetVO streetVO =null;
        try {
           Optional<StreetPO> streetPOOptional= streetDao.findById(UUID.fromString(primaryKey));
           if(streetPOOptional.isPresent())
               streetVO = streetMapper.poConvertToVO(streetPOOptional.get());
        } catch (Exception e) {
            log.error("find street by PK error! {}", primaryKey, e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return streetVO;
    }

    @Override
    public Page<StreetVO> findByPage(int pageNum, int pageSize) throws Exception{
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, Sort.Direction.ASC,"streetCode");
        Page<StreetVO> streetVOS = null;
        try {
            Page<StreetPO> streetPOS =streetDao.findAll(pageRequest);
            streetVOS = streetPOS.map(streetMapper::poConvertToVO);
        } catch (Exception e) {
            log.error("find street error!", e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return streetVOS;
    }

    @Override
    public List<StreetVO> findAll() throws Exception {
        List<StreetVO> streetVOS = new ArrayList<>();
        try {
            List<StreetPO> streetPOS =streetDao.findAll();
            streetVOS = streetMapper.posConvertToVOs(streetPOS);
        } catch (Exception e) {
            log.error("find street error!", e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return streetVOS;
    }
}
