package redenvelopes.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import redenvelopes.pojo.RedPacket;

@Repository
public interface RedPacketDao {
	/**
	 * 获取红包信息
	 * @param id 红包id
	 * @return 红包具体信息
	 */
	public RedPacket getRedPacket(Long id);
	
	/**
	 * 扣减红包数
	 * @param id -- 红包id
	 * @return 更新记录条数
	 */
	public int decreaseRedPacket(Long id);
	
	/**
	 * 扣减红包一次，版本号+1
	 * @Description: 扣减抢红包数. 乐观锁的实现方式
	 * @param id 红包id
	 * @param version 版本号
	 * @return  更新记录条数
	 */
	public int decreaseRedPacketForVersion(@Param("id") Long id,@Param("version") Integer version);
}
