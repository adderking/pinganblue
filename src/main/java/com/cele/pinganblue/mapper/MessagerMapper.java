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
    @Mapping(source = "userStatus",target="userStatus",qualifiedByName = "enumToOrdinal")
    @Mapping(source = "createTime",target="createTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source="street",target=".")
    public abstract MessagerVO poConvertToVO(MessagerPO messagePO);

    @Mapping(source = "userStatus",target="userStatus",qualifiedByName = "ordinalToEnum")
    @Mapping(source = "createTime",target="createTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
//    @Mapping(source="street",target=".")
    public abstract  MessagerPO voConvertToPO(MessagerVO messageVO);
    public abstract MessagerPO registerVOToPO(RegisterVO registerVO);

    @Named("ordinalToEnum")
    public UserStatus ordinalConvertToEnum(int statusCode) {
        UserStatus userStatus = UserStatus.getStatus(statusCode);
        return userStatus;
    }
    @Named("enumToOrdinal")
    public int enumConvertToOrdinal(UserStatus userStatus) {
        int code = userStatus.getCode();
        return code;
    }
    public abstract List<MessagerPO> vosConvertToPOs(List<MessagerVO> messagerVOS) ;
    public abstract List<MessagerVO> posConvertToVOs(List<MessagerPO> messagerPOS) ;
}
