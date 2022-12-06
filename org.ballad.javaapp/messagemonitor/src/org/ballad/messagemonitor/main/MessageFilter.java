package org.ballad.messagemonitor.main;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class MessageFilter {
	/*
	 * �����豸����ļ����� ���˹������
	 * 
	 * Encode:GBK 2010.7
	 */

	// ���ع��˹���
	public String getFilter() {
		return filter;
	}

	// ���ù��˹���
	private void setFilter(String fitr) throws Exception {
		filter = fitr;
		if (!fitr.contains("\"")) {
			Exception e = new Exception();
			throw e;
		}
		Pattern pattern = Pattern.compile("\"");
		String[] fitrs_tmp = pattern.split(filter);
		int blank_len = 0;// �������ŵķ���ĸ���

		// ��ð������ŵķ���ĸ����� "or ("
		for (int i = 0; i < fitrs_tmp.length; i++) {
			fitrs_tmp[i] = fitrs_tmp[i].trim();
			if (fitrs_tmp[i].length() != 1
					&& (fitrs_tmp[i].contains("(") || fitrs_tmp[i]
							.contains(")"))) {
				for (int j = 0; j < fitrs_tmp[i].length(); j++) {
					if (fitrs_tmp[i].charAt(j) == '('
							|| fitrs_tmp[i].charAt(j) == ')') {
						blank_len++;
					}
				}
			}
		}
		fitrs = new String[fitrs_tmp.length + blank_len];
		// ��ʽ�����˹���
		for (int i = 0, j = 0; i < fitrs_tmp.length && j < fitrs.length; i++, j++) {
			if (fitrs_tmp[i].length() != 1
					&& (fitrs_tmp[i].contains("(") || fitrs_tmp[i]
							.contains(")"))) {
				String[] tmp = fitrs_tmp[i].split(" ");
				for (int k = 0; k < tmp.length; k++, j++) {
					if (!tmp[k].trim().equals(""))
						fitrs[j] = tmp[k].trim();
					else
						j--;
				}
				j--;
			} else {
				fitrs[j] = fitrs_tmp[i];
			}
		}
		// ĳЩ�����������ĳ��ֵĴ���
		if (fitrs[0] == null || fitrs[0].equals("")) {
			String[] tmp = fitrs;
			fitrs = new String[tmp.length - 1];
			for (int i = 1, j = 0; i < tmp.length; i++, j++) {
				fitrs[j] = tmp[i];
			}
		} else if (fitrs[fitrs.length - 1] == null
				|| fitrs[fitrs.length - 1].equals("")) {
			String[] tmp = fitrs;
			fitrs = new String[tmp.length - 1];
			for (int i = 0, j = 0; j < fitrs.length; i++, j++) {
				fitrs[j] = tmp[i];
			}
		}
	}

	// �Ƿ���Ϲ��˹���
	private boolean isConform(String msg, String fitr) {
		if (msg.contains(fitr)) {
			matchedNum.add(msg.indexOf(fitr));
			matchedNum.add(fitr.length());
			return true;
		} else {
			return false;
		}
	}

	// ���ع��˹����Ƿ�Ϸ� �������޸Ľ���
	public String isFitrCorrect(String fitr) {
		String suggest = null;
		try {
			this.setFilter(fitr);
		} catch (Exception e) {
			suggest = "���ı��ʽ������ʽ�������޸�";
			return suggest;
		}

		// ���and��or��ƴд����
		// boolean flag= true;
		String tmp = new String();
		String operTmp = new String();
		for (int j = 0; j < fitr.length(); j++) {
			tmp = fitr.substring(j, j + 1);
			if (tmp.equals("\"")) {
				// flag = false;
				j++;
				while (j < fitr.length()
						&& !(tmp = fitr.substring(j, j + 1)).equals("\"")) {
					j++;
					// flag = true;
				}
				j++;
				while (j < fitr.length()
						&& (tmp = fitr.substring(j, j + 1)).equals(" ")) {
					j++;
				}
				if (j < fitr.length()) {
					operTmp = tmp;
					j++;
					while (j < fitr.length()
							&& !(tmp = fitr.substring(j, j + 1)).equals(" ")) {
						operTmp += tmp;
						j++;
					}
					if (!(operTmp.equals("and") || operTmp.equals("or")
							|| operTmp.equals("(") || operTmp.equals(")"))) {
						if (operTmp.length() == 1) {
							if ((operTmp.equals("o"))) {
								suggest = "o ������ȷ�Ĺؼ��֣��Ƿ�Ҫ������r��";
								return suggest;
							} else if (operTmp.equals("a")) {
								suggest = "a ������ȷ�Ĺؼ��֣��Ƿ�Ҫ������nd��";
								return suggest;
							} else {
								suggest = operTmp + " ������ȷ�Ĺؼ��֣����޸�";
								return suggest;
							}
						} else if (operTmp.length() == 2) {
							if ((!operTmp.equals("and"))
									&& (operTmp.charAt(0) == 'a')
									&& (operTmp.charAt(1) == 'n')) {
								suggest = "an ������ȷ�Ĺؼ��֣��Ƿ�Ҫ������d��";
								return suggest;
							} else if ((!operTmp.equals("or"))
									&& (operTmp.charAt(0) == 'o')
									&& (operTmp.charAt(1) != 'r')) {
								suggest = operTmp + " ������ȷ�Ĺؼ��֣��Ƿ��Ϊor��";
								return suggest;
							} else {
								suggest = operTmp + " ������ȷ�Ĺؼ��֣����޸�";
								return suggest;
							}
						} else if (operTmp.length() > 2) {
							suggest = operTmp + " ������ȷ�Ĺؼ��֣����޸�";
							return suggest;
						} else if (operTmp.length() > 2) {
							suggest = operTmp + " ������ȷ�Ĺؼ��֣����޸�";
							return suggest;
						}
					}
				}
			}
		}

		int bracketLock = 0;// ���ڼ�¼�������ŵ�ƽ��

		for (int i = 0; i < fitrs.length; i++) {
			if (fitrs[i] == null) {

			} else if (fitrs[i].equals("(")) {
				bracketLock++;
				if (i + 1 == fitrs.length) {
					suggest = "����������ֱ�ӷ����˶�β������û���壬�Ƿ���ɾ����";
					return suggest;
				} else if (fitrs[i + 1].equals(")")) {
					suggest = "���ı��ʽ�д��ڿ����ţ����޸�";
					return suggest;
				} else if (fitrs[i + 1].equals("and")) {
					suggest = "���������ź���ֱ��������and���Ƿ�andɾ����";
					return suggest;
				} else if (fitrs[i + 1].equals("or")) {
					suggest = "���������ź���ֱ��������or���Ƿ�orɾ����";
					return suggest;
				}
			} else if (fitrs[i].equals("and")) {
				if (i == 0 && !filter.startsWith("\"")) {
					suggest = "���ı��ʽ��and��ʼ���Ƿ�andɾ����";
					return suggest;
				} else if (i + 1 == fitrs.length && !filter.endsWith("\"")) {
					suggest = "���ı��ʽ��and��β���Ƿ�andɾ����";
					return suggest;
				}
			} else if (fitrs[i].equals("or")) {
				if (i == 0 && !filter.startsWith("\"")) {
					suggest = "���ı��ʽ��or��ʼ���Ƿ�orɾ����";
					return suggest;
				} else if (i + 1 == fitrs.length && !filter.endsWith("\"")) {
					suggest = "���ı��ʽ��or��β���Ƿ�orɾ����";
					return suggest;
				}
			} else if (fitrs[i].equals(")")) {
				if ((i + 1 < fitrs.length) && fitrs[i + 1].equals("(")) {
					suggest = "���������ź���ֱ�������������ţ����޸�";
					return suggest;
				}
				if (bracketLock <= 0) {
					suggest = "���������ź������ŵ�ƥ�������⣬���޸�";
					return suggest;
				}
				bracketLock--;
			} else if (fitrs[i].contains("((") || fitrs[i].contains("()")
					|| fitrs[i].contains("))") || fitrs[i].contains(")(")) {

				suggest = "���������������ż�����һ���ո������ֲ�ͬ������";
				return suggest;
			}
		}
		if (bracketLock > 0) {
			suggest = "���Ĺ��˹�����ȱ��" + bracketLock + "��),�Ƿ�Ҫ������)";
			return suggest;

		} else if (bracketLock < 0) {
			suggest = "���Ĺ��˹�����ȱ��" + (1 - bracketLock) + "��(,�Ƿ�Ҫ������(";
			return suggest;
		}
		return suggest;
	}

	// ����ƥ����ַ�����λ��
	public ArrayList<Integer> getMatchedNum() {
		reMatchedNum.clear();
		for (int i = 0; i < matchedNum.size();) {
			if (!matchedNum.get(i).equals(matchedNum.get(i + 1))) {
				reMatchedNum.add(matchedNum.get(i));
				reMatchedNum.add(matchedNum.get(i + 1));
			}
			i += 2;
		}
		return reMatchedNum;
	}

	// ����ƥ�������ĳһ�������ֶεĲ���ֵ
	private boolean getValue(String[] subFitrs, String msg) {
		int i = 0;
		boolean curr = true;
		Stack<String> subSign = new Stack<String>();
		Stack<Boolean> subExp = new Stack<Boolean>();
		while (i < subFitrs.length) {
			if (subFitrs[i] == null || subFitrs[i].equals("")) {
				// error
			} else if (subFitrs[i].equals("(")) {
				for (int j = subFitrs.length - 1; j > i; j--) {
					if (subFitrs[j].equals(")")) {
						String[] tmp = new String[j - i - 1];
						i++;
						j--;
						for (int k = 0; i <= j; i++, k++) {
							tmp[k] = subFitrs[i];
						}
						if ((!subSign.isEmpty())
								&& subSign.peek().equals("and")) {
							curr = getValue(tmp, msg);
							subExp.push(subExp.pop() && curr);
							subSign.pop();
						} else {
							subExp.push(getValue(tmp, msg));
						}
						break;
					} else {
						// error
					}
				}
			} else if (subFitrs[i].equals("and")) {
				subSign.push(subFitrs[i]);
			} else if (subFitrs[i].equals("or")) {
				subSign.push(subFitrs[i]);
			} else {// A EXP
				if ((!subSign.isEmpty()) && subSign.peek().equals("and")) {
					subExp.push((subExp.pop() && isConform(msg, subFitrs[i])));
					subSign.pop();
				} else {
					subExp.push(isConform(msg, subFitrs[i]));
				}
			}
			i++;
		}
		while (!subSign.isEmpty()) {
			if (subSign.peek().equals("or")) {
				subSign.pop();
				curr = subExp.pop();
				curr = curr || subExp.pop();
				subExp.push(curr);
			}
		}
		curr = subExp.pop();
		return curr;
	}

	// ��ñ��Ĳ������Ƿ�ƥ����˹���
	public boolean isMatch(String msg) {
		if (filter != null) {
			matchedNum.clear();
			return getValue(fitrs, msg);
		} else {
			// û�й��� ֱ�ӷ���ƥ��
			return true;
		}
	}

	private ArrayList<Integer> matchedNum = new ArrayList<Integer>();// ƥ����ֶ����
	private ArrayList<Integer> reMatchedNum = new ArrayList<Integer>();// ���ڷ��صĸ�ʽ����ƥ����ֶ����
	private String[] fitrs;// ���˹���
	private String filter = "";// ����Ĺ��˹����ַ���

}