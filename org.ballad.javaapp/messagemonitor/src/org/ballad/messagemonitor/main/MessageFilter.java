package org.ballad.messagemonitor.main;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class MessageFilter {
	/*
	 * 电信设备命令报文监视器 过滤规则控制
	 * 
	 * Encode:GBK 2010.7
	 */

	// 返回过滤规则
	public String getFilter() {
		return filter;
	}

	// 设置过滤规则
	private void setFilter(String fitr) throws Exception {
		filter = fitr;
		if (!fitr.contains("\"")) {
			Exception e = new Exception();
			throw e;
		}
		Pattern pattern = Pattern.compile("\"");
		String[] fitrs_tmp = pattern.split(filter);
		int blank_len = 0;// 包含括号的分组的个数

		// 获得包含括号的分组的个数如 "or ("
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
		// 格式化过滤规则
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
		// 某些极特殊的情况的出现的处理
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

	// 是否符合过滤规则
	private boolean isConform(String msg, String fitr) {
		if (msg.contains(fitr)) {
			matchedNum.add(msg.indexOf(fitr));
			matchedNum.add(fitr.length());
			return true;
		} else {
			return false;
		}
	}

	// 返回过滤规则是否合法 并返回修改建议
	public String isFitrCorrect(String fitr) {
		String suggest = null;
		try {
			this.setFilter(fitr);
		} catch (Exception e) {
			suggest = "您的表达式基本格式错误，请修改";
			return suggest;
		}

		// 检查and和or的拼写问题
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
								suggest = "o 不是正确的关键字，是否要补充上r？";
								return suggest;
							} else if (operTmp.equals("a")) {
								suggest = "a 不是正确的关键字，是否要补充上nd？";
								return suggest;
							} else {
								suggest = operTmp + " 不是正确的关键字，请修改";
								return suggest;
							}
						} else if (operTmp.length() == 2) {
							if ((!operTmp.equals("and"))
									&& (operTmp.charAt(0) == 'a')
									&& (operTmp.charAt(1) == 'n')) {
								suggest = "an 不是正确的关键字，是否要补充上d？";
								return suggest;
							} else if ((!operTmp.equals("or"))
									&& (operTmp.charAt(0) == 'o')
									&& (operTmp.charAt(1) != 'r')) {
								suggest = operTmp + " 不是正确的关键字，是否改为or？";
								return suggest;
							} else {
								suggest = operTmp + " 不是正确的关键字，请修改";
								return suggest;
							}
						} else if (operTmp.length() > 2) {
							suggest = operTmp + " 不是正确的关键字，请修改";
							return suggest;
						} else if (operTmp.length() > 2) {
							suggest = operTmp + " 不是正确的关键字，请修改";
							return suggest;
						}
					}
				}
			}
		}

		int bracketLock = 0;// 用于记录左右括号的平衡

		for (int i = 0; i < fitrs.length; i++) {
			if (fitrs[i] == null) {

			} else if (fitrs[i].equals("(")) {
				bracketLock++;
				if (i + 1 == fitrs.length) {
					suggest = "您的左括号直接放在了队尾，这样没意义，是否将其删除？";
					return suggest;
				} else if (fitrs[i + 1].equals(")")) {
					suggest = "您的表达式中存在空括号，请修改";
					return suggest;
				} else if (fitrs[i + 1].equals("and")) {
					suggest = "您的左括号后面直接连接了and，是否将and删除？";
					return suggest;
				} else if (fitrs[i + 1].equals("or")) {
					suggest = "您的左括号后面直接连接了or，是否将or删除？";
					return suggest;
				}
			} else if (fitrs[i].equals("and")) {
				if (i == 0 && !filter.startsWith("\"")) {
					suggest = "您的表达式以and开始，是否将and删除？";
					return suggest;
				} else if (i + 1 == fitrs.length && !filter.endsWith("\"")) {
					suggest = "您的表达式以and结尾，是否将and删除？";
					return suggest;
				}
			} else if (fitrs[i].equals("or")) {
				if (i == 0 && !filter.startsWith("\"")) {
					suggest = "您的表达式以or开始，是否将or删除？";
					return suggest;
				} else if (i + 1 == fitrs.length && !filter.endsWith("\"")) {
					suggest = "您的表达式以or结尾，是否将or删除？";
					return suggest;
				}
			} else if (fitrs[i].equals(")")) {
				if ((i + 1 < fitrs.length) && fitrs[i + 1].equals("(")) {
					suggest = "您的右括号后面直接连接了左括号，请修改";
					return suggest;
				}
				if (bracketLock <= 0) {
					suggest = "您的右括号和左括号的匹配有问题，请修改";
					return suggest;
				}
				bracketLock--;
			} else if (fitrs[i].contains("((") || fitrs[i].contains("()")
					|| fitrs[i].contains("))") || fitrs[i].contains(")(")) {

				suggest = "请您在连续的括号间输入一个空格以区分不同的括号";
				return suggest;
			}
		}
		if (bracketLock > 0) {
			suggest = "您的过滤规则中缺少" + bracketLock + "个),是否要补充上)";
			return suggest;

		} else if (bracketLock < 0) {
			suggest = "您的过滤规则中缺少" + (1 - bracketLock) + "个(,是否要补充上(";
			return suggest;
		}
		return suggest;
	}

	// 返回匹配的字符串的位置
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

	// 返回匹配过程中某一（）内字段的布尔值
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

	// 获得报文并返回是否匹配过滤规则
	public boolean isMatch(String msg) {
		if (filter != null) {
			matchedNum.clear();
			return getValue(fitrs, msg);
		} else {
			// 没有规则 直接返回匹配
			return true;
		}
	}

	private ArrayList<Integer> matchedNum = new ArrayList<Integer>();// 匹配的字段序号
	private ArrayList<Integer> reMatchedNum = new ArrayList<Integer>();// 用于返回的格式化的匹配的字段序号
	private String[] fitrs;// 过滤规则
	private String filter = "";// 输入的过滤规则字符串

}