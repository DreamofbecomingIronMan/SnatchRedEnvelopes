package redenvelopes.service;

public interface RedisRedPacketService {
	/**
	 * 保存Redis抢红包列表
	 * @param redPacketId --抢红包编号
	 * @param unitAmount --红包金额
	 */
	public void saveUserRedPacketByRedis(Long redPacketId,Double unitAmount);
}
