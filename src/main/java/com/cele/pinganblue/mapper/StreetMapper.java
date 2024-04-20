package com.cele.pinganblue.mapper;

import com.cele.pinganblue.pojo.StreetPO;
import com.cele.pinganblue.vo.StreetVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: kingcobra
 * create on 2024/4/20 09:37
 **/
@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StreetMapper {
    StreetVO poConvertToVO(StreetPO streetPO);
    StreetPO voConvertToPO(StreetVO streetVO);
    List<StreetPO> vosConvertToPOs(List<StreetVO> streetVOS) ;
    List<StreetVO> posConvertToVOs(List<StreetPO> streetPOS) ;
}
