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
import org.tio.jfinal.template.expr.ast.Expr;
import org.tio.jfinal.template.expr.ast.ExprList;
import org.tio.jfinal.template.expr.ast.Logic;
import org.tio.jfinal.template.io.Writer;
import org.tio.jfinal.template.stat.Location;
import org.tio.jfinal.template.stat.ParseException;
import org.tio.jfinal.template.stat.Scope;

/**
 * ElseIf
 */
public class ElseIf extends Stat {
	
	private Expr cond;
	private Stat stat;
	private Stat elseIfOrElse;
	
	public ElseIf(ExprList cond, StatList statList, Location location) {
		if (cond.length() == 0) {
			throw new ParseException("The condition expression of #else if statement can not be blank", location);
		}
		this.cond = cond.getActualExpr();
		this.stat = statList.getActualStat();
	}
	
	/**
	 * take over setStat(...) method of super class
	 */
	public void setStat(Stat elseIfOrElse) {
		this.elseIfOrElse = elseIfOrElse;
	}
	
	public void exec(Env env, Scope scope, Writer writer) {
		if (Logic.isTrue(cond.eval(scope))) {
			stat.exec(env, scope, writer);
		} else if (elseIfOrElse != null) {
			elseIfOrElse.exec(env, scope, writer);
		}
	}
}





