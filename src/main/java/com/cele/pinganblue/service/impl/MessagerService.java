package com.cele.pinganblue.service.impl;

import com.cele.pinganblue.common.Constants;
import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.dao.IMessagerDao;
import com.cele.pinganblue.mapper.MessagerMapper;
import com.cele.pinganblue.pojo.MessagerPO;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.*;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:48
 **/
@Service("messagerService")
@Slf4j
public class MessagerService implements IMessagerService {
    @Autowired
    private MessagerMapper messagerMapper;

    @Autowired
    private IMessagerDao messagerDao;
    @Override
    public void signUp(RegisterVO registerVO) throws Exception {
        try {
            MessagerPO messagerPO = messagerMapper.registerVOToPO(registerVO);
            messagerPO.setPrimaryKey(UUID.randomUUID());
            messagerPO.setCreateTime(new Date());
            messagerPO.setUserStatus(EnumConstants.UserStatus.init);
            messagerDao.save(messagerPO);
        } catch (Exception e) {
            log.error("messager sign up error! {}", registerVO, e);
            e.printStackTrace();
            throw new RuntimeException(Constants.SIGNUP_FAILURE_MESSAGE);
        }
    }

    @Override
    public void updateMessager(MessagerVO messagerVO) throws Exception {
        try {
           MessagerPO messagePO =  messagerMapper.voConvertToPO(messagerVO);
           messagerDao.save(messagePO);
        } catch (Exception e) {
            log.error("update messager error! {}", messagerVO, e);
            throw new RuntimeException(Constants.UPDATE_FAILURE_MESSAGE);
        }
    }

    @Override
    public boolean changeUserStatus(MessagerVO messageVO,String statusName) throws Exception {
        boolean status = false;
        try {
            MessagerPO messagerPO = messagerMapper.voConvertToPO(messageVO);
            EnumConstants.UserStatus userStatus = EnumConstants.UserStatus.valueOf(statusName);
            messagerPO.setUserStatus(userStatus);
            messagerDao.save(messagerPO);
            status = true;
        } catch (Exception e) {
            log.error("change messager satatus error! messagerInfo:{},statusCode:{}", messageVO, statusName, e);
            throw new RuntimeException(Constants.CHANGE_USERSTATUS_FAILURE_MESSAGE);
        }
        return status;
    }

    @Override
    public void deleteMessager(MessagerVO messageVO) throws Exception {
        try {
            MessagerPO messagerPO = messagerMapper.voConvertToPO(messageVO);
            messagerDao.delete(messagerPO);
        } catch (Exception e) {
            log.error("delete messager error! messager:{}", messageVO, e);
            throw new RuntimeException(Constants.DELETE_FAILURE_MESSAGE);
        }
    }

    @Override
    public void deleteMessagerByPK(String primaryKey) throws Exception {
        try {
            messagerDao.deleteById(UUID.fromString(primaryKey));
        } catch (Exception e) {
            log.error("delete messager by PK error! PK:{}", primaryKey, e);
            throw new RuntimeException(Constants.DELETE_FAILURE_MESSAGE);
        }
    }
    @Override
    public void deleteMessagerByStatus(String status) throws Exception {
        try {
            EnumConstants.UserStatus userStatus = EnumConstants.UserStatus.valueOf(status);
            messagerDao.deleteAllByUserStatus(userStatus);
        } catch (Exception e) {
            log.error("delete messager by userStatus error! userStatus:{}", status, e);
            throw new RuntimeException(Constants.DELETE_FAILURE_MESSAGE);
        }
    }

    @Override
    public MessagerVO findByWechatId(String weChatID) throws Exception {
        MessagerVO messagerVO = null;
        try {
            Optional<MessagerPO> messagerPOOptional = messagerDao.findByWechatID(weChatID);
            if (messagerPOOptional.isPresent()) {
                messagerVO = messagerMapper.poConvertToVO(messagerPOOptional.get());
            }
        } catch (Exception e) {
            log.error("find messager by weChatID error! wechatID:{}", weChatID, e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return messagerVO;
    }

    @Override
    public Page<MessagerVO> findByPage(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC, "street");
        Page<MessagerVO> messagerVOS = null;
        try {
            Page<MessagerPO> messagerPOS = messagerDao.findAll(pageRequest);
            messagerVOS = messagerPOS.map(messagerMapper::poConvertToVO);
        } catch (Exception e) {
            log.error("find messager error!", e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return messagerVOS;
    }

    @Override
    public Page<MessagerVO> findByStreet(String streetCode, int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "createTime");
        Page<MessagerVO> messagerVOS = null;
        Specification<MessagerPO> specification = (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.equal(root.get("steet").as(String.class), streetCode);
            return query.where(predicate).getRestriction();
        };
        try {
            Page<MessagerPO> messagerPOS = messagerDao.findAll(specification,pageRequest);
            messagerVOS = messagerPOS.map(messagerMapper::poConvertToVO);
        } catch (Exception e) {
            log.error("find messager error!", e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return messagerVOS;
    }

    @Override
    public Page<MessagerVO> findByCondition(Map<String, Object> condition, int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "createTime");
        Page<MessagerVO> messagerVOS = null;
        List<Predicate> predicateList = new ArrayList<>();
        Specification<MessagerPO> specification = (root, query, criteriaBuilder) -> {
            condition.forEach((k,v)->{
                Predicate predicate = criteriaBuilder.equal(root.get(k).as(String.class), v);
                predicateList.add(predicate);
            });
            Predicate predicate = criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            return query.where(predicate).getRestriction();
        };
        try {
            Page<MessagerPO> messagerPOS = messagerDao.findAll(specification,pageRequest);
            messagerVOS = messagerPOS.map(messagerMapper::poConvertToVO);
        } catch (Exception e) {
            log.error("find messager error!", e);
            throw new RuntimeException(Constants.QUERY_FAILURE_MESSAGE);
        }
        return messagerVOS;
    }
}
