package com.cele.pinganblue.service;

import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import com.cele.pinganblue.vo.StreetVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:14
 **/

public interface IStreetService {

    /**
     * 添加街道
     * @param streetVO
     * @return
     * @throws Exception
     */
    public void add(StreetVO streetVO) throws Exception ;

    /**
     * 更新街道
     * @param streetVO
     * @return
     * @throws Exception
     */
    public void updateStreet(StreetVO streetVO) throws Exception ;

    /**
     * 通过实体删除街道
     * @param streetVO
     * @return
     * @throws Exception
     */

    public void deleteStreet(StreetVO streetVO) throws Exception ;
    /**
     * 通过街道主键删除街道
     * @param primaryKey
     * @return
     * @throws Exception
     */
    public void deleteStreet(String primaryKey) throws Exception ;

    /**
     * 根据主键查找街道
     * @param primaryKey
     * @return
     * @throws Exception
     */

    public StreetVO findByStreetID(String primaryKey) throws Exception ;

    public Page<StreetVO> findByPage(int pageNum, int pageSize) throws Exception ;

    public List<StreetVO> findAll() throws Exception ;

}
