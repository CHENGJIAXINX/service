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

package org.tio.jfinal.template.expr.ast;

import org.tio.jfinal.template.TemplateException;
import org.tio.jfinal.template.expr.Sym;
import org.tio.jfinal.template.stat.Location;
import org.tio.jfinal.template.stat.ParseException;
import org.tio.jfinal.template.stat.Scope;

/**
 * Logic
 * 
 * 支持逻辑运算： !  &&  ||
 */
public class Logic extends Expr {
	
	private Sym op;
	private Expr left;		// ! 运算没有 left 参数
	private Expr right;
	
	/**
	 * 构造 || && 结点
	 */
	public Logic(Sym op, Expr left, Expr right, Location location) {
		if (left == null) {
			throw new ParseException("The target of \"" + op.value() + "\" operator on the left side can not be blank", location);
		}
		if (right == null) {
			throw new ParseException("The target of \"" + op.value() + "\" operator on the right side can not be blank", location);
		}
		this.op = op;
		this.left = left;
		this.right = right;
		this.location = location;
	}
	
	/**
	 * 构造 ! 结点，left 为 null
	 */
	public Logic(Sym op, Expr right, Location location) {
		if (right == null) {
			throw new ParseException("The target of \"" + op.value() + "\" operator on the right side can not be blank", location);
		}
		this.op = op;
		this.left = null;
		this.right = right;
		this.location = location;
	}
	
	public Object eval(Scope scope) {
		switch (op) {
		case NOT:
			return evalNot(scope);
		case AND:
			return evalAnd(scope);
		case OR:
			return evalOr(scope);
		default:
			throw new TemplateException("Unsupported operator: " + op.value(), location);
		}
	}
	
	Object evalNot(Scope scope) {
		return ! isTrue(right.eval(scope));
	}
	
	Object evalAnd(Scope scope) {
		return isTrue(left.eval(scope)) && isTrue(right.eval(scope));
	}
	
	Object evalOr(Scope scope) {
		return isTrue(left.eval(scope)) || isTrue(right.eval(scope));
	}
	
	/**
	 * 规则：
	 * 1：null 返回 false
	 * 2：boolean 类型，原值返回
	 * 3：String、StringBuilder 等一切继承自 CharSequence 类的对象，返回 length > 0
	 * 4：其它返回 true
	 * 
	 * 通过 Logic.setToOldWorkMode() 设置，可支持老版本中的以下四个规则：
	 * 1：Number 类型，返回 value != 0
	 * 2：Map、Collection(List被包括在内) 返回 size() > 0
	 * 3：数组，返回 length > 0
	 * 4：Iterator 返回 hasNext() 值
	 */
	public static boolean isTrue(Object v) {
		if (v == null) {
			return false;
		}
		
		if (v instanceof Boolean) {
			return (Boolean)v;
		}
		if (v instanceof CharSequence) {
			return ((CharSequence)v).length() > 0;
		}
		
		return true;
	}
	
	public static boolean isFalse(Object v) {
		return !isTrue(v);
	}
}



