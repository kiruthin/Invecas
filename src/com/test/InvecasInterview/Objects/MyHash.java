package com.test.InvecasInterview.Objects;

import java.util.HashMap;

public class MyHash extends HashMap<String, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * (non-Javadoc)
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
    public Integer put(String key, Integer value) {
		if(this.containsKey(key))
		{
			return super.put(key, value+this.get(key));
		}
		else
		{
           return super.put(key, value);
		}
    }
}
