package de.tba.schilling.framework;

public interface Model {

	public String getStr( String key );

	public void setStr( String key, String value );

	public Integer getInt( String key );

	public void setInt( String key, int value );

	public Double getDbl( String key );

	public void setDbl( String key, double value );
}
