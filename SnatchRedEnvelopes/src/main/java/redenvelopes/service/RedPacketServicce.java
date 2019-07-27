package redenvelopes.service;

import redenvelopes.pojo.RedPacket;

public interface RedPacketServicce {
	
	/**
	 * 获取红包
	 * @param id编号
	 * @return 红包信息
	 */
	public RedPacket getRedPacket(Long id);
	
	/**
	 * 扣减红包
	 * @param id编号
	 * @return 影响条数
	 */
	public int decreaseRedPacket(Long id);
}
