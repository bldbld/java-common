package org.ballad.javacommon.netprotocols.bellovinmerrit;

import java.util.Vector;

public class BellovinMerritA {
	private String pw;
	private String id;
	private String ska;
	private String pka;
	private String ks;
	private String na;
	private String nb;

	public BellovinMerritA(String id, String pw) {// 开始
		this.id = id;
		this.pw = pw;
		// 随机生成公私 PKA SKA
		Integer ipka = (int) (Math.random() * 1000);
		pka = ipka.toString();
		Integer iska = (int) (Math.random() * 1000);
		ska = ipka.toString();
	}

	public Vector sendPka() {
		Vector<String> send = new Vector();
		DesEncrypt des = new DesEncrypt();
		des.getKey(pw);
		String strEnc = des.getEncString(pka);// 加密PKA
		send.add(strEnc);
		send.add(id);
		return send;
	}

	public String receiveKs(String reci) {
		DesEncrypt des = new DesEncrypt();// 解密得到E(PKA,KS)
		des.getKey(pw);
		String str = des.getDesString(reci);
		// 解密得到KS
		des.getKey(pka);
		ks = des.getDesString(str);
		return this.sendNa();
	}

	public String sendNa() {
		Integer ina = (int) (Math.random() * 1000);
		na = ina.toString();
		Vector<String> send = new Vector();
		DesEncrypt des = new DesEncrypt();
		des.getKey(ks);
		String strEnc = des.getEncString(na);// 加密Na
		return strEnc;
	}

	public boolean receiveNb(String reci) {
		DesEncrypt des = new DesEncrypt();// 解密得到NA||NB ???什么是NA||NB
		des.getKey(ks);
		String str = des.getDesString(reci);
		if (str.contains(na)) {
			nb = str.subSequence(na.length(), str.length()).toString();
			return true; // QUESTION!!!!!!!!!!!!
		} else {
			return false;
		}
	}

	public String sendNb() {
		DesEncrypt des = new DesEncrypt();
		des.getKey(ks);
		String strEnc = des.getEncString(nb);// 加密nb
		return strEnc;
	}
}