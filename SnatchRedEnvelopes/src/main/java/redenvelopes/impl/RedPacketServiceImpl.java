package redenvelopes.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import redenvelopes.dao.RedPacketDao;
import redenvelopes.pojo.RedPacket;
import redenvelopes.service.RedPacketServicce;

@Service
public class RedPacketServiceImpl implements RedPacketServicce{
	
	@Autowired
	private RedPacketDao redPacketDao=null;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public RedPacket getRedPacket(Long id) {
		return redPacketDao.getRedPacket(id);
	}
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public int decreaseRedPacket(Long id) {
		return redPacketDao.decreaseRedPacket(id);
	}
}
