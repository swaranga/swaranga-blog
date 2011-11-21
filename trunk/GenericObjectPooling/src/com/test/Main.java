package com.test;
import java.sql.Connection;

import com.test.pool.Pool;
import com.test.pool.PoolFactory;


public class Main
{
	public static void main(String[] args)
        {
		Pool<Connection> pool = 
			PoolFactory.newBoundedBlockingPool(
				10, 
				new JDBCConnectionFactory("", "", "", ""), 
				new JDBCConnectionValidator());
		
		//do whatever you like
        }
}
