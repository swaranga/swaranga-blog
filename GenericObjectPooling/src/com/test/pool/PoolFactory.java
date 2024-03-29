package com.test.pool;

import com.test.pool.Pool.Validator;

/**
 * Factory and utility methods for {@link Pool} and {@link BlockingPool} classes defined in this
 * package. This class supports the following kinds of methods:
 *
 * <ul>
 *   <li> Method that creates and returns a default non-blocking 
 *        implementation of the {@link Pool} interface.
 *   <li> Method that creates and returns a default implementation of 
 *        the {@link BlockingPool} interface.
 * </ul>
 *
 * @author Swaranga
 */

public final class PoolFactory
{
	private PoolFactory()
	{
		
	}
	
	/**
	 * Creates a and returns a new object pool,
	 * that is an implementation of the {@link BlockingPool}, 
	 * whose size is limited by the <TT>size</TT> parameter.
	 * 
	 * @param size the number of objects in the pool.
	 * @param factory the factory to create new objects.
	 * @param validator the validator to validate the re-usability of returned objects.
	 * 
	 * @return a blocking object pool bounded by <TT>size</TT>
	 */
	public static <T> Pool<T> newBoundedBlockingPool(int size, ObjectFactory<T> factory, Validator<T> validator)
	{
		return new BoundedBlockingPool<T>(size, validator, factory);
	}
	
	/**
	 * Creates a and returns a new object pool,
	 * that is an implementation of the {@link Pool} 
	 * whose size is limited by the <TT>size</TT> parameter.
	 * 
	 * @param size the number of objects in the pool.
	 * @param factory the factory to create new objects.
	 * @param validator the validator to validate the re-usability of returned objects.
	 * 
	 * @return an object pool bounded by <TT>size</TT>
	 */
	
	public static <T> Pool<T> newBoundedNonBlockingPool(int size, ObjectFactory<T> factory, Validator<T> validator)
	{
		return new BoundedPool<T>(size, validator, factory);
	}
}
