package org.ballad.javacommon.netprotocols.bellovinmerrit;

import java.util.Vector;

public class BellovinMerritB {
	private String pw;
	private String id;
	private String ska;
	private String pka;
	private String ks;
	private String na;
	private String nb;

	public BellovinMerritB(String id, String pw) {// 开始
		this.id = id;
		this.pw = pw;
	}

	// what b do
	public String receivePka(Vector<String> reci) {
		String str = reci.firstElement();
		DesEncrypt des = new DesEncrypt();// 解密得到E(PKA,KS)
		des.getKey(pw);
		String getpka = des.getDesString(str);
		pka = getpka;
		return sendKs();
	}

	public String sendKs() {
		// 随机生成KS
		Integer iks = (int) (Math.random() * 1000);
		ks = iks.toString();
		DesEncrypt des = new DesEncrypt();
		des.getKey(pka);
		String strEnc = des.getEncString(ks);// 加密PKS
		des.getKey(pw);
		String strEnc2 = des.getEncString(strEnc);// 加密PKS
		return strEnc2;
	}

	public String receiveNa(String reci) {
		DesEncrypt des = new DesEncrypt();// 解密得到E(PKA,KS)
		des.getKey(ks);
		na = des.getDesString(reci);
		return sendNb();
	}

	public String sendNb() {
		Integer inb = (int) (Math.random() * 1000);
		nb = inb.toString();
		DesEncrypt des = new DesEncrypt();
		des.getKey(ks);
		String strEnc = des.getEncString(na + nb);//
		return strEnc;
	}

	public boolean receiveNb(String reci) {
		DesEncrypt des = new DesEncrypt();// 解密得到E(PKA,KS)
		des.getKey(ks);
		String thenb = des.getDesString(reci);
		if (thenb.equals(nb)) {
			return true;
		} else {
			return false;
		}
	}
}
