package com.wtoip.analysis.model;

import java.io.Serializable;

/**
* 
* @author 木四点
* @version 创建时间：2016-12-26
*
*/
public class Goods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品id
	 */
	private String goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品键接
	 */
	private String goodsUrl;
	/**
	 * 商品图片
	 */
	private String goodsImg;
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsUrl() {
		return goodsUrl;
	}
	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsUrl=" + goodsUrl + ", goodsImg="
				+ goodsImg + "]";
	}
}