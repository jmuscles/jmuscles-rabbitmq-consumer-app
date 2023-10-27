/**
 * 
 */
package com.jmuscles.async.consumer.customization.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.jmuscles.processing.executor.CustomExecutor;
import com.jmuscles.processing.executor.CustomExecutorRegistry;
import com.jmuscles.processing.schema.requestdata.CustomRequestData;

/**
 * @author Manish Goel
 *
 */
//@Component
//@DependsOn("consumerProcessingBeans")
public class DemoCustomExecutor extends CustomExecutor {

	private static final Logger logger = LoggerFactory.getLogger(DemoCustomExecutor.class);

	public DemoCustomExecutor(CustomExecutorRegistry executorRegistry) {
		super(executorRegistry);
	}

	@Override
	public CustomRequestData execute(CustomRequestData requestData) {
		DemoCustomRequestData data = (DemoCustomRequestData) requestData.getData();
		logger.info("Executing CustomizedExecutor for " + data);

		if (data.getAttribute1().equals("success")) {
			return null;
		} else {
			return requestData;
		}
	}

	@Override
	public String getExecutorConfigKey() {
		return null;
	}

}
