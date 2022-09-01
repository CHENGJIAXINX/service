/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * Copyright (c) 2011-2019, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tio.jfinal.template.stat.ast;

import org.tio.jfinal.template.Env;
import org.tio.jfinal.template.TemplateException;
import org.tio.jfinal.template.expr.ast.ExprList;
import org.tio.jfinal.template.io.Writer;
import org.tio.jfinal.template.stat.Scope;

/**
 * Call 调用模板函数，两种用法：
 * 1：常规调用
 *    #@funcName(p1, p2, ..., pn)
 * 2：安全调用，函数被定义才调用，否则跳过
 *    #@funcName?(p1, p2, ..., pn)
 * 
 * 注意：在函数名前面引入 '@' 字符是为了区分模板函数和指令
 */
public class Call extends Stat {
	
	private String funcName;
	private ExprList exprList;
	private boolean callIfDefined;
	
	public Call(String funcName, ExprList exprList, boolean callIfDefined) {
		this.funcName = funcName;
		this.exprList = exprList;
		this.callIfDefined = callIfDefined;
	}
	
	public void exec(Env env, Scope scope, Writer writer) {
		Define function = env.getFunction(funcName);
		if (function != null) {
			function.call(env, scope, exprList, writer);	
		} else if (callIfDefined) {
			return ;
		} else {
			throw new TemplateException("Template function not defined: " + funcName, location);
		}
	}
}

