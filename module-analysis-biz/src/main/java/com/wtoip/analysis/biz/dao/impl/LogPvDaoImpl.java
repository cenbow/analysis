package com.wtoip.analysis.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.wtoip.analysis.biz.dao.LogPvDao;
import com.wtoip.analysis.core.framwork.dao.impl.BaseDao;
import com.wtoip.analysis.model.LogPv;

@Repository("logPvDao")
public class LogPvDaoImpl extends BaseDao<LogPv> implements LogPvDao{

}
