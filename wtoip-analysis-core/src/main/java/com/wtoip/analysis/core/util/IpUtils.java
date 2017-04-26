package com.wtoip.analysis.core.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;


public class IpUtils {

	private static final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
	private static final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;

	/**
	 * 判断IP是否在指定范围
	 * 
	 * @param ipSection
	 * @param ip
	 * @return
	 */
	public static boolean ipIsValid(String ipSection, String ip) {
		if (ipSection == null)
			throw new NullPointerException("IP段不能为空！");
		if (ip == null)
			throw new NullPointerException("IP不能为空！");
		ipSection = ipSection.trim();
		ip = ip.trim();

		// 单IP匹配
		if (ipSection.matches(REGX_IP)) {
			return ipSection.equals(ip);
		}

		// IP段匹配 102.168.1.1-192.168.1.100
		if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
			return false;

		int idx = ipSection.indexOf('-');
		String[] sips = ipSection.substring(0, idx).split("\\.");
		String[] sipe = ipSection.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
		for (int i = 0; i < 4; ++i) {
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		return ips <= ipt && ipt <= ipe;
	}

	/**
	 * 判断IP是否在指定范围
	 * 
	 * @param ipSection
	 * @param ip
	 * @return
	 */
	public static boolean ipIsValid(String[] ipSection, String ip) {
		for (String ipResoure : ipSection) {
			if (ipIsValid(ipResoure, ip)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (!checkIP(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (!checkIP(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (!checkIP(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	private static boolean checkIP(String ip) {
		if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)) {
			return false;
		}
		return true;
	}

	/**
	 * 获取本地IP
	 * @return String 返回IP地址
	 * @throws Exception    异常
	 */
	public static String getLocalIP(){

		String sIP = "";
		InetAddress ip = null;
		try {
			// 如果是Windows操作系统
			if (isWindowsOS()) {
				ip = InetAddress.getLocalHost();
			}
			// 如果是Linux操作系统
			else {
				boolean bFindIP = false;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
				.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					if (bFindIP) {
						break;
					}
					NetworkInterface ni = (NetworkInterface) netInterfaces
							.nextElement();
					// ----------特定情况，可以考虑用ni.getName判断
					// 遍历所有ip
					Enumeration<InetAddress> ips = ni.getInetAddresses();
					while (ips.hasMoreElements()) {
						ip = (InetAddress) ips.nextElement();
						if (ip.isSiteLocalAddress()
						&& !ip.isLoopbackAddress() // 127.开头的都是lookback地址
								&& ip.getHostAddress().indexOf(":") == -1) {
							bFindIP = true;
							break;
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}if (null != ip) {
			sIP = ip.getHostAddress();
		}
		return sIP;
	}

	/**
	 * 判断是否windows
	 * @return
	 */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

}
