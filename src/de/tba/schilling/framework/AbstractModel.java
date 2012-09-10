package de.tba.schilling.framework;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModel implements Model {
	private Map<String, String> strValues = new HashMap<String, String>();
	private Map<String, Integer> intValues = new HashMap<String, Integer>();
	private Map<String, Double> dblValues = new HashMap<String, Double>();

	public String getStr(String key) {
		return strValues.get(key);
	}

	public void setStr(String key, String value) {
		strValues.put(key, value);
	}

	public Integer getInt(String key) {
		return intValues.get(key);
	}

	public void setInt(String key, int value) {
		intValues.put(key, value);
	}

	public Double getDbl(String key) {
		return dblValues.get(key);
	}

	public void setDbl(String key, double value) {
		dblValues.put(key, value);
	}

}
