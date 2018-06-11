package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomVariable {

	private String name;
	private String value;
	@JsonProperty("_destroy")
	private Boolean _destroy;

	public CustomVariable() {
	}

	public CustomVariable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public Boolean getDestroy() {
		return _destroy;
	}

	public void setDestroy(Boolean _destroy) {
		this._destroy = _destroy;
	}

}
