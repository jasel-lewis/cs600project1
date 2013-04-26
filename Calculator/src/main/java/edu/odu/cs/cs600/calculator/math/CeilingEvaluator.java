package edu.odu.cs.cs600.calculator.math;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CeilingEvaluator implements IUnaryEvaluator {

	private static Logger logger = LogManager.getLogger(CeilingEvaluator.class);

	public double compute(double value) throws ArithmeticException
	{
		logger.error("Ceiling function has not yet been completed and is using a JAVA OOTB function right now.");
		return Math.ceil(value);
	}
	
}
