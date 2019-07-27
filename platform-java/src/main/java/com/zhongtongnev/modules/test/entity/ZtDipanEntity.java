package com.zhongtongnev.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("zt_dipan")
public class ZtDipanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 底盘ID
	 */
	@TableId
	private String chassisId;
	/**
	 * 底盘合格证编号
	 */
	private String chassisCertificateId;
	/**
	 * 底盘发证日期
	 */
	private Date chassisCertificateTime;
	/**
	 * 底盘制造企业名称
	 */
	private String chassisBusiness;
	/**
	 * 底盘品牌
	 */
	private String chassisBrand;
	/**
	 * 底盘名称
	 */
	private String chassisName;
	/**
	 * 底盘类别
	 */
	private String chassisClassification;
	/**
	 * 底盘型号
	 */
	private String chassisType;
	/**
	 * 底盘车身颜色
	 */
	private String chassisColor;
	/**
	 * 车辆识别代号/车架号
	 */
	private String chassisVin;
	/**
	 * 燃料种类
	 */
	private String fuel;
	/**
	 * 发动机型号
	 */
	private String engineType;
	/**
	 * 排量 ml
	 */
	private Integer displacement;
	/**
	 * 功率 kw
	 */
	private Integer power;
	/**
	 * 发动机号
	 */
	private String engineId;
	/**
	 * 排放标准
	 */
	private String effluentDischargeStandard;
	/**
	 * 转向形式
	 */
	private String steeringType;
	/**
	 * 轮胎数量
	 */
	private Integer tyreNumber;
	/**
	 * 轮胎规格
	 */
	private String tyreType;
	/**
	 * 前轮距(nm)
	 */
	private Integer tyreDistanceFront;
	/**
	 * 后轮距(nm)
	 */
	private Integer tyreDistanceAfter;
	/**
	 * 轴距(nm)
	 */
	private Integer axleDistance;
	/**
	 * 轴荷(kg)
	 */
	private Integer axleLoad;
	/**
	 * 轴数
	 */
	private Integer axleNumber;
	/**
	 * 钢板弹簧片数(片）
	 */
	private String plateSpring;
	/**
	 * 外廓尺寸(长宽高)(nm)
	 */
	private String outlineDimensions;
	/**
	 * 底盘总质量(kg)
	 */
	private Integer chassisQuality;
	/**
	 * 整备质量(kg)
	 */
	private Integer unladenMass;
	/**
	 * 准牵引总质量(kg)
	 */
	private Integer totalQuasiTractionMass;
	/**
	 * 半挂车鞍座最大允许总重量(kg)
	 */
	private Integer semitrailerSaddleMass;
	/**
	 * 驾驶室准乘人数(人)
	 */
	private Integer cabPassengerNumber;
	/**
	 * 最高设计车速(km/h)
	 */
	private Integer maximumSpeed;
	/**
	 * 底盘制造日期
	 */
	private Date chassisMaketime;
	/**
	 * 备注
	 */
	private String chassisRemark;

}
