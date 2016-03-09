package com.qzw.util;

import org.apache.shiro.crypto.hash.Sha512Hash;

/**
 * 加密类
 * 
 * @author 胜泽
 * 
 */
public class Encrypt {

	/**
	 * 私有化构造方法
	 */
	private Encrypt(){
		
	}

	/**
	 * <p> 方法名：SHA512 </p>
	 * <p> 方法描述： </p>
	 * <p> 返回值：String </p>
	 * @param str 未加密串
	 * @param salt 盐
	 * @param hashIterations 迭代次数
	 * @return
	 */
	public static String SHA512(String str, String salt, int hashIterations) {
		return new Sha512Hash(str, salt, hashIterations).toHex();
	}
	
	public static void main(String[] args) {
		//System.out.println(SHA512("admin", "admin@adminadmin", 2));
	}
	
}