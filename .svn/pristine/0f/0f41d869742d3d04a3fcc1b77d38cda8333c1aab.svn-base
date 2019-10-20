package com.bang.invoice_ver.base.exception;

import com.bang.invoice_ver.base.IReturnInfo;

/**
 * 异常类处理基类
 */
public class IVException extends RuntimeException {
	/** default sid **/
	private static final long serialVersionUID = -3316241439076307461L;

	/** 返回代码枚举类型 **/
	protected IReturnInfo retInfo;

	/** 异常堆栈 */
	protected Throwable throwable;

	public IReturnInfo getRetInfo() {
		return retInfo;
	}

	public void setRetInfo(IReturnInfo retInfo) {
		this.retInfo = retInfo;
	}

	public IVException(IReturnInfo returnInfo) {
		super(returnInfo.getReturnCodeInfoByCode(returnInfo).toString());
		retInfo = returnInfo.getReturnCodeInfoByCode(returnInfo);
	}

	public IVException(IReturnInfo returnInfo, Throwable throwable) {
		super(returnInfo.getReturnCodeInfoByCode(returnInfo).toString());
		this.throwable = throwable;
		retInfo = returnInfo.getReturnCodeInfoByCode(returnInfo);
	}
}