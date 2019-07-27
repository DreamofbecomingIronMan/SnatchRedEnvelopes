package com.zhongtongnev.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("zt_certificate")
public class ZtCertificateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键，提高查询速度
	 */
	@TableId
	private Long id;
	/**
	 * 合格证编号
	 */
	private String qualificationNumber;
	/**
	 * 发证日期
	 */
	private Date qualificationDate;
	/**
	 * 车辆制造企业名称
	 */
	private String businessName;
	/**
	 * 车辆品牌
	 */
	private String brandName;
	/**
	 * 车辆名称
	 */
	private String carName;
	/**
	 * 车辆型号
	 */
	private String carModel;
	/**
	 * 车辆识别代号
	 */
	private String carInentifyCode;
	/**
	 * 车身颜色
	 */
	private String carColor;
	/**
	 * 货箱内部尺寸
	 */
	private String internalDimensionsContainers;
	/**
	 * 油耗
	 */
	private String oilConsumption;
	/**
	 * 总质量
	 */
	private String totalQuality;
	/**
	 * 额定载质量
	 */
	private String ratedLoadQuality;
	/**
	 * 载质量利用系数
	 */
	private String carrierQualityUtilization;
	/**
	 * 底盘ID
	 */
	private String chassisId;
	/**
	 * 
	 */
	private String remark;

}
