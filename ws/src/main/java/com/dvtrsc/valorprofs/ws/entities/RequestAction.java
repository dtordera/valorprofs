package com.dvtrsc.valorprofs.ws.entities;

/*
 * RequestAction. Basic functional interface, used as lambda expression, to pass functionality & scope inside BaseResource
 */
public abstract interface RequestAction<T extends BaseResponse, Q extends ProfiledParameters>
{
	public abstract T doAction(Q paramQ);
}
