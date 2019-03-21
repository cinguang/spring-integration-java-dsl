/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.dsl.jms;

import java.util.concurrent.Executor;

import javax.jms.ConnectionFactory;

import org.springframework.integration.jms.AbstractJmsChannel;
import org.springframework.integration.jms.SubscribableJmsChannel;
import org.springframework.integration.jms.config.JmsChannelFactoryBean;
import org.springframework.jms.listener.AbstractMessageListenerContainer;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.ErrorHandler;

/**
 * A {@link JmsMessageChannelSpec} for subscribable {@link AbstractJmsChannel}s.
 *
 * @author Artem Bilan
 */
public class JmsMessageChannelSpec<S extends JmsMessageChannelSpec<S>> extends JmsPollableMessageChannelSpec<S> {

	JmsMessageChannelSpec(ConnectionFactory connectionFactory) {
		super(new JmsChannelFactoryBean(true), connectionFactory);
	}

	/**
	 * Configure the type of the container; must be an
	 * {@link AbstractMessageListenerContainer}. Defaults to
	 * {@link DefaultMessageListenerContainer}.
	 * @param containerType the containerType.
	 * @return the current {@link JmsMessageChannelSpec}.
	 */
	public S containerType(Class<? extends AbstractMessageListenerContainer> containerType) {
		this.jmsChannelFactoryBean.setContainerType(containerType);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}
	 * or a {@link org.springframework.jms.listener.SimpleMessageListenerContainer}.
	 * @param concurrentConsumers the concurrentConsumers.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setConcurrentConsumers(int)
	 * @see org.springframework.jms.listener.SimpleMessageListenerContainer#setConcurrentConsumers(int)
	 */
	public S concurrentConsumers(int concurrentConsumers) {
		this.jmsChannelFactoryBean.setConcurrentConsumers(concurrentConsumers);
		return _this();
	}

	/**
	 * @param maxSubscribers the maxSubscribers.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see SubscribableJmsChannel#setMaxSubscribers(int)
	 */
	public S maxSubscribers(int maxSubscribers) {
		this.jmsChannelFactoryBean.setMaxSubscribers(maxSubscribers);
		return _this();
	}

	/**
	 * @param autoStartup the autoStartup.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see org.springframework.context.SmartLifecycle
	 */
	public S autoStartup(boolean autoStartup) {
		this.jmsChannelFactoryBean.setAutoStartup(autoStartup);
		return _this();
	}

	/**
	 * @param phase the phase.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see org.springframework.context.SmartLifecycle
	 */
	public S phase(int phase) {
		this.jmsChannelFactoryBean.setPhase(phase);
		return _this();
	}

	/**
	 * @param errorHandler the errorHandler.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see AbstractMessageListenerContainer#setErrorHandler(ErrorHandler)
	 */
	public S errorHandler(ErrorHandler errorHandler) {
		this.jmsChannelFactoryBean.setErrorHandler(errorHandler);
		return _this();
	}

	/**
	 * @param exposeListenerSession the exposeListenerSession.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see AbstractMessageListenerContainer#setExposeListenerSession(boolean)
	 */
	public S exposeListenerSession(boolean exposeListenerSession) {
		this.jmsChannelFactoryBean.setExposeListenerSession(exposeListenerSession);
		return _this();
	}

	/**
	 * @param acceptMessagesWhileStopping the acceptMessagesWhileStopping.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see AbstractMessageListenerContainer#setAcceptMessagesWhileStopping(boolean)
	 */
	public S acceptMessagesWhileStopping(boolean acceptMessagesWhileStopping) {
		this.jmsChannelFactoryBean.setAcceptMessagesWhileStopping(acceptMessagesWhileStopping);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}.
	 * @param idleTaskExecutionLimit the idleTaskExecutionLimit.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setIdleTaskExecutionLimit(int)
	 */
	public S idleTaskExecutionLimit(int idleTaskExecutionLimit) {
		this.jmsChannelFactoryBean.setIdleTaskExecutionLimit(idleTaskExecutionLimit);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}.
	 * @param maxMessagesPerTask the maxMessagesPerTask.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setMaxMessagesPerTask(int)
	 */
	public S maxMessagesPerTask(int maxMessagesPerTask) {
		this.jmsChannelFactoryBean.setMaxMessagesPerTask(maxMessagesPerTask);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}.
	 * @param recoveryInterval the recoveryInterval.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setRecoveryInterval(long)
	 */
	public S recoveryInterval(long recoveryInterval) {
		this.jmsChannelFactoryBean.setRecoveryInterval(recoveryInterval);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}
	 * or a {@link org.springframework.jms.listener.SimpleMessageListenerContainer}.
	 * @param taskExecutor the taskExecutor.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setTaskExecutor(Executor)
	 * @see org.springframework.jms.listener.SimpleMessageListenerContainer#setTaskExecutor(Executor)
	 */
	public S taskExecutor(Executor taskExecutor) {
		this.jmsChannelFactoryBean.setTaskExecutor(taskExecutor);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}.
	 * @param transactionManager the transactionManager.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setTransactionManager(PlatformTransactionManager)
	 */
	public S transactionManager(PlatformTransactionManager transactionManager) {
		this.jmsChannelFactoryBean.setTransactionManager(transactionManager);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}.
	 * @param transactionName the transactionName.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setTransactionName(String)
	 */
	public S transactionName(String transactionName) {
		this.jmsChannelFactoryBean.setTransactionName(transactionName);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a {@link DefaultMessageListenerContainer}.
	 * @param transactionTimeout the transactionTimeout.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see DefaultMessageListenerContainer#setTransactionTimeout(int)
	 */
	public S transactionTimeout(int transactionTimeout) {
		this.jmsChannelFactoryBean.setTransactionTimeout(transactionTimeout);
		return _this();
	}

	/**
	 * Only applies if the {@link #containerType(Class)} is a
	 * {@link DefaultMessageListenerContainer}.
	 * @param cacheLevel the value for {@code DefaultMessageListenerContainer.cacheLevel}
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see org.springframework.jms.listener.DefaultMessageListenerContainer#setCacheLevel(int)
	 */
	public S cacheLevel(Integer cacheLevel) {
		this.jmsChannelFactoryBean.setCacheLevel(cacheLevel);
		return _this();
	}

	/**
	 * @param subscriptionShared the subscription shared {@code boolean} flag.
	 * @return the current {@link JmsMessageChannelSpec}.
	 * @see org.springframework.jms.listener.DefaultMessageListenerContainer#setSubscriptionShared
	 * @since 1.1.1
	 */
	public S subscriptionShared(boolean subscriptionShared) {
		this.jmsChannelFactoryBean.setSubscriptionShared(subscriptionShared);
		return _this();
	}

}
