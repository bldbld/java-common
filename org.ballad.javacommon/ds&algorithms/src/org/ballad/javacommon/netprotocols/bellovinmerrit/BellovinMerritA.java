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

	public BellovinMerritA(String id, String pw) {// ��ʼ
		this.id = id;
		this.pw = pw;
		// ������ɹ�˽ PKA SKA
		Integer ipka = (int) (Math.random() * 1000);
		pka = ipka.toString();
		Integer iska = (int) (Math.random() * 1000);
		ska = ipka.toString();
	}

	public Vector sendPka() {
		Vector<String> send = new Vector();
		DesEncrypt des = new DesEncrypt();
		des.getKey(pw);
		String strEnc = des.getEncString(pka);// ����PKA
		send.add(strEnc);
		send.add(id);
		return send;
	}

	public String receiveKs(String reci) {
		DesEncrypt des = new DesEncrypt();// ���ܵõ�E(PKA,KS)
		des.getKey(pw);
		String str = des.getDesString(reci);
		// ���ܵõ�KS
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
		String strEnc = des.getEncString(na);// ����Na
		return strEnc;
	}

	public boolean receiveNb(String reci) {
		DesEncrypt des = new DesEncrypt();// ���ܵõ�NA||NB ???ʲô��NA||NB
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
		String strEnc = des.getEncString(nb);// ����nb
		return strEnc;
	}
}