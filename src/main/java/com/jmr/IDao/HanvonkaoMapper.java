package com.jmr.IDao;

import com.jmr.model.Hanvonkao;

public interface HanvonkaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertb(Hanvonkao record);

    int insertSelective(Hanvonkao record);

    Hanvonkao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hanvonkao record);

    int updateByPrimaryKey(Hanvonkao record);
}