/**
 * @author manish goel
 *
 */
package com.jmuscles.async.consumer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jmuscles.props.util.RefreshBeansUtil;

/**
 * 
 */
@Component
@RefreshScope
public class RefreshBeans implements BeanFactoryAware {

	public static final String[] BEANS_ARRAY = new String[] { "refreshBeanDbProps", "refreshBeanProps",
			"refreshBeanProcessing", "refreshBeanProducer", "refreshBeanConsumer" };

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@EventListener(RefreshScopeRefreshedEvent.class)
	public void handleRefreshEvent() {
		RefreshBeansUtil.refresh(BEANS_ARRAY, beanFactory);
	}

}
