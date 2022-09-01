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
import org.tio.jfinal.template.io.Writer;
import org.tio.jfinal.template.stat.Ctrl;
import org.tio.jfinal.template.stat.Location;
import org.tio.jfinal.template.stat.ParseException;
import org.tio.jfinal.template.stat.Scope;

/**
 * SetLocal 设置局部变量
 * 
 * 通常用于 #define #include 指令内部需要与外层作用域区分，以便于定义重用型模块的场景
 * 也常用于 #for 循环内部的临时变量
 */
public class SetLocal  extends Stat {
	
	final Expr expr;
	
	public SetLocal(ExprList exprList, Location location) {
		if (exprList.length() == 0) {
			throw new ParseException("The parameter of #setLocal directive can not be blank", location);
		}
		
		/* 放开对表达式类型的限定
		for (Expr expr : exprList.getExprArray()) {
			if ( !(expr instanceof Assign || expr instanceof IncDec) ) {
				throw new ParseException("#setLocal directive only supports assignment expressions", location);
			}
		}*/
		
		this.expr = exprList.getActualExpr();
	}
	
	public void exec(Env env, Scope scope, Writer writer) {
		Ctrl ctrl = scope.getCtrl();
		try {
			ctrl.setLocalAssignment();
			expr.eval(scope);
		} finally {
			ctrl.setWisdomAssignment();
		}
	}
}





