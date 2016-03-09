package com.qzw.util;

import java.util.UUID;

/**
 * 生成36位或32位的UUID
 * 
 * @author 胜泽
 * 
 */
public abstract class UUIDGenerator {
	
	private UUIDGenerator() {}
	
	/**
	 * 生成36位UUID
	 * 
	 * @return
	 */
	public final static String getUUID36() {
		return UUID.randomUUID().toString().toUpperCase();
	}

	/**
	 * 生成32位UUID
	 * 
	 * @return
	 */
	public final static String getUUID32() {
		return getUUID36().replace("-", "").toUpperCase();
	}
}