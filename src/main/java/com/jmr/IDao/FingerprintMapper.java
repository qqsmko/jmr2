package com.jmr.IDao;

import com.jmr.model.Fingerprint;

public interface FingerprintMapper {
    int deleteByPrimaryKey(Integer fingerprintId);

    int insert(Fingerprint record);

    int insertSelective(Fingerprint record);

    Fingerprint selectByPrimaryKey(Integer fingerprintId);

    int updateByPrimaryKeySelective(Fingerprint record);

    int updateByPrimaryKey(Fingerprint record);
}