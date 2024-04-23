package com.cele.pinganblue.mapper;

import com.cele.pinganblue.common.EnumConstants.*;
import com.cele.pinganblue.pojo.MessagerPO;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:29
 **/
@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class MessagerMapper {
    public static final MessagerMapper INSTANCE = Mappers.getMapper(MessagerMapper.class);
    @Mapping(source = "userStatus",target="userStatus",qualifiedByName = "enumToString")
    @Mapping(source = "createTime",target="createTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "approveTime",target="approveTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    public abstract MessagerVO poConvertToVO(MessagerPO messagePO);

    @Mapping(source = "userStatus",target="userStatus",qualifiedByName = "ordinalToEnum")
    @Mapping(source = "createTime",target="createTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "approveTime",target="approveTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    public abstract  MessagerPO voConvertToPO(MessagerVO messageVO);

    public abstract MessagerPO registerVOToPO(RegisterVO registerVO);

    @Named("enumToString")
    public String ordinalConvertToEnum(UserStatus userStatus) {
        return userStatus.name();
    }
    @Named("ordinalToEnum")
    public UserStatus enumConvertToOrdinal(Integer userStatusCode) {
        UserStatus userStatus = UserStatus.getStatus(userStatusCode);
        return userStatus;
    }
    public abstract List<MessagerPO> vosConvertToPOs(List<MessagerVO> messagerVOS) ;
    public abstract List<MessagerVO> posConvertToVOs(List<MessagerPO> messagerPOS) ;
}
